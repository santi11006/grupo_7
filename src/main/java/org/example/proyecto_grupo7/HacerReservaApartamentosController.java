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
 * Controlador para la vista de hacer reserva de apartamentos.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class HacerReservaApartamentosController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button volverAtras;

    /**
     * Método para manejar el evento del botón "Volver Atrás".
     * @param actionEvent El evento de acción generado por el botón "Volver Atrás".
     * @throws IOException Si ocurre un error al cargar la vista del menú de alojamiento.
     */
    public void volverAtras(ActionEvent actionEvent) throws IOException {
        stage = (Stage) volverAtras.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
