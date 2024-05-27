package DAO.daoHoteles;

import DAO.EstablecerConexion;
import DAO.daoAlojamientos.TipoAlojamiento;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz HotelesDAO para realizar operaciones CRUD en la tabla de hoteles.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class HotelesDAOImpl implements HotelesDAO {
    private final Connection conectar;
    private Statement statement;
    private PreparedStatement preparedStatement;

    /**
     * Constructor que establece la conexión con la base de datos.
     * @throws SQLException si ocurre un error al acceder a la base de datos
     * @throws IOException  si ocurre un error de entrada/salida
     */
    public HotelesDAOImpl() throws SQLException, IOException {
        conectar = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    /**
     * Obtiene una lista de todos los hoteles.
     * @return una lista de objetos Hoteles
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<Hoteles> mostrarHoteles() throws SQLException {
        List<Hoteles> hoteles = new ArrayList<>();
        String sql = "SELECT * FROM HOTELES";
        statement = conectar.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Hoteles hotel;
        while (resultSet.next()) {
            int id_alojamiento = resultSet.getInt("id_alojamiento");
            String nombre = resultSet.getString("nombre");
            String direccion = resultSet.getString("direccion");
            TipoAlojamiento tipoAlojamiento = TipoAlojamiento.valueOf(resultSet.getString("tipoAlojamiento"));
            int numeroEstrella = resultSet.getInt("numeroEstrella");
            String tipoHabitacion = resultSet.getString("tipoHabitacion");
            hotel = new Hoteles(id_alojamiento, nombre, direccion, tipoAlojamiento, numeroEstrella, tipoHabitacion);
            hoteles.add(hotel);
        }
        return hoteles;
    }

    /**
     * Añade un nuevo hotel a la base de datos.
     * @param hotel el objeto Hoteles a añadir
     * @return true si el hotel fue añadido con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public boolean annadirHotele(Hoteles hotel) throws SQLException {
        String sql = "INSERT INTO HOTELES VALUES(?,?,?,?,?,?)";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setInt(1, hotel.getId_alojamiento());
        preparedStatement.setString(2, hotel.getNombre());
        preparedStatement.setString(3, hotel.getDireccion());
        preparedStatement.setString(4, String.valueOf(hotel.getTipoAlojamiento()));
        preparedStatement.setInt(5, hotel.getNumeroEstrella());
        preparedStatement.setString(6, hotel.getTipoHabitacion());
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    /**
     * Borra un hotel de la base de datos por su id.
     * @param id_alojamiento el id del hotel a borrar
     * @return true si el hotel fue borrado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public boolean borrarHotelPorId(int id_alojamiento) throws SQLException {
        String sql = "DELETE FROM HOTELES WHERE ID_ALOJAMIENTO = ?";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setInt(1, id_alojamiento);
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    /**
     * Actualiza los datos de un hotel existente en la base de datos.
     * @param hoteles el objeto Hoteles con los datos actualizados
     * @return true si el hotel fue actualizado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public boolean actualizarHotel(Hoteles hoteles) throws SQLException {
        String sql = "UPDATE HOTELES SET nombre = ?, direccion = ?, tipoAlojamiento = ?, numeroEstrella = ?, tipoHabitacion = ? WHERE id_alojamiento = ?";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setString(1, hoteles.getNombre());
        preparedStatement.setString(2, hoteles.getDireccion());
        preparedStatement.setString(3, String.valueOf(hoteles.getTipoAlojamiento()));
        preparedStatement.setInt(4, hoteles.getNumeroEstrella());
        preparedStatement.setString(5, hoteles.getTipoHabitacion());
        preparedStatement.setInt(6, hoteles.getId_alojamiento());
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }
}
