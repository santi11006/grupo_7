package DAO.daoAlojamientos;
import DAO.EstablecerConexion;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlojamientosDAOImpl implements AlojamientosDAO {
    private final Connection conectar;
    private Statement statement;
    private PreparedStatement preparedStatement;
    public AlojamientosDAOImpl() throws SQLException, IOException {
        conectar = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    @Override

    public List<Alojamientos> mostrarAlojaminetos() throws SQLException {
        List<Alojamientos> alojamientos = new ArrayList<>();
        String sql = " SELECT * FROM ALOJAMIENTOS ;";
        statement = conectar.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Alojamientos alojamiento = null;
        while(resultSet.next()){
            int id_alojamiento = resultSet.getInt("id_alojamiento");
            String nombre = resultSet.getString("nombre");
            String direccion = resultSet.getString("direccion");
            TipoAlojamiento tipoAlojamiento = TipoAlojamiento.valueOf(resultSet.getString("TIPO_ALOJAMIENTO"));
            alojamiento =new Alojamientos(id_alojamiento,nombre,direccion,tipoAlojamiento);
            alojamientos.add(alojamiento);
        }
        return alojamientos;    }

    @Override
    public boolean annadirAlojamientos(Alojamientos alojamientos) throws SQLException {
        String sql = " INSERT INTO ALOJAMIENTOS VALUES (?, ?, ?, ?);";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setInt(1, alojamientos.getId_alojamiento());
        preparedStatement.setString(2, alojamientos.getNombre());
        preparedStatement.setString(3, alojamientos.getNombre());
        preparedStatement.setString(4, String.valueOf(alojamientos.getTipoAlojamiento()));
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean borraAlojamientosPorId(int id_alojamiento) throws SQLException {
        String sql = "DELETE FROM ALOJAMIENTOS WHERE TELEFONO = ? ;";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(id_alojamiento));
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean actualizarAlojamiento(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento) throws SQLException {
        String sql = "UPDATE ALOJAMIENTOS SET NOMBRE = ?, DIRECCION =?, TIPO_ALOJAMIENTO = ? WHERE ID_ALOJAMIENTO = ?;";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setInt(1,id_alojamiento);
        preparedStatement.setString(2,nombre);
        preparedStatement.setString(3, direccion);
        preparedStatement.setString(4, String.valueOf(tipoAlojamiento));
        int actualizarDatos = preparedStatement.executeUpdate();
        return actualizarDatos > 0;
    }
}
