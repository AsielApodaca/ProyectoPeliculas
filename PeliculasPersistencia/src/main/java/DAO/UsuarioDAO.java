package DAO;

import com.mongodb.client.MongoCollection;
import entidades.UsuarioEntity;
import excepciones.PersistenciaException;
import interfacesDAO.IUsuarioDAO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class UsuarioDAO implements IUsuarioDAO{
    
    private MongoCollection<UsuarioEntity> coleccionUsuario;
    private final String nombreCol;

    public UsuarioDAO() {
        this.nombreCol = "Usuarios";
        this.coleccionUsuario = conexionBD.ConexionMongo.obtenerBaseDeDatos().getCollection(nombreCol, UsuarioEntity.class);
    }

    @Override
    public UsuarioEntity crearRenta(UsuarioEntity ue) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsuarioEntity obtenerRenta(UsuarioEntity ue) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificarRenta(UsuarioEntity ue) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarRenta(UsuarioEntity ue) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
