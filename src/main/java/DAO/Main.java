package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection1 = EstablecerConexion.getEstablecerConexion().getConexion();
             Connection connection2 = EstablecerConexion.getEstablecerConexion().getConexion();
             Connection connection3 = EstablecerConexion.getEstablecerConexion().getConexion()) {
            System.out.println(connection1);
            System.out.println(connection2);
            System.out.println(connection3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
