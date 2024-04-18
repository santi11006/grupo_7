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
            int ID_ALOJAMIENTO = resultSet.getInt("ID_ALOJAMIENTO");
            String NOMBRE = resultSet.getString("NOMBRE");
            String DIRECCION = resultSet.getString("DIRECCION");
            TipoAlojamiento TIPO_ALOJAMIENTO = TipoAlojamiento.valueOf(resultSet.getString("TIPO_ALOJAMIENTO"));
            alojamiento =new Alojamientos(ID_ALOJAMIENTO,NOMBRE,DIRECCION,TIPO_ALOJAMIENTO);
            alojamientos.add(alojamiento);
        }
        return alojamientos;    }

    @Override
    public boolean annadirAlojamientos(Alojamientos alojamientos) throws SQLException {
        String sql = " INSERT INTO ALOJAMIENTOS VALUES ('" + alojamientos.getId_alojamiento() + "', '"
                + alojamientos.getNombre() + "'," + alojamientos.getDireccion() + "'" + alojamientos.getTipoAlojamiento() + "');";
        preparedStatement = conectar.prepareStatement(sql);
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean borraAlojamientosPorId(int id_alojamiento) throws SQLException {
        String sql = "DELETE FROM ALOJAMIENTOS WHERE TELEFONO = '" + id_alojamiento + "';";
        PreparedStatement prepareStatement = conectar.prepareStatement(sql);
        prepareStatement.setString(1, String.valueOf(id_alojamiento));
        int resultado = prepareStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean actualizarAlojamiento(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento) throws SQLException {
        String sql = "UPDATE ALOJAMIENTOS SET NOMBRE = '" + nombre + "', DIRECCION ='" + direccion+ "', TIPO_ALOJAMIENTO = '" + tipoAlojamiento + "' WHERE ID_ALOJAMIENTO = '" + id_alojamiento + "';";
        PreparedStatement prepareStatement = conectar.prepareStatement(sql);
        int actualizarDatos = preparedStatement.executeUpdate();
        return actualizarDatos > 0;
    }
}
