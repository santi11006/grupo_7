package org.example.proyecto_grupo7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class MiApplication extends Application {
    /**
     * Método principal de la aplicación que inicia la interfaz gráfica.
     * @param stage El escenario principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar la vista.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MiApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        stage.setTitle("Aplicacion!!!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal que inicia la aplicación.
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}
