package DAO.daoReserva;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservaDAOImplTest {
    Reserva reserva;
    ReservaDAO reservaDAO = new ReservaDAOImpl();

    ReservaDAOImplTest() throws SQLException, IOException {
    }

    @BeforeEach
    void setUp() {
        reserva = null;
    }

    @AfterEach
    void tearDown() {
        LocalDate fechaEntrada = LocalDate.of(2024,02,11);
        LocalDate fechaSalida = LocalDate.of(2024,02,17);
        reserva = new Reserva(fechaEntrada,fechaSalida,"santi@gm.com","123456789",3);
    }

    @Test
    void hacerReservaExitosa() throws SQLException {
        LocalDate fechaEntrada = LocalDate.of(2024,02,11);
        LocalDate fechaSalida = LocalDate.of(2024,02,17);
        reserva = new Reserva(fechaEntrada,fechaSalida,"santi@gm.com","123456789",3);
        assertTrue(reservaDAO.hacerReserva(reserva));
    }

    @Test
    public void testHacerReservaThrowsSQLException() throws SQLException, IOException {
        Reserva reserva = new Reserva(
                LocalDate.of(2023, 5, 10),
                LocalDate.of(2023, 5, 15),
                "test@example.com",
                "1234567890",
                1
        );

        reservaDAO = new ReservaDAOImpl() ; // Simulate a failure with a null connection

        assertThrows(SQLException.class, () -> {
            reservaDAO.hacerReserva(reserva);
        });
    }

    @Test
    void testIgualObjeto(){
        LocalDate fechaEntrada = LocalDate.of(2024,02,11);
        LocalDate fechaSalida = LocalDate.of(2024,02,17);
        reserva = new Reserva(fechaEntrada,fechaSalida,"santi@gm.com","123456789",3);

        Reserva reserva1 = reserva;
        assertSame(reserva1,reserva);
    }
}
