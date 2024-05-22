package org.example.proyecto_grupo7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label errorCuentaErronea;
    @FXML
    private TextField barraLogin, cajaPassword;
    @FXML
    private Button botonEntrar;

    @FXML
    public void onClick(javafx.event.ActionEvent actionEvent) throws IOException {
        String login = barraLogin.getText();
        String password = cajaPassword.getText();
        if (login.equals("santi") && password.equals("1234")) {
            stage = (Stage) botonEntrar.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println("Todo ha ido bien");
        }else {
            errorCuentaErronea.setText("Opsss... No tienes cuenta :( !!");
            Alert alert = new Alert(Alert.AlertType.ERROR,"No existe ese usuario");
            alert.showAndWait();
        }
    }
}