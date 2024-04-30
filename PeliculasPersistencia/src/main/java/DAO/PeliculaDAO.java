package DAO;

import com.mongodb.client.MongoCollection;
import entidades.PeliculaEntity;
import excepciones.PersistenciaException;
import interfacesDAO.IPeliculaDAO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class PeliculaDAO implements IPeliculaDAO{

    private MongoCollection<PeliculaEntity> coleccionPelicula;
    private final String nombreCol;

    public PeliculaDAO() {
        this.nombreCol = "Peliculas";
        this.coleccionPelicula = conexionBD.ConexionMongo.obtenerBaseDeDatos().getCollection(nombreCol, PeliculaEntity.class);
    }
    
    @Override
    public PeliculaEntity crearRenta(PeliculaEntity pe) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PeliculaEntity obtenerRenta(PeliculaEntity pe) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificarRenta(PeliculaEntity pe) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarRenta(PeliculaEntity pe) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
