package DAO.daoUsuario;

import java.util.Objects;

public class Usuario {
    private String email;
    private String telefono;
    private String nomapell;
    private String direccion;
    private String contrasenna;

    public Usuario(String email, String telefono, String nomapell, String direccion, String contrasenna) {
        this.email = email;
        this.telefono = telefono;
        this.nomapell = nomapell;
        this.direccion = direccion;
        this.contrasenna = contrasenna;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNomapell() {
        return nomapell;
    }

    public void setNomapell(String nomapell) {
        this.nomapell = nomapell;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %S, %s",email,telefono,nomapell,direccion,contrasenna);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(telefono, usuario.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(telefono);
    }
}
