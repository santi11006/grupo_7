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
 * Controlador para la vista de gestión de alojamientos.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class AlojamientoController {
    @FXML
    public Button botonAlojamieto;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button botonSalir, botonHotel, noCuenta, botonVerClientes;

    /**
     * Método para manejar el evento del botón "Salir".
     * @param actionEvent El evento de acción generado por el botón "Salir".
     */
    public void botonSalir(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Método para manejar el evento del botón "Hotel".
     * @param actionEvent El evento de acción generado por el botón "Hotel".
     * @throws IOException Si ocurre un error al cargar la vista de reservas de hoteles.
     */
    public void botonHotel(ActionEvent actionEvent) throws IOException {
        stage = (Stage) botonHotel.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("reservasHoteles-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método para manejar el evento del botón "Alojamiento".
     * @param actionEvent El evento de acción generado por el botón "Alojamiento".
     * @throws IOException Si ocurre un error al cargar la vista de reservas de apartamentos.
     */
    public void botonAlojamieto(ActionEvent actionEvent) throws IOException {
        stage = (Stage) botonAlojamieto.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("reservasApartamentos.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método para manejar el evento del botón "No Cuenta".
     * @param actionEvent El evento de acción generado por el botón "No Cuenta".
     * @throws IOException Si ocurre un error al cargar la vista de registro de cuenta.
     */
    public void noCuenta(ActionEvent actionEvent) throws IOException {
        stage = (Stage) noCuenta.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("registro-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
