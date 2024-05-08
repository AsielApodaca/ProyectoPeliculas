package DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import entidades.PeliculaEntity;
import entidades.RentaEntity;
import entidades.UsuarioEntity;
import entidades.estadoRenta;
import excepciones.PersistenciaException;
import interfacesDAO.IRentaDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class RentaDAO implements IRentaDAO{

    private static final Logger LOG = Logger.getLogger(RentaDAO.class.getName());
    private MongoCollection<RentaEntity> coleccion;
    private final String nombreCol;

    public RentaDAO() {
        this.nombreCol = "Rentas";
        this.coleccion = conexionBD.ConexionMongo.obtenerBaseDeDatos().getCollection(nombreCol, RentaEntity.class);
    }

    @Override
    public RentaEntity crear(RentaEntity re) throws PersistenciaException {
        try {
            if(re == null) throw new PersistenciaException("La entidad de renta del parámetro es nulo");
            coleccion.insertOne(re);
            return re;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al crear una renta.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }

    @Override
    public RentaEntity obtener(RentaEntity re) throws PersistenciaException {
        try {
            if(re == null) throw new PersistenciaException("La entidad de renta del parámetro es nulo.");
            if(re.getId() != null) return coleccion.find(Filters.eq("_id", re.getId())).first();
            throw new PersistenciaException("La entidad de renta del parámetro debe contar con un id para ser identificado.");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al buscar una pelicula.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }

    @Override
    public boolean modificar(RentaEntity re) throws PersistenciaException {
        try {
            
            if(re == null) throw new PersistenciaException("La entidad de renta del parámetro es nulo.");
            if(re.getId() == null) throw new PersistenciaException("El atributo id de la entidad renta del parámetro es nulo.");
            coleccion.replaceOne(Filters.eq("_id", re.getId()), re);
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al intentar modificar una renta.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return false;
        }
    }

    @Override
    public boolean eliminar(RentaEntity re) throws PersistenciaException {
        try {
            if(re == null) throw new PersistenciaException("La entidad de renta del parámetro es nulo.");
            if(re.getId() == null) throw new PersistenciaException("El atributo id de la entidad renta del parámetro es nulo.");
            coleccion.deleteOne(Filters.eq("_id", re.getId()));
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al intentar eliminar una renta.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return false;
        }
    }

    @Override
    public List<RentaEntity> obtenerPorFecha(Date fecha) throws PersistenciaException {
        try {
            List<RentaEntity> rentasPorFecha = new ArrayList<>();
            coleccion.aggregate(Arrays.asList(
                    Aggregates.match(Filters.eq("fechaRenta", fecha))
            )).into(rentasPorFecha);
            return rentasPorFecha;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al buscar rentas por fecha.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }


    @Override
    public RentaEntity obtenerUltimaRentaPorUsuario(UsuarioEntity ue) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("usuarioID", ue.getId()))
                    .sort(Sorts.descending("fechaRenta"))
                    .first();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al buscar la última renta por usuario.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }


    @Override
    public RentaEntity obtenerPeliculaMasRentada() throws PersistenciaException {
        try {
            Document groupStage = new Document("_id", "$pelicuID")
                    .append("total", new Document("$sum", 1));

            Document sortStage = new Document("total", -1);

            Document projectStage = new Document("$project", new Document("pelicuID", "$_id")
                    .append("_id", 0)
                    .append("total", 1));

            return coleccion.aggregate(Arrays.asList(
                    Aggregates.group("$pelicuID", Accumulators.sum("total", 1)),
                    Aggregates.sort(Sorts.descending("total")),
                    Aggregates.limit(1),
                    Aggregates.project(Projections.fields(Projections.excludeId(), Projections.include("pelicuID", "total")))
            )).first();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al buscar la película más rentada.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }

    @Override
    public List<UsuarioEntity> obtenerUsuariosPorPelicula(PeliculaEntity pe) throws PersistenciaException {
        try {
            List<UsuarioEntity> usuarios = new ArrayList<>();
            List<ObjectId> usuariosIds = new ArrayList<>();

            // Obtener todas las rentas para la película especificada
            List<RentaEntity> rentas = coleccion.find(Filters.eq("pelicuID", pe.getId())).into(new ArrayList<>());

            // Obtener los identificadores únicos de los usuarios
            for (RentaEntity renta : rentas) {
                usuariosIds.add(renta.getUsuarioID());
            }

            // Buscar los usuarios en la colección de usuarios
            MongoCollection<UsuarioEntity> coleccionUsuarios = conexionBD.ConexionMongo.obtenerBaseDeDatos().getCollection("Usuarios", UsuarioEntity.class);
            coleccionUsuarios.find(Filters.in("_id", usuariosIds)).into(usuarios);

            return usuarios;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al buscar usuarios por película.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }


    @Override
    public double calcularIngresosPorPelicula(PeliculaEntity pe) throws PersistenciaException {
        try {
            double ingresos = 0;

            // Obtener todas las rentas para la película especificada
            List<RentaEntity> rentas = coleccion.find(Filters.eq("pelicuID", pe.getId())).into(new ArrayList<>());

            // Sumar los precios de todas las rentas
            for (RentaEntity renta : rentas) {
                ingresos += renta.getPrecio();
            }

            return ingresos;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al calcular ingresos por película.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return -1;
        }
    }


    @Override
    public List<RentaEntity> obtenerPorUsuarioYRangoFechas(UsuarioEntity ue, Date desde, Date hasta) throws PersistenciaException {
        try {
            List<RentaEntity> rentasPorUsuarioYFecha = new ArrayList<>();

            // Obtener todas las rentas para el usuario especificado dentro del rango de fechas
            List<RentaEntity> rentas = coleccion.find(Filters.and(
                    Filters.eq("usuarioID", ue.getId()),
                    Filters.gte("fechaRenta", desde),
                    Filters.lte("fechaRenta", hasta)
            )).into(new ArrayList<>());

            rentasPorUsuarioYFecha.addAll(rentas);

            return rentasPorUsuarioYFecha;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al buscar rentas por usuario y rango de fechas.");
            throw new PersistenciaException(e.getMessage());
        }
    }


    @Override
    public Document obtenerRentasPorDia() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Document obtenerUsuariosMasActivos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PeliculaEntity> obtenerNoRentadas() throws PersistenciaException {
        try {
            MongoCollection<PeliculaEntity> coleccionPeliculas = conexionBD.ConexionMongo.obtenerBaseDeDatos().getCollection("Peliculas", PeliculaEntity.class);
            List<PeliculaEntity> peliculasNoRentadas = new ArrayList<>();
            List<ObjectId> peliculasEnRentaIds = new ArrayList<>();
            List<RentaEntity> rentas = coleccion.find().into(new ArrayList<>());
            for(RentaEntity renta : rentas) {
                peliculasEnRentaIds.add(renta.getPelicuID());
            }
            
            List<PeliculaEntity> peliculas = coleccionPeliculas.find().into(new ArrayList<>());
            for(PeliculaEntity pelicula : peliculas) {
                if(!peliculasEnRentaIds.contains(pelicula.getId())) {
                    peliculasNoRentadas.add(pelicula);
                }
            }
            
            return peliculasNoRentadas;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al buscar películas no rentadas.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }
}
