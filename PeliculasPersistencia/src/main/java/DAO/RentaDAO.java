package DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import entidades.RentaEntity;
import excepciones.PersistenciaException;
import interfacesDAO.IRentaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public RentaEntity crearRenta(RentaEntity re) throws PersistenciaException {
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
    public RentaEntity obtenerRenta(RentaEntity re) throws PersistenciaException {
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
    public boolean modificarRenta(RentaEntity re) throws PersistenciaException {
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
    public boolean eliminarRenta(RentaEntity re) throws PersistenciaException {
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

}
