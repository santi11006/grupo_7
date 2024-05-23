package DAO.daoApartamentos;

import DAO.EstablecerConexion;
import DAO.daoAlojamientos.TipoAlojamiento;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartamentosDAOImpl implements ApartamentosDAO {
    private final Connection conectar;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public ApartamentosDAOImpl() throws SQLException, IOException {
        conectar = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    @Override
    public List<Apartamentos> getApartamentos() throws SQLException {
        List<Apartamentos> apartamentos = new ArrayList<>();
        String sql = "SELECT * FROM apartamentos";
        statement = conectar.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Apartamentos apartamento;
        while (resultSet.next()) {
            int id_alojamiento = resultSet.getInt("id_alojamiento");
            String nombre = resultSet.getString("nombre");
            String direccion = resultSet.getString("direccion");
            TipoAlojamiento tipoAlojamiento = TipoAlojamiento.valueOf(resultSet.getString("tipoAlojamiento"));
            int id_apartamento = resultSet.getInt("id_apartamento");
            int distancia = resultSet.getInt("distancia");
            apartamento = new Apartamentos(id_alojamiento, nombre, direccion, tipoAlojamiento, id_apartamento, distancia);
            apartamentos.add(apartamento);
        }
        return apartamentos;
    }

    @Override
    public boolean borrarAparatmentosPorId(int id) throws SQLException {
        String sql = "DELETE FROM apartamentos WHERE id_alojamiento = ?";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean insertarApartamentos(Apartamentos apartamentos) throws SQLException {
        String sql = "INSERT INTO apartamentos (id_alojamiento, nombre, direccion, tipoAlojamiento, id_apartamento, distancia) VALUES (?, ?, ?, ?, ?, ?)";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setInt(1, apartamentos.getId_alojamiento());
        preparedStatement.setString(2, apartamentos.getNombre());
        preparedStatement.setString(3, apartamentos.getDireccion());
        preparedStatement.setString(4, apartamentos.getTipoAlojamiento().toString());
        preparedStatement.setInt(5, apartamentos.getId_apartamentos());
        preparedStatement.setInt(6, apartamentos.getDistancia());
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean actualizarApartamentos(Apartamentos apartamentos) throws SQLException {
        String sql = "UPDATE apartamentos SET nombre = ?, direccion = ?, tipoAlojamiento = ?, distancia = ? WHERE id_alojamiento = ?";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setString(1, apartamentos.getNombre());
        preparedStatement.setString(2, apartamentos.getDireccion());
        preparedStatement.setString(3, apartamentos.getTipoAlojamiento().toString());
        preparedStatement.setInt(4, apartamentos.getDistancia());
        preparedStatement.setInt(5, apartamentos.getId_alojamiento());
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }
}

