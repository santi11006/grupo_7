package DAO.daoUsuario;

import java.util.Objects;

/**
 * La clase Usuario representa un usuario con su información básica.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class Usuario {
    private String email;
    private String telefono;
    private String nomapell;
    private String direccion;
    private String contrasenna;

    /**
     * Constructor de Usuario.
     * @param email       El correo electrónico del usuario.
     * @param telefono    El número de teléfono del usuario.
     * @param nomapell    El nombre y apellido del usuario.
     * @param direccion   La dirección del usuario.
     * @param contrasenna La contraseña del usuario.
     */
    public Usuario(String email, String telefono, String nomapell, String direccion, String contrasenna) {
        this.email = email;
        this.telefono = telefono;
        this.nomapell = nomapell;
        this.direccion = direccion;
        this.contrasenna = contrasenna;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param email El nuevo correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     * @return El número de teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     * @param telefono El nuevo número de teléfono del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el nombre y apellido del usuario.
     * @return El nombre y apellido del usuario.
     */
    public String getNomapell() {
        return nomapell;
    }

    /**
     * Establece el nombre y apellido del usuario.
     * @param nomapell El nuevo nombre y apellido del usuario.
     */
    public void setNomapell(String nomapell) {
        this.nomapell = nomapell;
    }

    /**
     * Obtiene la dirección del usuario.
     * @return La dirección del usuario.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del usuario.
     * @param direccion La nueva dirección del usuario.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getContrasenna() {
        return contrasenna;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto Usuario.
     * @return Una cadena que representa el objeto Usuario.
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %S, %s", email, telefono, nomapell, direccion, contrasenna);
    }

    /**
     * Indica si algún otro objeto es "igual" a este.
     * @param o El objeto a comparar con este.
     * @return Verdadero si y solo si el objeto dado es igual a este objeto.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(telefono, usuario.telefono);
    }

    /**
     * Devuelve un valor hash para este objeto.
     * @return Un número entero que representa el valor hash de este objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(telefono);
    }
}
