package org.example.proyecto_grupo7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField cajaNomApe,cajaTelefono, cajaEmail, cajaDireccion, cajaContraseña;

    public void onClick(ActionEvent actionEvent) {
        String nombre = cajaNomApe.getText();
        String telefono = cajaTelefono.getText();
        String email = cajaEmail.getText();
        String direccion = cajaDireccion.getText();
        String contraseña = cajaContraseña.getText();
    }
}
