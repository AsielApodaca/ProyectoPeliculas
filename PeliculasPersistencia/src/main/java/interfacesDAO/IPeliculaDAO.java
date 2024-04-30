package interfacesDAO;

import entidades.PeliculaEntity;
import excepciones.PersistenciaException;

/**
 * Interfaz que define las operaciones para acceder y manipular datos de películas en el sistema.
 * Las clases que implementen esta interfaz proporcionarán la funcionalidad necesaria para crear, leer, actualizar y eliminar películas.
 * 
 * Esta interfaz proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre objetos de tipo PeliculaEntity.
 * 
 * @author Asiel Apodaca Monge
 */
public interface IPeliculaDAO {

    /**
     * Crea una nueva película en el sistema.
     * 
     * @param pe la película a crear
     * @return la película creada
     * @throws PersistenciaException si ocurre un error durante la creación de la película
     */
    public PeliculaEntity crearRenta(PeliculaEntity pe) throws PersistenciaException;

    /**
     * Obtiene una película del sistema según un criterio especificado.
     * 
     * @param pe la película que se desea obtener
     * @return la película obtenida
     * @throws PersistenciaException si ocurre un error durante la obtención de la película
     */
    public PeliculaEntity obtenerRenta(PeliculaEntity pe) throws PersistenciaException;

    /**
     * Modifica una película existente en el sistema.
     * 
     * @param pe la película a modificar
     * @return true si la película fue modificada exitosamente, false en caso contrario
     * @throws PersistenciaException si ocurre un error durante la modificación de la película
     */
    public boolean modificarRenta(PeliculaEntity pe) throws PersistenciaException;

    /**
     * Elimina una película del sistema.
     * 
     * @param pe la película a eliminar
     * @return true si la película fue eliminada exitosamente, false en caso contrario
     * @throws PersistenciaException si ocurre un error durante la eliminación de la película
     */
    public boolean eliminarRenta(PeliculaEntity pe) throws PersistenciaException;
}
