package DAO.daoHoteles;

import DAO.EstablecerConexion;
import DAO.daoAlojamientos.Alojamientos;
import DAO.daoAlojamientos.TipoAlojamiento;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelesDAOImpl implements HotelesDAO {
    private final Connection conectar;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public HotelesDAOImpl() throws SQLException, IOException {
        conectar = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    @Override
    public List<Hoteles> mostrarHoteles() throws SQLException {
        List<Hoteles> hoteles = new ArrayList<>();
        String sql="SELECT * FROM HOTELES ;";
        statement= conectar.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Hoteles hotel;
        while(resultSet.next()){
            int ID_ALOJAMIENTO = resultSet.getInt("ID_ALOJAMIENTO");
            String NOMBRE = resultSet.getString("NOMBRE");
            String DIRECCION = resultSet.getString("DIRECCION");
            TipoAlojamiento TIPO_ALOJAMIENTO = TipoAlojamiento.valueOf(resultSet.getString("TIPO_ALOJAMIENTO"));
            int NUM_ESTRELLAS = resultSet.getInt("NUM_ESTRELLAS");
            String TIPO_HABITACION = resultSet.getString("TIPO_HABITACION");
           // hotel =new Hoteles(ID_ALOJAMIENTO,NOMBRE,DIRECCION,TIPO_ALOJAMIENTO,NUM_ESTRELLAS,TIPO_HABITACION);
           // hoteles.add(hotel);
        }
            return hoteles;
    }

    @Override
    public boolean annadirHotele(Hoteles hotel) throws SQLException {
        String sql = "INSERT INTO HOTELES VALUES('"+ hotel.getNumeroEstrella() +"'," +
                "'"+ hotel.getTipoHabitacion() +"','"+ hotel.getTipoAlojamiento() +"','"+ hotel.getDireccion() +"'," +
                "'"+ hotel.getNombre() +"','"+ hotel.getId_alojamiento() +"';);";
        preparedStatement=conectar.prepareStatement(sql);
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean borrarHotelPorId(int id_hotel) throws SQLException {
        return false;
    }

    @Override
    public boolean actualizarHotel() {
        return false;
    }
}
