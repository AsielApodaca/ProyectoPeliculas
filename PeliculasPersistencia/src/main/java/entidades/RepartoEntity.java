package entidades;

/**
 * Clase que representa la entidad de un reparto en una película.
 * Esta clase almacena información sobre los personajes principales, secundarios y otros del reparto de una película.
 * 
 * @author Asiel Apodaca Monge
 */
public class RepartoEntity {
    private String personajePrincipal; // Nombre del personaje principal
    private String personajeSecundario; // Nombre del personaje secundario
    private String otro; // Otro personaje del reparto

    /**
     * Crea una nueva instancia de RepartoEntity sin inicializar sus atributos.
     */
    public RepartoEntity() {
    }

    /**
     * Crea una nueva instancia de RepartoEntity con valores específicos para sus atributos.
     * 
     * @param personajePrincipal el nombre del personaje principal
     * @param personajeSecundario el nombre del personaje secundario
     * @param otro otro personaje del reparto
     */
    public RepartoEntity(String personajePrincipal, String personajeSecundario, String otro) {
        this.personajePrincipal = personajePrincipal;
        this.personajeSecundario = personajeSecundario;
        this.otro = otro;
    }

    /**
     * Obtiene el nombre del personaje principal.
     * 
     * @return el nombre del personaje principal
     */
    public String getPersonajePrincipal() {
        return personajePrincipal;
    }

    /**
     * Establece el nombre del personaje principal.
     * 
     * @param personajePrincipal el nombre del personaje principal
     */
    public void setPersonajePrincipal(String personajePrincipal) {
        this.personajePrincipal = personajePrincipal;
    }

    /**
     * Obtiene el nombre del personaje secundario.
     * 
     * @return el nombre del personaje secundario
     */
    public String getPersonajeSecundario() {
        return personajeSecundario;
    }

    /**
     * Establece el nombre del personaje secundario.
     * 
     * @param personajeSecundario el nombre del personaje secundario
     */
    public void setPersonajeSecundario(String personajeSecundario) {
        this.personajeSecundario = personajeSecundario;
    }

    /**
     * Obtiene el otro personaje del reparto.
     * 
     * @return el otro personaje del reparto
     */
    public String getOtro() {
        return otro;
    }

    /**
     * Establece otro personaje del reparto.
     * 
     * @param otro otro personaje del reparto
     */
    public void setOtro(String otro) {
        this.otro = otro;
    }
}
