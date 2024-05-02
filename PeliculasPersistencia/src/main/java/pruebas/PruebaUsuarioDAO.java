package pruebas;

import DAO.UsuarioDAO;
import entidades.UsuarioEntity;
import excepciones.PersistenciaException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class PruebaUsuarioDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UsuarioDAO u = new UsuarioDAO();
        
        UsuarioEntity usuario = new UsuarioEntity("JUAN", "potro@potro.com", new Date());
        try {
            u.crearUsuario(usuario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebaUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
