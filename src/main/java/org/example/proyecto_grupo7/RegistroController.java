package org.example.proyecto_grupo7;

import DAO.daoUsuario.Usuario;
import DAO.daoUsuario.UsuarioDAOImpl;
import DAO.daoUsuario.UsuariosDAO;
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
import java.sql.SQLException;

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
        Usuario usuario = new Usuario(nombre,telefono,email,direccion,contraseña);

        if (usuariosDAO.annadirUsuario(usuario)) {
            stage = (Stage) onClick.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("alojamiento-view.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"No se puede registrar");
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
