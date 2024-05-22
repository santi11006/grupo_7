package org.example.proyecto_grupo7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AlojamientoController {
    @FXML
    public Button botonAlojamieto;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button botonSalir,botonHotel,noCuenta;

    public void botonSalir(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void botonHotel(ActionEvent actionEvent) throws IOException {
        stage = (Stage) botonHotel.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("reservasHoteles-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void botonAlojamieto(ActionEvent actionEvent) throws IOException {
        stage = (Stage) botonAlojamieto.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("reservasApartamentos.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void noCuenta(ActionEvent actionEvent) throws IOException {
        stage = (Stage) noCuenta.getScene().getWindow();
        root =FXMLLoader.load(getClass().getResource("registro-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
