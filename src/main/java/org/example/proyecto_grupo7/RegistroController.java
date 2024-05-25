package org.example.proyecto_grupo7;

import DAO.daoUsuario.Usuario;
import DAO.daoUsuario.UsuarioDAOImpl;
import DAO.daoUsuario.UsuariosDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistroController {
    private UsuariosDAO usuariosDAO = new UsuarioDAOImpl();
    @FXML
    public Button btAtras;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField cajaNomApe,cajaTelefono, cajaEmail, cajaDireccion, cajaContraseña,botonAtras;
    @FXML
    private Button onClick;

    public RegistroController() throws SQLException, IOException {
    }


    public void botonSalir(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onClick(ActionEvent actionEvent) throws IOException, SQLException {

        String nombre = cajaNomApe.getText();
        String telefono = cajaTelefono.getText();
        String email = cajaEmail.getText();
        String direccion = cajaDireccion.getText();
        String contraseña = cajaContraseña.getText();

        if (nombre.isEmpty() || telefono.isEmpty() || email.isEmpty() || direccion.isEmpty() || contraseña.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Todos los campos deben estar rellenos.");
            alert.showAndWait();
            return;
        }
        if (!telefono.matches("\\d{9}")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "El teléfono debe tener nueve numeros.");
            alert.showAndWait();
            return;
        }
        if (!email.contains("@")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "El correo electrónico debe contener un '@'.");
            alert.showAndWait();
            return;
        }

        Usuario usuario = new Usuario(nombre, telefono, email, direccion, contraseña);



            if (usuariosDAO.annadirUsuario(usuario)) {
                Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("alojamiento-view.fxml"));
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.show();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Usuario registrado correctamente");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No se puede registrar");
                alert.showAndWait();
            }

    }

    public void botonAtras(ActionEvent actionEvent) throws IOException {
        stage= (Stage) btAtras.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
