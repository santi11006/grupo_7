package org.example.proyecto_grupo7;

import DAO.daoReserva.Reserva;
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

/**
 * Controlador para la vista de hacer reservas.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class HacerReservasController {
    private ReservaDAOImpl reservaDAO = new ReservaDAOImpl();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button volverAtras;

    @FXML
    private TextField barraTelefonoNew, barraEmailNew, barraEntradaNew, barraSalidaNew, barraIdAlojamientoNew;

    /**
     * Constructor de HacerReservasController.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     * @throws IOException  Si ocurre un error al cargar la vista de alojamiento.
     */
    public HacerReservasController() throws SQLException, IOException {
    }

    /**
     * Método para manejar el evento del botón "Volver Atrás".
     * @param actionEvent El evento de acción generado por el botón "Volver Atrás".
     * @throws IOException Si ocurre un error al cargar la vista de alojamiento.
     */
    public void volverAtras(ActionEvent actionEvent) throws IOException {
        stage = (Stage) volverAtras.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método para manejar el evento de hacer una reserva.
     * @param actionEvent El evento de acción generado por el botón de hacer reserva.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     * @throws IOException  Si ocurre un error al mostrar la ventana de confirmación.
     */
    public void hacerReserva(ActionEvent actionEvent) throws SQLException, IOException {
        String telefono = barraTelefonoNew.getText();
        String email = barraEmailNew.getText();
        String fecha_entrada = barraEntradaNew.getText();
        String fecha_salida = barraSalidaNew.getText();
        int id_alojamiento = Integer.parseInt(barraIdAlojamientoNew.getText());

        // Validaciones
        if (telefono.length() != 9) {
            Alert alertaTelefono = new Alert(Alert.AlertType.WARNING);
            alertaTelefono.setTitle("Alerta");
            alertaTelefono.setHeaderText(null);
            alertaTelefono.setContentText("Falta ingresar números en el teléfono.");
            alertaTelefono.showAndWait();
            return;
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

        Alert alertaConfirmacion = new Alert(Alert.AlertType.INFORMATION);
        alertaConfirmacion.setTitle("Reserva Realizada");
        alertaConfirmacion.setHeaderText(null);
        alertaConfirmacion.setContentText("La reserva se ha realizado correctamente.\n" +
                "Teléfono: " + telefono + "\n" +
                "Correo electrónico: " + email);
        alertaConfirmacion.showAndWait();
    }
}
