package DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import entidades.UsuarioEntity;
import excepciones.PersistenciaException;
import interfacesDAO.IUsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class UsuarioDAO implements IUsuarioDAO{

    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class.getName());
    private MongoCollection<UsuarioEntity> coleccion;
    private final String nombreCol;

    public UsuarioDAO() {
        this.nombreCol = "Usuarios";
        this.coleccion = conexionBD.ConexionMongo.obtenerBaseDeDatos().getCollection(nombreCol, UsuarioEntity.class);
    }

    @Override
    public UsuarioEntity crearUsuario(UsuarioEntity ue) throws PersistenciaException {
        try {
            if(ue == null) throw new PersistenciaException("La entidad de usuario del parámetro es nulo");
            coleccion.insertOne(ue);
            return ue;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al crear un Usuario.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }

    @Override
    public UsuarioEntity obtenerUsuario(UsuarioEntity ue) throws PersistenciaException {
        try {
            if(ue == null) throw new PersistenciaException("La entidad de usuario del parámetro es nulo.");
            if(ue.getId() != null) return coleccion.find(Filters.eq("_id", ue.getId())).first();
            if(ue.getEmail() != null) return coleccion.find(Filters.eq("email", ue.getEmail())).first();
            throw new PersistenciaException("La entidad de usuario del parámetro debe contar con un id o un email para ser identificado.");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al buscar un Usuario.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return null;
        }
    }

    @Override
    public boolean modificarUsuario(UsuarioEntity ue) throws PersistenciaException {
        try {
            
            if(ue == null) throw new PersistenciaException("La entidad de usuario del parámetro es nulo.");
            if(ue.getId() == null) throw new PersistenciaException("El atributo id de la entidad usuario del parámetro es nulo.");
            coleccion.replaceOne(Filters.eq("_id", ue.getId()), ue);
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al intentar modificar un Usuario.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(UsuarioEntity ue) throws PersistenciaException {
        try {
            if(ue == null) throw new PersistenciaException("La entidad de usuario del parámetro es nulo.");
            if(ue.getId() == null) throw new PersistenciaException("El atributo id de la entidad usuario del parámetro es nulo.");
            coleccion.deleteOne(Filters.eq("_id", ue.getId()));
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error en la capa de persistencia al intentar eliminar un Usuario.");
            throw new PersistenciaException(e.getMessage());
        } finally {
            return false;
        }
    }

}
