package DAO.daoReserva;

import DAO.EstablecerConexion;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAOImpl implements ReservaDAO{
    private Statement statement;
    private PreparedStatement preparedStatement;
    private final Connection connection;

    public ReservaDAOImpl() throws SQLException, IOException {
        connection = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    @Override
    public List<Reserva> getVerReservas() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Reserva reserva = new Reserva();
            reserva.setFecha_entrada(resultSet.getDate("fecha_entrada").toLocalDate());
            reserva.setId_alojamiento(resultSet.getInt("id_alojamiento"));
            reserva.setTelefono(resultSet.getString("telefono"));
            reserva.setFecha_salida(resultSet.getDate("fecha_salida").toLocalDate());
            reserva.setEmail(resultSet.getString("email"));
            reservas.add(reserva);
        }
        return reservas;
    }

    @Override
    public boolean borrarReservasPorIdAlojamientoTelefonoFechaEntrada(LocalDate fecha_entrada, int id_alojamiento, String telefono) throws SQLException {
        String sql = "DELETE FROM reservas WHERE fecha_entrada = ? AND id_alojamiento = ? AND telefono = ?";
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
        String sql = "INSERT INTO reservas (fecha_entrada, id_alojamiento, telefono, fecha_salida, email) VALUES (?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, Date.valueOf(reserva.getFecha_entrada()));
        preparedStatement.setInt(2, reserva.getId_alojamiento());
        preparedStatement.setString(3, reserva.getTelefono());
        preparedStatement.setDate(4, Date.valueOf(reserva.getFecha_salida()));
        preparedStatement.setString(5, reserva.getEmail());
        int resultado = preparedStatement.executeUpdate();
        return resultado > 0;
    }
}
