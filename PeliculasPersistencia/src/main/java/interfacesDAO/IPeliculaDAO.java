package interfacesDAO;

import entidades.PeliculaEntity;
import excepciones.PersistenciaException;
import java.util.List;

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
    public PeliculaEntity crear(PeliculaEntity pe) throws PersistenciaException;

    /**
     * Obtiene una película del sistema según un criterio especificado.
     * 
     * @param pe la película que se desea obtener
     * @return la película obtenida
     * @throws PersistenciaException si ocurre un error durante la obtención de la película
     */
    public PeliculaEntity obtener(PeliculaEntity pe) throws PersistenciaException;

    /**
     * Modifica una película existente en el sistema.
     * 
     * @param pe la película a modificar
     * @return true si la película fue modificada exitosamente, false en caso contrario
     * @throws PersistenciaException si ocurre un error durante la modificación de la película
     */
    public boolean modificar(PeliculaEntity pe) throws PersistenciaException;

    /**
     * Elimina una película del sistema.
     * 
     * @param pe la película a eliminar
     * @return true si la película fue eliminada exitosamente, false en caso contrario
     * @throws PersistenciaException si ocurre un error durante la eliminación de la película
     */
    public boolean eliminar(PeliculaEntity pe) throws PersistenciaException;
    
    /**
     * Obtiene una lista de películas con una calificación mayor a un valor específico.
     * 
     * @param calificacion el valor de calificación mínimo
     * @return una lista de películas con una calificación mayor a la especificada
     * @throws PersistenciaException si ocurre un error durante la obtención de las películas
     */
    public List<PeliculaEntity> obtenerConCalificacionMayorA(Integer calificacion) throws PersistenciaException;
    
    /**
     * Obtiene una lista de películas que no han sido rentadas.
     * 
     * @return una lista de películas no rentadas
     * @throws PersistenciaException si ocurre un error durante la obtención de las películas
     */
    public List<PeliculaEntity> obtenerNoRentadas() throws PersistenciaException;
}
