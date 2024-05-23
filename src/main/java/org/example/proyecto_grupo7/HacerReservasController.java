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

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

            String telefono = barraTelefonoNew.getText();
            String email = barraEmailNew.getText();
            LocalDate fechaEntrada = LocalDate.parse(barraEntradaNew.getText(), formatter);
            LocalDate fechaSalida = LocalDate.parse(barraSalidaNew.getText(), formatter);
            int idAlojamiento = Integer.parseInt(barraIdAlojamientoNew.getText());

            Reserva reserva = new Reserva();
            reserva.setTelefono(telefono);
            reserva.setEmail(email);
            reserva.setFecha_entrada(fechaEntrada);
            reserva.setFecha_salida(fechaSalida);
            reserva.setId_alojamiento(idAlojamiento);

            if (reservaDAO.hacerReserva(reserva)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Reserva realizada con éxito");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No se ha podido hacer la reserva");
                alert.showAndWait();  // Show the alert in case of failure
            }
        } catch (DateTimeParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Formato de fecha incorrecto. Por favor, use el formato dd/MM/yy.");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al hacer la reserva: " );
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Formato de número incorrecto. Por favor, verifique sus entradas.");
            alert.showAndWait();
        }


    }
}
