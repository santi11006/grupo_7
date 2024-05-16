package DAO.daoApartamentos;

import DAO.EstablecerConexion;
import DAO.daoAlojamientos.TipoAlojamiento;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class ApartamentosDAOImpl implements ApartamentosDAO{

    private Statement statement;
    private PreparedStatement preparedStatement;
    private final Connection conexion;

    public ApartamentosDAOImpl() throws SQLException, IOException {
        conexion = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    @Override
    public List<Apartamentos> getApartamentos() throws SQLException {
        List<Apartamentos> apartamentosList = new ArrayList<>();
        String sql = " SELECT * FROM apartamentos;";
        statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Apartamentos apartamentos = null;
        while(resultSet.next()){
            int id = resultSet.getInt("id_alojamiento");
            int distancia = resultSet.getInt("distancia");
            int id_alojamiento = resultSet.getInt("id_alojamiento");
            String nombre = resultSet.getString("nombre");
            String direccion =resultSet.getString("direccion");
            TipoAlojamiento tipoAlojamiento = TipoAlojamiento.valueOf(resultSet.getString("tipoAlojamiento"));
            apartamentos = new Apartamentos(id_alojamiento,nombre,direccion,tipoAlojamiento,id_alojamiento,distancia);
            apartamentosList.add(apartamentos);
        }
        return apartamentosList;
    }

    @Override
    public boolean borraApartametosPorId(int id) throws SQLException {
        String sql = "DELETE FROM apartamentos WHERE id_alojamiento = ?;";
        preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

   @Override
    public boolean actualizarApartametos(Apartamentos apartamentos) throws SQLException {
        String sql = "INSERT INTO apartamento VALUES (?,?,?,?,?,?)";
        preparedStatement = conexion.prepareStatement(sql);
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean insertarApartamentos(Apartamentos apartamentos) {
        return false;
    }
}
