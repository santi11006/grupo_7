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

        String telefono = barraTelefonoNew.getText();
        String email = barraEmailNew.getText();
        String fecha_entrada = barraEntradaNew.getText();
        String fecha_salida = barraSalidaNew.getText();
        int id_alojamiento = Integer.parseInt(barraIdAlojamientoNew.getText());

        String[] fechaEntrada = fecha_entrada.split("-");
        int anioEntrada = Integer.parseInt(fechaEntrada[0]);
        int mesEntrada = Integer.parseInt(fechaEntrada[1]);
        int diaEntrada = Integer.parseInt(fechaEntrada[2]);
        LocalDate salidaFecha = LocalDate.of(anioEntrada, mesEntrada, diaEntrada);

        String[] fechaSalida = fecha_salida.split("-");
        int anioSalida = Integer.parseInt(fechaSalida[0]);
        int mesSalida = Integer.parseInt(fechaSalida[1]);
        int diaSalida = Integer.parseInt(fechaSalida[2]);
        LocalDate entradaFecha = LocalDate.of(anioSalida, mesSalida, diaSalida);

        Reserva reserva = new Reserva(entradaFecha,salidaFecha,email,telefono,id_alojamiento);

        reservaDAO.hacerReserva(reserva);
    }
}
