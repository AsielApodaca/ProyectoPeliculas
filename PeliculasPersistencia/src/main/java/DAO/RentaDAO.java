package DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import entidades.PeliculaEntity;
import entidades.RentaEntity;
import entidades.UsuarioEntity;
import excepciones.PersistenciaException;
import interfacesDAO.IRentaDAO;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RentaEntity obtenerUltimaRentaPorUsuario(UsuarioEntity ue) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RentaEntity obtenerPeliculaMasRentada() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UsuarioEntity> obtenerUsuariosPorPelicula(PeliculaEntity pe) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double calcularIngresosPorPelicula(PeliculaEntity pe) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RentaEntity> obtenerPorUsuarioYRangoFechas(UsuarioEntity ue, Date desde, Date hasta) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Document obtenerRentasPorDia() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Document obtenerUsuariosMasActivos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
