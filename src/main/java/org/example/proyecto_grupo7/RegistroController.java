package org.example.proyecto_grupo7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroController {
    @FXML
    public Button btAtras;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField cajaNomApe,cajaTelefono, cajaEmail, cajaDireccion, cajaContraseña,botonAtras;
    @FXML
    private Button onClick;


    public void botonSalir(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onClick(ActionEvent actionEvent) throws IOException {
        String nombre = cajaNomApe.getText();
        String telefono = cajaTelefono.getText();
        String email = cajaEmail.getText();
        String direccion = cajaDireccion.getText();
        String contraseña = cajaContraseña.getText();

        stage = (Stage) onClick.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void botonAtras(ActionEvent actionEvent) throws IOException {
        stage= (Stage) btAtras.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
