package DAO;

import org.sqlite.SQLiteConfig;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class EstablecerConexion {
    private static EstablecerConexion establecerConexion;
    private Connection conexion;
    private String url;

    private EstablecerConexion() throws IOException, SQLException {
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        Properties properties = new Properties();
        InputStream input = ClassLoader.getSystemResourceAsStream("config.properties");
        properties.load(input);
        String driver = properties.getProperty("DRIVER");
        String db     = properties.getProperty("DB");
        url = driver + ":" + db;
        conexion = DriverManager.getConnection(url,config.toProperties());
        System.out.println("Conectado.....");
    }
    public  static EstablecerConexion getEstablecerConexion() throws SQLException, IOException {
        if (establecerConexion == null)
            establecerConexion = new EstablecerConexion();
        return establecerConexion;
    }
    public Connection getConexion(){
        return conexion;
    }
}

