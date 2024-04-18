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
            String EMAILl = resultSet.getString("EMAIL");
            String TELEFONO = resultSet.getString("TELEFONO");
            String NOMAPELL = resultSet.getString("NOMAPELL");
            String DIRECCION = resultSet.getString("DIRECCION");
            String CONTRASENNA = resultSet.getString("CONTRASENNA");
            usuario =new Usuario(EMAILl,TELEFONO,NOMAPELL,DIRECCION,CONTRASENNA);
            usuarios.add(usuario);
        }
        return usuarios;
    }

    @Override
    public boolean annadirUsuario(Usuario usuario) throws SQLException {
        String sql = " INSERT INTO USUARIOS VALUES ('" + usuario.getEmail() + "', '"
                + usuario.getTelefono() + "'," + usuario.getNomapell() + "'" + usuario.getDireccion() + "''" + usuario.getContrasenna() + "' );";
        preparedStatement = conectar.prepareStatement(sql);
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean borrarPersonaPorTelefono(String telefono) throws SQLException {
        String sql = "DELETE FROM USUARIOS WHERE TELEFONO = '" + telefono + "';";
        PreparedStatement prepareStatement = conectar.prepareStatement(sql);
        prepareStatement.setString(1, telefono);
        int resultado = prepareStatement.executeUpdate();
        return resultado != 0;
    }

    @Override
    public boolean actualizarUsuario(String email, String telefono,String nomapell, String direccion, String contrasenna) throws SQLException {
        String sql = "UPDATE USUARIOS SET EMAIL = '" + email + "', NOMAPELL ='" + nomapell+ "', DIRECCION = '" + direccion + "',CONTRASENNA = '" + contrasenna + "' WHERE TELEFONO = '" + telefono + "';";
        PreparedStatement prepareStatement = conectar.prepareStatement(sql);
        int actualizarDatos = preparedStatement.executeUpdate();
        return actualizarDatos > 0;
    }
}
