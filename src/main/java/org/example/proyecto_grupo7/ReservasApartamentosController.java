package org.example.proyecto_grupo7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ReservasApartamentosController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button volverAtrasApartamentos;
    public void volverAtrasApartamentos(ActionEvent actionEvent) throws IOException {
        stage = (Stage) volverAtrasApartamentos.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
