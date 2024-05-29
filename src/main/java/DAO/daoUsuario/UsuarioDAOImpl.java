package DAO.daoUsuario;

import DAO.EstablecerConexion;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz UsuariosDAO que proporciona métodos para interactuar con la tabla de usuarios en la base de datos.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class UsuarioDAOImpl implements UsuariosDAO {
    private final Connection conectar;
    private Statement statement;
    private PreparedStatement preparedStatement;

    /**
     * Constructor de UsuarioDAOImpl que establece una conexión a la base de datos.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión a la base de datos.
     * @throws IOException  Si ocurre un error de E/S.
     */
    public UsuarioDAOImpl() throws SQLException, IOException {
        conectar = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    /**
     * Recupera una lista de todos los usuarios en la base de datos.
     *
     * @return Una lista de objetos Usuario que representan a los usuarios en la base de datos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    @Override
    public List<Usuario> mostrarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = " SELECT * FROM USUARIOS ;";
        statement = conectar.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Usuario usuario = null;
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String telefono = resultSet.getString("telefono");
            String nomapell = resultSet.getString("nomapell");
            String direccion = resultSet.getString("direccion");
            String contrasenna = resultSet.getString("contrasenna");
            usuario = new Usuario(email, telefono, nomapell, direccion, contrasenna);
            usuarios.add(usuario);
        }
        return usuarios;
    }

    /**
     * Añade un nuevo usuario a la base de datos.
     *
     * @param usuario El objeto Usuario que se va a añadir a la base de datos.
     * @return true si se añade correctamente, false si no.
     * @throws SQLException Si ocurre un error al ejecutar la inserción en la base de datos.
     */
    @Override
    public boolean annadirUsuario(Usuario usuario) throws SQLException {
        String sql = " INSERT INTO USUARIOS VALUES (?, ?, ?, ?, ?);";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setString(1, usuario.getEmail());
        preparedStatement.setString(2, usuario.getTelefono());
        preparedStatement.setString(3, usuario.getNomapell());
        preparedStatement.setString(4, usuario.getDireccion());
        preparedStatement.setString(5, usuario.getContrasenna());
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    /**
     * Elimina un usuario de la base de datos por su número de teléfono.
     *
     * @param telefono El número de teléfono del usuario que se va a eliminar.
     * @return true si se elimina correctamente, false si no.
     * @throws SQLException Si ocurre un error al ejecutar la eliminación en la base de datos.
     */
    @Override
    public boolean borrarPersonaPorTelefono(String telefono) throws SQLException {
        String sql = "DELETE FROM USUARIOS WHERE TELEFONO = ?";
        PreparedStatement prepareStatement = conectar.prepareStatement(sql);
        prepareStatement.setString(1, telefono);
        int resultado = prepareStatement.executeUpdate();
        return resultado != 0;
    }

    /**
     * Actualiza la información de un usuario en la base de datos.
     *
     * @param email       El nuevo correo electrónico del usuario.
     * @param telefono    El nuevo número de teléfono del usuario.
     * @param nomapell    El nuevo nombre y apellido del usuario.
     * @param direccion   La nueva dirección del usuario.
     * @param contrasenna La nueva contraseña del usuario.
     * @return true si se actualiza correctamente, false si no.
     * @throws SQLException Si ocurre un error al ejecutar la actualización en la base de datos.
     */
    @Override
    public boolean actualizarUsuario(String email, String telefono, String nomapell, String direccion, String contrasenna) throws SQLException {
        String sql = "UPDATE USUARIOS SET EMAIL = ?, NOMAPELL = ?, DIRECCION = ?, CONTRASENNA = ? WHERE TELEFONO = ? ;";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, telefono);
        preparedStatement.setString(3, nomapell);
        preparedStatement.setString(4, direccion);
        preparedStatement.setString(5, contrasenna);
        int actualizarDatos = preparedStatement.executeUpdate();
        return actualizarDatos > 0;
    }

    public boolean existeTelefonoUsuario(String telefono) throws SQLException {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE telefono = ?";
        PreparedStatement preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setString(1, telefono);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt(1) > 0;
        }

        return false;
    }

}
