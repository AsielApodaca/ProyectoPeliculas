package interfacesDAO;

import entidades.PeliculaEntity;
import entidades.RentaEntity;
import entidades.UsuarioEntity;
import excepciones.PersistenciaException;
import java.util.Date;
import java.util.List;
import org.bson.Document;

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
    public RentaEntity crear(RentaEntity re) throws PersistenciaException;

    /**
     * Obtiene una renta del sistema según un criterio especificado.
     * 
     * @param re la renta que se desea obtener
     * @return la renta obtenida
     * @throws PersistenciaException si ocurre un error durante la obtención de la renta
     */
    public RentaEntity obtener(RentaEntity re) throws PersistenciaException;

    /**
     * Modifica una renta existente en el sistema.
     * 
     * @param re la renta a modificar
     * @return true si la renta fue modificada exitosamente, false en caso contrario
     * @throws PersistenciaException si ocurre un error durante la modificación de la renta
     */
    public boolean modificar(RentaEntity re) throws PersistenciaException;

    /**
     * Elimina una renta del sistema.
     * 
     * @param re la renta a eliminar
     * @return true si la renta fue eliminada exitosamente, false en caso contrario
     * @throws PersistenciaException si ocurre un error durante la eliminación de la renta
     */
    public boolean eliminar(RentaEntity re) throws PersistenciaException;
    
    /**
     * Obtiene todas las rentas realizadas en una fecha específica.
     * 
     * @param fecha la fecha para la cual se desean obtener las rentas
     * @return una lista de rentas realizadas en la fecha especificada
     * @throws PersistenciaException si ocurre un error durante la obtención de las rentas
     */
    public List<RentaEntity> obtenerPorFecha(Date fecha) throws PersistenciaException;
    
    /**
     * Obtiene la última renta realizada por un usuario específico.
     * 
     * @param ue el usuario para el cual se desea obtener la última renta
     * @return la última renta realizada por el usuario especificado
     * @throws PersistenciaException si ocurre un error durante la obtención de la renta
     */
    public RentaEntity obtenerUltimaRentaPorUsuario(UsuarioEntity ue) throws PersistenciaException;
    
    /**
     * Obtiene la película más rentada en el sistema.
     * 
     * @return la película más rentada
     * @throws PersistenciaException si ocurre un error durante la obtención de la película más rentada
     */
    public RentaEntity obtenerPeliculaMasRentada() throws PersistenciaException;
    
    /**
     * Obtiene todos los usuarios que han rentado una película específica.
     * 
     * @param pe la película para la cual se desean obtener los usuarios que la han rentado
     * @return una lista de usuarios que han rentado la película especificada
     * @throws PersistenciaException si ocurre un error durante la obtención de los usuarios
     */
    public List<UsuarioEntity> obtenerUsuariosPorPelicula(PeliculaEntity pe) throws PersistenciaException;
    
    /**
     * Calcula los ingresos generados por la renta de una película específica.
     * 
     * @param pe la película para la cual se desean calcular los ingresos
     * @return el total de ingresos generados por la renta de la película especificada
     * @throws PersistenciaException si ocurre un error durante el cálculo de los ingresos
     */
    public double calcularIngresosPorPelicula(PeliculaEntity pe) throws PersistenciaException;
    
    /**
     * Obtiene todas las rentas realizadas por un usuario en un rango de fechas específico.
     * 
     * @param ue el usuario para el cual se desean obtener las rentas
     * @param desde la fecha de inicio del rango
     * @param hasta la fecha de fin del rango
     * @return una lista de rentas realizadas por el usuario en el rango de fechas especificado
     * @throws PersistenciaException si ocurre un error durante la obtención de las rentas
     */
    public List<RentaEntity> obtenerPorUsuarioYRangoFechas(UsuarioEntity ue, Date desde, Date hasta) throws PersistenciaException;
    
    /**
     * Obtiene un documento que contiene el número de rentas realizadas por día.
     * 
     * @return un documento con el número de rentas por día
     * @throws PersistenciaException si ocurre un error durante la obtención de las rentas
     */
    public Document obtenerRentasPorDia() throws PersistenciaException;
    
    /**
     * Obtiene un documento que contiene información sobre los usuarios más activos en términos de número de rentas.
     * 
     * @return un documento con información sobre los usuarios más activos
     * @throws PersistenciaException si ocurre un error durante la obtención de los usuarios
     */
    public Document obtenerUsuariosMasActivos() throws PersistenciaException;
    
    /**
     * Obtiene una lista de películas que no han sido rentadas.
     * 
     * @return una lista de películas no rentadas
     * @throws PersistenciaException si ocurre un error durante la obtención de las películas
     */
    public List<PeliculaEntity> obtenerNoRentadas() throws PersistenciaException;
}
