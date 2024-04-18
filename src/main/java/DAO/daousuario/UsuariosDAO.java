package DAO.daousuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuariosDAO {
    //crud
    List<Usuario> mostrarUsuarios() throws SQLException;
    boolean annadirUsuario(Usuario usuario) throws SQLException;
    boolean borrarPersonaPorTelefono(String telefono) throws SQLException;
    boolean actualizarUsuario(String email, String telefono,String nomapell, String direccion, String contrasenna ) throws SQLException;
}
