package DAO.daoUsuario;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la tabla de usuarios de la base de datos.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public interface UsuariosDAO {

    /**
     * Recupera una lista de todos los usuarios en la base de datos.
     * @return Una lista de objetos Usuario que representan a los usuarios en la base de datos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    List<Usuario> mostrarUsuarios() throws SQLException;

    /**
     * Añade un nuevo usuario a la base de datos.
     * @param usuario El objeto Usuario que se va a añadir a la base de datos.
     * @return true si se añade correctamente, false si no.
     * @throws SQLException Si ocurre un error al ejecutar la inserción en la base de datos.
     */
    boolean annadirUsuario(Usuario usuario) throws SQLException;

    /**
     * Elimina un usuario de la base de datos por su número de teléfono.
     * @param telefono El número de teléfono del usuario que se va a eliminar.
     * @return true si se elimina correctamente, false si no.
     * @throws SQLException Si ocurre un error al ejecutar la eliminación en la base de datos.
     */
    boolean borrarPersonaPorTelefono(String telefono) throws SQLException;

    /**
     * Actualiza la información de un usuario en la base de datos.
     * @param email       El nuevo correo electrónico del usuario.
     * @param telefono    El nuevo número de teléfono del usuario.
     * @param nomapell    El nuevo nombre y apellido del usuario.
     * @param direccion   La nueva dirección del usuario.
     * @param contrasenna La nueva contraseña del usuario.
     * @return true si se actualiza correctamente, false si no.
     * @throws SQLException Si ocurre un error al ejecutar la actualización en la base de datos.
     */
    boolean actualizarUsuario(String email, String telefono, String nomapell, String direccion, String contrasenna) throws SQLException;
    boolean existeTelefonoUsuario(String telefono) throws SQLException;
}
