package org.example.proyecto_grupo7;

import DAO.daoReserva.Reserva;
import DAO.daoReserva.ReservaDAO;
import DAO.daoReserva.ReservaDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class HacerReservasController {
    private ReservaDAOImpl reservaDAO = new ReservaDAOImpl();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button volverAtras;

    @FXML
    private TextField barraTelefonoNew, barraEmailNew,barraEntradaNew, barraSalidaNew, barraIdAlojamientoNew;

    public HacerReservasController() throws SQLException, IOException {
    }

    public void volverAtras(ActionEvent actionEvent) throws IOException {
        stage = (Stage) volverAtras.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void hacerReserva(ActionEvent actionEvent) throws SQLException, IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

        String telefono = barraTelefonoNew.getText();
        String email = barraEmailNew.getText();
        LocalDate fechaEntrada;
        LocalDate fechaSalida;
        int idAlojamiento;

        try {
            fechaEntrada = LocalDate.parse(barraEntradaNew.getText(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha de entrada incorrecto. Utilice el formato dd/MM/yy.");
            return;
        }

        try {
            fechaSalida = LocalDate.parse(barraSalidaNew.getText(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha de salida incorrecto. Utilice el formato dd/MM/yy.");
            return;
        }

        if (fechaSalida.isBefore(fechaEntrada)) {
            System.out.println("La fecha de salida debe ser posterior a la fecha de entrada.");
            return;
        }

        try {
            idAlojamiento = Integer.parseInt(barraIdAlojamientoNew.getText());
        } catch (NumberFormatException e) {
            System.out.println("ID de alojamiento inválido. Debe ser un número.");
            return;
        }

        Reserva reserva = new Reserva();
        reserva.setTelefono(telefono);
        reserva.setEmail(email);
        reserva.setFecha_entrada(fechaEntrada);
        reserva.setFecha_salida(fechaSalida);
        reserva.setId_alojamiento(idAlojamiento);

        try {
            boolean exito = reservaDAO.hacerReserva(reserva);
            if (exito) {
                System.out.println("Reserva realizada con éxito.");
            } else {
                System.out.println("No se pudo realizar la reserva.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al realizar la reserva. Por favor, inténtelo de nuevo.");
        }
    }


}
