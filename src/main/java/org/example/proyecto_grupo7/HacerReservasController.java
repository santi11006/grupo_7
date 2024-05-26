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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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

        if (telefono.length() != 9) {
            Alert alertaTelefono = new Alert(Alert.AlertType.WARNING);
            alertaTelefono.setTitle("Alerta");
            alertaTelefono.setHeaderText(null);
            alertaTelefono.setContentText("Falta ingresar números en el teléfono.");
            alertaTelefono.showAndWait();
            return; // Detener la ejecución del método si no cumple con la validación
        }

        if (!email.contains("@")) {
            Alert alertaEmail = new Alert(Alert.AlertType.WARNING);
            alertaEmail.setTitle("Alerta");
            alertaEmail.setHeaderText(null);
            alertaEmail.setContentText("Falta el símbolo '@' en el correo electrónico.");
            alertaEmail.showAndWait();
            return;
        }

        LocalDate fechaEntrada = LocalDate.parse(fecha_entrada);
        LocalDate fechaSalida = LocalDate.parse(fecha_salida);

        if (fechaEntrada.isAfter(fechaSalida)) {
            Alert alertaFechas = new Alert(Alert.AlertType.WARNING);
            alertaFechas.setTitle("Alerta");
            alertaFechas.setHeaderText(null);
            alertaFechas.setContentText("La fecha de entrada debe ser anterior a la fecha de salida.");
            alertaFechas.showAndWait();
            return;
        }

        Reserva reserva = new Reserva(fechaEntrada, fechaSalida, email, telefono, id_alojamiento);
        reservaDAO.hacerReserva(reserva);

    }
}
