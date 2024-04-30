package entidades;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Clase que representa la entidad de un usuario en el sistema.
 * Esta clase almacena información sobre un usuario, como su nombre, correo electrónico y fecha de registro.
 * 
 * Además, utiliza la clase ObjectId de MongoDB para identificar de manera única a cada usuario en la base de datos.
 * 
 * @author Asiel Apodaca Monge
 */
public class UsuarioEntity {
    private ObjectId _id; // Identificador único del usuario
    private String nombre; // Nombre del usuario
    private String email; // Correo electrónico del usuario
    private Date fechaRegistro; // Fecha de registro del usuario

    /**
     * Crea una nueva instancia de UsuarioEntity sin inicializar sus atributos.
     */
    public UsuarioEntity() {
    }
    
    /**
     * Crea una nueva instancia de UsuarioEntity con valores específicos para sus atributos.
     * 
     * @param _id el identificador único del usuario
     * @param nombre el nombre del usuario
     * @param email el correo electrónico del usuario
     * @param fechaRegistro la fecha de registro del usuario
     */
    public UsuarioEntity(ObjectId _id, String nombre, String email, Date fechaRegistro) {
        this._id = _id;
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el identificador único del usuario.
     * 
     * @return el identificador único del usuario
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el identificador único del usuario.
     * 
     * @param _id el identificador único del usuario
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return el correo electrónico del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param email el correo electrónico del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la fecha de registro del usuario.
     * 
     * @return la fecha de registro del usuario
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece la fecha de registro del usuario.
     * 
     * @param fechaRegistro la fecha de registro del usuario
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
