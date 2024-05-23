package DAO.daoReserva;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ReservaDAO {
    List<Reserva> getVerReservas() throws SQLException;
    boolean borrarReservasPorIdAlojamientoTelefonoFechaEntrada(LocalDate fecha_entrada, int id_alojamiento, String telefono) throws SQLException;
    boolean modificarReserva(Reserva reserva) throws SQLException;
    boolean hacerReserva(Reserva reserva) throws SQLException;
}
