package interfacesDAO;

import entidades.UsuarioEntity;
import excepciones.PersistenciaException;

/**
 * Interfaz que define las operaciones para acceder y manipular datos de usuarios en el sistema.
 * Las clases que implementen esta interfaz proporcionarán la funcionalidad necesaria para crear, leer, actualizar y eliminar usuarios.
 * 
 * Esta interfaz proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre objetos de tipo UsuarioEntity.
 * 
 * @author Asiel Apodaca Monge
 */
public interface IUsuarioDAO {

    /**
     * Crea un nuevo usuario en el sistema.
     * 
     * @param ue el usuario a crear
     * @return el usuario creado
     * @throws PersistenciaException si ocurre un error durante la creación del usuario
     */
    public UsuarioEntity crearUsuario(UsuarioEntity ue) throws PersistenciaException;

    /**
     * Obtiene un usuario del sistema según un criterio especificado.
     * 
     * @param ue el usuario que se desea obtener
     * @return el usuario obtenido
     * @throws PersistenciaException si ocurre un error durante la obtención del usuario
     */
    public UsuarioEntity obtenerUsuario(UsuarioEntity ue) throws PersistenciaException;

    /**
     * Modifica un usuario existente en el sistema.
     * 
     * @param ue el usuario a modificar
     * @return true si el usuario fue modificado exitosamente, false en caso contrario
     * @throws PersistenciaException si ocurre un error durante la modificación del usuario
     */
    public boolean modificarUsuario(UsuarioEntity ue) throws PersistenciaException;

    /**
     * Elimina un usuario del sistema.
     * 
     * @param ue el usuario a eliminar
     * @return true si el usuario fue eliminado exitosamente, false en caso contrario
     * @throws PersistenciaException si ocurre un error durante la eliminación del usuario
     */
    public boolean eliminarUsuario(UsuarioEntity ue) throws PersistenciaException;
}
