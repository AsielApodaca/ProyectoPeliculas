package entidades;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa la entidad de una película en el sistema.
 * Esta clase almacena información sobre una película, como su título, director, fecha de estreno, categorías, calificación, etc.
 * Además, incluye información sobre el reparto de la película.
 * 
 * @author Asiel Apodaca Monge
 */
public class PeliculaEntity {
    private ObjectId _id; // Identificador único de la película
    private String titulo; // Título de la película
    private String director; // Director de la película
    private String compania; // Compañía productora de la película
    private Date estreno; // Fecha de estreno de la película
    private List<String> categorias; // Lista de categorías de la película
    private Integer calificacion; // Calificación de la película
    private RepartoEntity reparto; // Información sobre el reparto de la película

    /**
     * Crea una nueva instancia de PeliculaEntity sin inicializar sus atributos.
     */
    public PeliculaEntity() {
    }

    /**
     * Crea una nueva instancia de PeliculaEntity con valores específicos para sus atributos.
     * 
     * @param _id el identificador único de la película
     * @param titulo el título de la película
     * @param director el director de la película
     * @param compania la compañía productora de la película
     * @param estreno la fecha de estreno de la película
     * @param categorias la lista de categorías de la película
     * @param calificacion la calificación de la película
     * @param reparto la información sobre el reparto de la película
     */
    public PeliculaEntity(ObjectId _id, String titulo, String director, String compania, Date estreno, List<String> categorias, Integer calificacion, RepartoEntity reparto) {
        this._id = _id;
        this.titulo = titulo;
        this.director = director;
        this.compania = compania;
        this.estreno = estreno;
        this.categorias = categorias;
        this.calificacion = calificacion;
        this.reparto = reparto;
    }

    /**
     * Obtiene el identificador único de la película.
     * 
     * @return el identificador único de la película
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el identificador único de la película.
     * 
     * @param _id el identificador único de la película
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el título de la película.
     * 
     * @return el título de la película
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la película.
     * 
     * @param titulo el título de la película
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el director de la película.
     * 
     * @return el director de la película
     */
    public String getDirector() {
        return director;
    }

    /**
     * Establece el director de la película.
     * 
     * @param director el director de la película
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Obtiene la compañía productora de la película.
     * 
     * @return la compañía productora de la película
     */
    public String getCompania() {
        return compania;
    }

    /**
     * Establece la compañía productora de la película.
     * 
     * @param compania la compañía productora de la película
     */
    public void setCompania(String compania) {
        this.compania = compania;
    }

    /**
     * Obtiene la fecha de estreno de la película.
     * 
     * @return la fecha de estreno de la película
     */
    public Date getEstreno() {
        return estreno;
    }

    /**
     * Establece la fecha de estreno de la película.
     * 
     * @param estreno la fecha de estreno de la película
     */
    public void setEstreno(Date estreno) {
        this.estreno = estreno;
    }

    /**
     * Obtiene la lista de categorías de la película.
     * 
     * @return la lista de categorías de la película
     */
    public List<String> getCategorias() {
        return categorias;
    }

    /**
     * Establece la lista de categorías de la película.
     * 
     * @param categorias la lista de categorías de la película
     */
    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    /**
     * Obtiene la calificación de la película.
     * 
     * @return la calificación de la película
     */
    public Integer getCalificacion() {
        return calificacion;
    }

    /**
     * Establece la calificación de la película.
     * 
     * @param calificacion la calificación de la película
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Obtiene la información sobre el reparto de la película.
     * 
     * @return la información sobre el reparto de la película
     */
    public RepartoEntity getReparto() {
        return reparto;
    }

    /**
     * Establece la información sobre el reparto de la película.
     * 
     * @param reparto la información sobre el reparto de la película
     */
    public void setReparto(RepartoEntity reparto) {
        this.reparto = reparto;
    }
}
