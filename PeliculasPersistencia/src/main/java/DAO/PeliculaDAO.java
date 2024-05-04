package DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import entidades.PeliculaEntity;
import excepciones.PersistenciaException;
import interfacesDAO.IPeliculaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class PeliculaDAO implements IPeliculaDAO{

    private static final Logger LOG = Logger.getLogger(PeliculaDAO.class.getName());
    private MongoCollection<PeliculaEntity> coleccion;
    private final String nombreCol;

    public PeliculaDAO() {
        this.nombreCol = "Peliculas";
        this.coleccion = conexionBD.ConexionMongo.obtenerBaseDeDatos().getCollection(nombreCol, PeliculaEntity.class);
    }
    
    @Override
    public PeliculaEntity crear(PeliculaEntity pe) throws PersistenciaException {
        try {
            if(pe == null) throw new PersistenciaException("La entidad de pelicula del parámetro es nulo");
            coleccion.insertOne(pe);
            return pe;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al crear una pelicula.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }

    @Override
    public PeliculaEntity obtener(PeliculaEntity pe) throws PersistenciaException {
        try {
            if(pe == null) throw new PersistenciaException("La entidad de pelicula del parámetro es nulo.");
            if(pe.getId() != null) return coleccion.find(Filters.eq("_id", pe.getId())).first();
            throw new PersistenciaException("La entidad de pelicula del parámetro debe contar con un id para ser identificado.");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al buscar una pelicula.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }

    @Override
    public boolean modificar(PeliculaEntity pe) throws PersistenciaException {
        try {
            
            if(pe == null) throw new PersistenciaException("La entidad de pelicula del parámetro es nulo.");
            if(pe.getId() == null) throw new PersistenciaException("El atributo id de la entidad pelicula del parámetro es nulo.");
            coleccion.replaceOne(Filters.eq("_id", pe.getId()), pe);
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al intentar modificar una pelicula.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return false;
        }
    }

    @Override
    public boolean eliminar(PeliculaEntity pe) throws PersistenciaException {
        try {
            if(pe == null) throw new PersistenciaException("La entidad de pelicula del parámetro es nulo.");
            if(pe.getId() == null) throw new PersistenciaException("El atributo id de la entidad pelicula del parámetro es nulo.");
            coleccion.deleteOne(Filters.eq("_id", pe.getId()));
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al intentar eliminar una pelicula.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return false;
        }
    }

    @Override
    public List<PeliculaEntity> obtenerConCalificacionMayorA(Integer calificacion) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PeliculaEntity> obtenerNoRentadas() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
