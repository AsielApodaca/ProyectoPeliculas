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
        
        // Mi rata de pruebas :)
        UsuarioEntity usuario = new UsuarioEntity("JUAN", "potro@potro.com", new Date());
        
        
        // crearUsuario
        try {
           usuario = u.crear(usuario);
           if(usuario != null) {
               System.out.println("El usuario se insertó en la base de datos:");
               System.out.println("ID: " + usuario.getId());
               System.out.println();
           }
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebaUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // obtenerUsuario
        try {
            UsuarioEntity usuarioBuscado = new UsuarioEntity();
            usuarioBuscado.setId(usuario.getId());
            usuarioBuscado = u.obtener(usuarioBuscado);
            if(usuarioBuscado != null) {
               System.out.println("Se encontró un usuario:");
               System.out.println("Nombre: " + usuarioBuscado.getNombre());
               System.out.println();
           }
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebaUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
