package DAO;

import com.mongodb.client.MongoCollection;
import entidades.RentaEntity;
import excepciones.PersistenciaException;
import interfacesDAO.IRentaDAO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class RentaDAO implements IRentaDAO{
    
    private MongoCollection<RentaEntity> coleccionRenta;
    private final String nombreCol;

    public RentaDAO() {
        this.nombreCol = "Rentas";
        this.coleccionRenta = conexionBD.ConexionMongo.obtenerBaseDeDatos().getCollection(nombreCol, RentaEntity.class);
    }

    @Override
    public RentaEntity crearRenta(RentaEntity re) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RentaEntity obtenerRenta(RentaEntity re) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificarRenta(RentaEntity re) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarRenta(RentaEntity re) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
