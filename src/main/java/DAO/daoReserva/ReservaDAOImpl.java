package DAO.daoReserva;

import DAO.EstablecerConexion;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de ReservaDAO que interactúa con la base de datos para realizar operaciones relacionadas con las reservas.
 * Esta implementación se conecta a la base de datos utilizando la clase EstablecerConexion.
 *
 * @author santi
 * @version 1.0
 * @since 27ç/05/2024
 */
public class ReservaDAOImpl implements ReservaDAO {
    private Statement statement;
    private PreparedStatement preparedStatement;
    private final Connection connection;

    /**
     * Constructor que establece la conexión con la base de datos.
     * @throws SQLException si hay un error al establecer la conexión con la base de datos
     * @throws IOException  si ocurre un error de E/S durante la conexión
     */
    public ReservaDAOImpl() throws SQLException, IOException {
        connection = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    /**
     * Obtiene una lista de todas las reservas almacenadas en la base de datos.
     * @return una lista de objetos Reserva que representan las reservas almacenadas
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<Reserva> getVerReservas() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            LocalDate fechaEntrada = resultSet.getDate("fecha_entrada").toLocalDate();
            LocalDate fechaSalida = resultSet.getDate("fecha_salida").toLocalDate();
            String email = resultSet.getString("email");
            String telefono = resultSet.getString("telefono");
            int id = resultSet.getInt("id_alojamiento");
            Reserva reserva = new Reserva(fechaEntrada, fechaSalida, email, telefono, id);
            reservas.add(reserva);
        }
        return reservas;
    }

    /**
     * Elimina una reserva de la base de datos utilizando la fecha de entrada, el ID de alojamiento y el número de teléfono.
     * @param fecha_entrada   la fecha de entrada de la reserva
     * @param id_alojamiento el ID del alojamiento de la reserva
     * @param telefono       el número de teléfono asociado a la reserva
     * @return true si la reserva fue eliminada correctamente, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public boolean borrarReservasPorIdAlojamientoTelefonoFechaEntrada(LocalDate fecha_entrada, int id_alojamiento, String telefono) throws SQLException {
        String sql = "DELETE FROM reserva WHERE fecha_entrada = ? AND id_alojamiento = ? AND telefono = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, Date.valueOf(fecha_entrada));
        preparedStatement.setInt(2, id_alojamiento);
        preparedStatement.setString(3, telefono);
        int resultado = preparedStatement.executeUpdate();
        return resultado > 0;
    }

    /**
     * Modifica una reserva de la base de datos con los datos proporcionados en el objeto Reserva.
     * @param reserva el objeto Reserva con los datos actualizados
     * @return true si la reserva fue modificada correctamente, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public boolean modificarReserva(Reserva reserva) throws SQLException {
        String sql = "UPDATE reservas SET fecha_salida = ?, email = ? WHERE fecha_entrada = ? AND id_alojamiento = ? AND telefono = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, Date.valueOf(reserva.getFecha_salida()));
        preparedStatement.setString(2, reserva.getEmail());
        preparedStatement.setDate(3, Date.valueOf(reserva.getFecha_entrada()));
        preparedStatement.setInt(4, reserva.getId_alojamiento());
        preparedStatement.setString(5, reserva.getTelefono());
        int resultado = preparedStatement.executeUpdate();
        return resultado > 0;
    }

    /**
     * Realiza una nueva reserva de alojamiento y la almacena en la base de datos.
     * @param reserva el objeto Reserva que representa la nueva reserva
     * @return true si la reserva fue realizada con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public boolean hacerReserva(Reserva reserva) throws SQLException {
        String sql = "INSERT INTO reserva (fecha_entrada, fecha_salida, email, telefono, id_alojamiento) VALUES (?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, Date.valueOf(reserva.getFecha_entrada()));
        preparedStatement.setDate(2, Date.valueOf(reserva.getFecha_salida()));
        preparedStatement.setString(3, reserva.getEmail());
        preparedStatement.setString(4, reserva.getTelefono());
        preparedStatement.setInt(5, reserva.getId_alojamiento());
        int resultado = preparedStatement.executeUpdate();
        return resultado > 0;
    }
}
