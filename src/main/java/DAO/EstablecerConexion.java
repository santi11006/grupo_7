package DAO;

import org.sqlite.SQLiteConfig;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase para establecer la conexión con la base de datos.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class EstablecerConexion {
    private static EstablecerConexion establecerConexion;
    private Connection conexion;
    private String url;

    /**
     * Constructor privado de EstablecerConexion.
     * @throws IOException  Si ocurre un error de E/S al leer el archivo de configuración.
     * @throws SQLException Si ocurre un error al establecer la conexión con la base de datos.
     */
    private EstablecerConexion() throws IOException, SQLException {
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        Properties properties = new Properties();
        InputStream input = ClassLoader.getSystemResourceAsStream("config.properties");
        properties.load(input);
        String driver = properties.getProperty("DRIVER");
        String db = properties.getProperty("DB");
        url = driver + ":" + db;
        conexion = DriverManager.getConnection(url, config.toProperties());
        System.out.println("Conectado.....");
    }

    /**
     * Método estático para obtener la instancia única de EstablecerConexion.
     * @return La instancia de EstablecerConexion.
     * @throws SQLException Si ocurre un error al establecer la conexión con la base de datos.
     * @throws IOException  Si ocurre un error de E/S al leer el archivo de configuración.
     */
    public static EstablecerConexion getEstablecerConexion() throws SQLException, IOException {
        if (establecerConexion == null)
            establecerConexion = new EstablecerConexion();
        return establecerConexion;
    }

    /**
     * Obtiene la conexión establecida con la base de datos.
     * @return La conexión establecida.
     */
    public Connection getConexion() {
        return conexion;
    }
}
