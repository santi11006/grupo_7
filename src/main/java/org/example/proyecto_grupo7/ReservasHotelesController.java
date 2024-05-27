package org.example.proyecto_grupo7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador para gestionar las operaciones relacionadas con las reservas de hoteles en una aplicación JavaFX.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class ReservasHotelesController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button volverAtras, hacerReserva, botonEliminar;

    /**
     * Maneja el evento de acción para volver a la vista anterior.
     * @param actionEvent El evento de acción generado al hacer clic en el botón de "Volver Atrás".
     * @throws IOException Si ocurre un error al cargar el archivo FXML de la vista de alojamiento.
     */
    public void volverAtras(ActionEvent actionEvent) throws IOException {
        stage = (Stage) volverAtras.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Maneja el evento de acción para realizar una nueva reserva.
     * @param actionEvent El evento de acción generado al hacer clic en el botón de "Hacer Reserva".
     * @throws IOException Si ocurre un error al cargar el archivo FXML de la vista de hacer reservas.
     */
    public void hacerReserva(ActionEvent actionEvent) throws IOException {
        stage = (Stage) hacerReserva.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("hacer_reservas-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método de marcador de posición para manejar el evento de acción para eliminar una reserva.
     * @param actionEvent El evento de acción generado al hacer clic en el botón de "Eliminar Reserva".
     */
    public void eliminarReserva(ActionEvent actionEvent) {
        // Implementación para eliminar una reserva
    }
}

