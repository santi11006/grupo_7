package org.example.proyecto_grupo7;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label errorCuentaErronea;
    @FXML
    private TextField barraLogin, cajaPassword;
    @FXML
    private Button botonEntrar, noCuenta;

    @FXML
    public void onClick(javafx.event.ActionEvent actionEvent) {
        String login = barraLogin.getText();
        String password = cajaPassword.getText();
        if (login.equals("santi") && password.equals("1234")) {
            System.out.println("Todo ha ido bien");
        }else {
            errorCuentaErronea.setText("Opsss... No tienes cuenta :( !!");
        }
    }
}