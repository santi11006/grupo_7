package DAO.daoReserva;

import java.time.LocalDate;
import java.util.List;

public interface ReservaDAO {
    List<Reserva> getVerReservas();
    boolean borrarReservasPorIdAlojamientoTelefonoFechaEntrada(LocalDate fecha_entrada, int id_alojamiento, String telefono);
}
