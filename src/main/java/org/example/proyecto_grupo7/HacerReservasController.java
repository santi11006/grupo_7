package org.example.proyecto_grupo7;

import DAO.daoReserva.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Controlador para la vista de hacer reservas.
 * author santi
 * version 1.0
 * since 27/05/2024
 */

import DAO.daoReserva.Reserva;
import DAO.daoReserva.ReservaDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Controlador para la vista de hacer reservas.
 * author santi
 * version 1.0
 * since 27/05/2024
 */
public class HacerReservasController {
    private ReservaDAOImpl reservaDAO = new ReservaDAOImpl();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button volverAtras;

    @FXML
    private ComboBox<String> comboBoxAlojamiento;

    @FXML
    private DatePicker barraEntradaNew, barraSalidaNew;

    @FXML
    private TextField barraTelefonoNew, barraEmailNew;

    /**
     * Constructor de HacerReservasController.
     *
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     * @throws IOException  Si ocurre un error al cargar la vista de alojamiento.
     */
    public HacerReservasController() throws SQLException, IOException {
    }

    /**
     * Método para manejar el evento del botón "Volver Atrás".
     *
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
     *
     * @param actionEvent El evento de acción generado por el botón de hacer reserva.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public void hacerReserva(ActionEvent actionEvent) throws SQLException {
        String telefono = barraTelefonoNew.getText();
        String email = barraEmailNew.getText();
        LocalDate fechaEntrada = barraEntradaNew.getValue();
        LocalDate fechaSalida = barraSalidaNew.getValue();

        // Obtener el ID del alojamiento seleccionado en el ComboBox
        String selectedItem = comboBoxAlojamiento.getSelectionModel().getSelectedItem();
        int idAlojamiento = obtenerIdAlojamiento(selectedItem);

        // Validaciones
        if (telefono.length() != 9) {
            mostrarAlerta("Alerta", null, "Falta ingresar números en el teléfono.");
            return;
        }

        if (!email.contains("@")) {
            mostrarAlerta("Alerta", null, "Falta el símbolo '@' en el correo electrónico.");
            return;
        }

        if (fechaEntrada == null || fechaSalida == null) {
            mostrarAlerta("Alerta", null, "Por favor, seleccione las fechas de entrada y salida.");
            return;
        }

        if (fechaEntrada.isAfter(fechaSalida)) {
            mostrarAlerta("Alerta", null, "La fecha de entrada debe ser anterior a la fecha de salida.");
            return;
        }


        Reserva reserva = new Reserva(fechaEntrada, fechaSalida, email, telefono, idAlojamiento);
        reservaDAO.hacerReserva(reserva);

        mostrarAlerta("Reserva Realizada", "Reserva realizada", "La reserva se ha realizado correctamente.\n" +
                "Teléfono: " + telefono + "\n" +
                "Correo electrónico: " + email);
    }

    /**
     * Método para obtener el ID del alojamiento seleccionado.
     *
     * @param alojamiento El nombre del alojamiento seleccionado.
     * @return El ID del alojamiento.
     */
    private int obtenerIdAlojamiento(String alojamiento) {
        switch (alojamiento) {
            case "1 (Hotel Miramar)":
                return 1;
            case "3 (Hotel Montaña)":
                return 3;
            default:
                return -1; // Valor por defecto si no se encuentra el alojamiento
        }
    }

    /**
     * Método para mostrar una alerta.
     *
     * @param titulo    El título de la alerta.
     * @param cabecera  El encabezado de la alerta.
     * @param contenido El contenido de la alerta.
     */
    private void mostrarAlerta(String titulo, String cabecera, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecera);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}






