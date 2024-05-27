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
 * Controlador para la vista de gestión de reservas de apartamentos.
 */
public class ReservasApartamentosController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button volverAtrasApartamentos, hacerReserva;

    /**
     * Método para manejar el evento del botón de retroceso.
     *
     * @param actionEvent El evento de acción generado por el clic en el botón de retroceso.
     * @throws IOException Si ocurre un error al cargar la vista de alojamiento.
     */
    public void volverAtrasApartamentos(ActionEvent actionEvent) throws IOException {
        stage = (Stage) volverAtrasApartamentos.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método para manejar el evento del botón de hacer reserva.
     *
     * @param actionEvent El evento de acción generado por el clic en el botón de hacer reserva.
     * @throws IOException Si ocurre un error al cargar la vista de hacer reserva de apartamentos.
     */
    public void hacerReserva(ActionEvent actionEvent) throws IOException {
        stage = (Stage) hacerReserva.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("hacer_reserva_apartamentos.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

