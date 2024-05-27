package DAO.daoReserva;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para las reservas de alojamiento.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public interface ReservaDAO {
    /**
     * Obtiene una lista de todas las reservas de alojamiento.
     * @return una lista de objetos Reserva
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    List<Reserva> getVerReservas() throws SQLException;

    /**
     * Borra una reserva de alojamiento por su fecha de entrada, id de alojamiento y número de teléfono.
     * @param fecha_entrada la fecha de entrada de la reserva
     * @param id_alojamiento el identificador único del alojamiento
     * @param telefono el número de teléfono asociado a la reserva
     * @return true si la reserva fue borrada con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean borrarReservasPorIdAlojamientoTelefonoFechaEntrada(LocalDate fecha_entrada, int id_alojamiento, String telefono) throws SQLException;

    /**
     * Modifica una reserva de alojamiento.
     * @param reserva el objeto Reserva con los datos actualizados
     * @return true si la reserva fue modificada con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean modificarReserva(Reserva reserva) throws SQLException;

    /**
     * Realiza una nueva reserva de alojamiento.
     * @param reserva el objeto Reserva que representa la nueva reserva
     * @return true si la reserva fue realizada con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean hacerReserva(Reserva reserva) throws SQLException;
}
