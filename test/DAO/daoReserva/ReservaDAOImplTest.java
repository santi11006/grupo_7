package DAO.daoReserva;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservaDAOImplTest {
    private Reserva reserva;
    ReservaDAO reservaDAO = new ReservaDAOImpl();

    ReservaDAOImplTest() throws SQLException, IOException {
    }

    @Before
    public void setUp() throws Exception {
        LocalDate fecha_entrada = LocalDate.of(2024,02,14);
        LocalDate fecha_salida = LocalDate.of(2024,02,17);
        reserva = new Reserva(fecha_entrada,fecha_salida,"santi@gm.com","123456789",3);
        System.out.println("reserva creada");
    }

    @After
    public void tearDown() throws Exception {
        reserva = null;
    }

    @Test
    public void testHacerReservaExitoso() throws SQLException {
        LocalDate fecha_entrada = LocalDate.of(2024,02,11);
        LocalDate fecha_salida = LocalDate.of(2024,02,17);
        reserva = new Reserva(fecha_entrada,fecha_salida,"santi@gm.com","123456789",3);
        assertTrue(reservaDAO.hacerReserva(reserva));
    }

    @Test
    public void testHacerExcepcion(){
        LocalDate fecha_entrada = LocalDate.of(2024, 2, 14);
        LocalDate fecha_salida = LocalDate.of(2024, 2, 17);
        Reserva reserva = new Reserva(fecha_entrada, fecha_salida, "santi@gm.com", "123456789", 3);

        try {
            reservaDAO.hacerReserva(reserva);
            fail("[SQLITE_CONSTRAINT_PRIMARYKEY] A PRIMARY KEY constraint failed (UNIQUE constraint failed: RESERVA.FECHA_ENTRADA)");
        } catch (SQLException e) {
            assertEquals("[SQLITE_CONSTRAINT_PRIMARYKEY] A PRIMARY KEY constraint failed (UNIQUE constraint failed: RESERVA.FECHA_ENTRADA)", e.getMessage());
        }
    }

    @Test
    public void mismoObjeto(){
        Reserva reserva1 = reserva;
        assertSame(reserva,reserva1);
    }
}