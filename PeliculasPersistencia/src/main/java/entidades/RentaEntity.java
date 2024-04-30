package entidades;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Clase que representa la entidad de una renta en el sistema.
 * Esta clase almacena información sobre una renta, como el identificador del usuario que realizó la renta,
 * el identificador de la película rentada, las fechas de renta y devolución, y el estado de la renta.
 * 
 * @author Asiel Apodaca Monge
 */
public class RentaEntity {
    private ObjectId _id; // Identificador único de la renta
    private ObjectId usuarioID; // Identificador del usuario que realizó la renta
    private ObjectId pelicuID; // Identificador de la película rentada
    private Date fechaRenta; // Fecha en que se realizó la renta
    private Date fechaDevolucion; // Fecha en que se devolvió la película
    private String estadoRenta; // Estado actual de la renta (por ejemplo, "activa" o "devuelta")

    /**
     * Crea una nueva instancia de RentaEntity sin inicializar sus atributos.
     */
    public RentaEntity() {
    }

    /**
     * Crea una nueva instancia sin id de RentaEntity con valores específicos para sus atributos.
     * 
     * @param usuarioID el identificador del usuario que realizó la renta
     * @param pelicuID el identificador de la película rentada
     * @param fechaRenta la fecha en que se realizó la renta
     * @param fechaDevolucion la fecha en que se devolvió la película
     * @param estadoRenta el estado actual de la renta
     */
    public RentaEntity(ObjectId usuarioID, ObjectId pelicuID, Date fechaRenta, Date fechaDevolucion, String estadoRenta) {
        this.usuarioID = usuarioID;
        this.pelicuID = pelicuID;
        this.fechaRenta = fechaRenta;
        this.fechaDevolucion = fechaDevolucion;
        this.estadoRenta = estadoRenta;
    }

    /**
     * Crea una nueva instancia de RentaEntity con valores específicos para sus atributos.
     * 
     * @param _id el identificador único de la renta
     * @param usuarioID el identificador del usuario que realizó la renta
     * @param pelicuID el identificador de la película rentada
     * @param fechaRenta la fecha en que se realizó la renta
     * @param fechaDevolucion la fecha en que se devolvió la película
     * @param estadoRenta el estado actual de la renta
     */
    public RentaEntity(ObjectId _id, ObjectId usuarioID, ObjectId pelicuID, Date fechaRenta, Date fechaDevolucion, String estadoRenta) {
        this._id = _id;
        this.usuarioID = usuarioID;
        this.pelicuID = pelicuID;
        this.fechaRenta = fechaRenta;
        this.fechaDevolucion = fechaDevolucion;
        this.estadoRenta = estadoRenta;
    }

    /**
     * Obtiene el identificador único de la renta.
     * 
     * @return el identificador único de la renta
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el identificador único de la renta.
     * 
     * @param _id el identificador único de la renta
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el identificador del usuario que realizó la renta.
     * 
     * @return el identificador del usuario que realizó la renta
     */
    public ObjectId getUsuarioID() {
        return usuarioID;
    }

    /**
     * Establece el identificador del usuario que realizó la renta.
     * 
     * @param usuarioID el identificador del usuario que realizó la renta
     */
    public void setUsuarioID(ObjectId usuarioID) {
        this.usuarioID = usuarioID;
    }

    /**
     * Obtiene el identificador de la película rentada.
     * 
     * @return el identificador de la película rentada
     */
    public ObjectId getPelicuID() {
        return pelicuID;
    }

    /**
     * Establece el identificador de la película rentada.
     * 
     * @param pelicuID el identificador de la película rentada
     */
    public void setPelicuID(ObjectId pelicuID) {
        this.pelicuID = pelicuID;
    }

    /**
     * Obtiene la fecha en que se realizó la renta.
     * 
     * @return la fecha en que se realizó la renta
     */
    public Date getFechaRenta() {
        return fechaRenta;
    }

    /**
     * Establece la fecha en que se realizó la renta.
     * 
     * @param fechaRenta la fecha en que se realizó la renta
     */
    public void setFechaRenta(Date fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    /**
     * Obtiene la fecha en que se devolvió la película.
     * 
     * @return la fecha en que se devolvió la película
     */
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Establece la fecha en que se devolvió la película.
     * 
     * @param fechaDevolucion la fecha en que se devolvió la película
     */
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Obtiene el estado actual de la renta.
     * 
     * @return el estado actual de la renta
     */
    public String getEstadoRenta() {
        return estadoRenta;
    }

    /**
     * Establece el estado actual de la renta.
     * 
     * @param estadoRenta el estado actual de la renta
     */
    public void setEstadoRenta(String estadoRenta) {
        this.estadoRenta = estadoRenta;
    }
}
