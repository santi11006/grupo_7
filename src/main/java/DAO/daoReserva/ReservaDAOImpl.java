package DAO.daoReserva;

import DAO.EstablecerConexion;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author santi
 * @version 1.0
 * @since 26/05/2024
 */
public class ReservaDAOImpl implements ReservaDAO{
    private Statement statement;
    private PreparedStatement preparedStatement;
    private final Connection connection;

    /**
     * Es el contrucutor el cual va a hacer que se conecte las reservas con la base de datos
     * @throws SQLException atrapa las excepciones del getEstablecerConexion
     * @throws IOException atrapa las excepciones del getEstablecerConexion
     *
     */
    public ReservaDAOImpl() throws SQLException, IOException {
        connection = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    /**
     * Devuelve un listado de reservas y nos muestra toda a informacion de reservas
     * @return
     * @throws SQLException
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
            Reserva reserva = new Reserva(fechaEntrada,fechaSalida,email,telefono,id);
            reservas.add(reserva);
        }
        return reservas;
    }

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
