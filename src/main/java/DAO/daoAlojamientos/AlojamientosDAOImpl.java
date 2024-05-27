package DAO.daoAlojamientos;
import DAO.EstablecerConexion;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz AlojamientosDAO para realizar operaciones CRUD en la base de datos.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class AlojamientosDAOImpl implements AlojamientosDAO {
    private final Connection conectar;
    private Statement statement;
    private PreparedStatement preparedStatement;

    /**
     * Constructor que establece la conexión con la base de datos.
     * @throws SQLException si ocurre un error al acceder a la base de datos
     * @throws IOException  si ocurre un error de entrada/salida
     */
    public AlojamientosDAOImpl() throws SQLException, IOException {
        conectar = EstablecerConexion.getEstablecerConexion().getConexion();
    }
    /**
     * Muestra la lista de todos los alojamientos.
     * @return una lista de objetos Alojamientos
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
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
        return alojamientos;
    }
    /**
     * Añade un nuevo alojamiento a la base de datos.
     * @param alojamientos el objeto Alojamientos a añadir
     * @return true si el alojamiento fue añadido con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
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
    /**
     * Borra un alojamiento de la base de datos por su id.
     * @param id_alojamiento el id del alojamiento a borrar
     * @return true si el alojamiento fue borrado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public boolean borraAlojamientosPorId(int id_alojamiento) throws SQLException {
        String sql = "DELETE FROM ALOJAMIENTOS WHERE TELEFONO = ? ;";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(id_alojamiento));
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }
    /**
     * Actualiza los datos de un alojamiento existente.
     * @param id_alojamiento  el id del alojamiento a actualizar
     * @param nombre          el nuevo nombre del alojamiento
     * @param direccion       la nueva dirección del alojamiento
     * @param tipoAlojamiento el nuevo tipo de alojamiento
     * @return true si el alojamiento fue actualizado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
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
