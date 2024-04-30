package interfacesDAO;

import entidades.RentaEntity;
import excepciones.PersistenciaException;

/**
 * Interfaz que define las operaciones para acceder y manipular datos de rentas en el sistema.
 * Las clases que implementen esta interfaz proporcionarán la funcionalidad necesaria para crear, leer, actualizar y eliminar rentas.
 * 
 * Esta interfaz proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre objetos de tipo RentaEntity.
 * 
 * @author Asiel Apodaca Monge
 */
public interface IRentaDAO {

    /**
     * Crea una nueva renta en el sistema.
     * 
     * @param re la renta a crear
     * @return la renta creada
     * @throws PersistenciaException si ocurre un error durante la creación de la renta
     */
    public RentaEntity crearRenta(RentaEntity re) throws PersistenciaException;

    /**
     * Obtiene una renta del sistema según un criterio especificado.
     * 
     * @param re la renta que se desea obtener
     * @return la renta obtenida
     * @throws PersistenciaException si ocurre un error durante la obtención de la renta
     */
    public RentaEntity obtenerRenta(RentaEntity re) throws PersistenciaException;

    /**
     * Modifica una renta existente en el sistema.
     * 
     * @param re la renta a modificar
     * @return true si la renta fue modificada exitosamente, false en caso contrario
     * @throws PersistenciaException si ocurre un error durante la modificación de la renta
     */
    public boolean modificarRenta(RentaEntity re) throws PersistenciaException;

    /**
     * Elimina una renta del sistema.
     * 
     * @param re la renta a eliminar
     * @return true si la renta fue eliminada exitosamente, false en caso contrario
     * @throws PersistenciaException si ocurre un error durante la eliminación de la renta
     */
    public boolean eliminarRenta(RentaEntity re) throws PersistenciaException;
}
