package DAO.daoUsuario;

import DAO.EstablecerConexion;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuariosDAO {
    private final Connection conectar;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public UsuarioDAOImpl() throws SQLException, IOException {
        conectar = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    @Override
    public List<Usuario> mostrarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = " SELECT * FROM USUARIOS ;";
        statement = conectar.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Usuario usuario = null;
        while(resultSet.next()){
            String email = resultSet.getString("email");
            String telefono = resultSet.getString("telefono");
            String nomapell = resultSet.getString("nomapell");
            String direccion = resultSet.getString("direccion");
            String contrasenna = resultSet.getString("contrasenna");
            usuario =new Usuario(email,telefono,nomapell,direccion,contrasenna);
            usuarios.add(usuario);
        }
        return usuarios;
    }

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

    @Override
    public boolean borrarPersonaPorTelefono(String telefono) throws SQLException {
        String sql = "DELETE FROM USUARIOS WHERE TELEFONO = ?";
        PreparedStatement prepareStatement = conectar.prepareStatement(sql);
        prepareStatement.setString(1, telefono);
        int resultado = prepareStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean actualizarUsuario(String email, String telefono,String nomapell, String direccion, String contrasenna) throws SQLException {
        String sql = "UPDATE USUARIOS SET EMAIL = ?, NOMAPELL = ?, DIRECCION = ?, CONTRASENNA = ? WHERE TELEFONO = ? ;";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,telefono);
        preparedStatement.setString(3,nomapell);
        preparedStatement.setString(4, direccion);
        preparedStatement.setString(5, contrasenna);
        int actualizarDatos = preparedStatement.executeUpdate();
        return actualizarDatos > 0;
    }
}
