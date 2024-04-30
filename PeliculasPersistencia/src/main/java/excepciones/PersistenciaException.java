package excepciones;

/**
 * Excepción personalizada para manejar errores relacionados con la persistencia de datos.
 * Esta excepción puede ser lanzada cuando ocurren errores durante la operación de persistencia.
 * Por ejemplo, errores al conectar con una base de datos, errores de consulta, etc.
 * 
 * @author Asiel Apodaca Monge
 */
public class PersistenciaException extends Exception {

    /**
     * Crea una nueva instancia de PersistenciaException sin un mensaje detallado.
     */
    public PersistenciaException() {
    }

    /**
     * Crea una nueva instancia de PersistenciaException con un mensaje detallado.
     * 
     * @param message el mensaje que describe la excepción
     */
    public PersistenciaException(String message) {
        super(message);
    }
}
