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

/**
 * Controlador para la vista de inicio de sesión.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
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

    /**
     * Método para manejar el evento de clic en el botón de inicio de sesión.
     * @param actionEvent El evento de acción generado por el clic en el botón de inicio de sesión.
     * @throws IOException Si ocurre un error al cargar la vista de alojamiento o mostrar una alerta.
     */
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
        } else {
            errorCuentaErronea.setText("Opsss... No tienes cuenta :( !!");
            Alert alert = new Alert(Alert.AlertType.ERROR, "No existe ese usuario");
            alert.showAndWait();
        }
    }
}
