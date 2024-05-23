package DAO.daoReserva;

import DAO.daoAlojamientos.TipoAlojamiento;
import DAO.daoApartamentos.Apartamentos;
import DAO.daoUsuario.Usuario;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva{
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    private String email;
    private String telefono;
    private int id_alojamiento;

    public Reserva(LocalDate fecha_entrada, LocalDate fecha_salida, String email, String telefono, int id_alojamiento) {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.email = email;
        this.telefono = telefono;
        this.id_alojamiento = id_alojamiento;
    }

    public Reserva() {

    }

    public LocalDate getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(LocalDate fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
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

    public int getId_alojamiento() {
        return id_alojamiento;
    }

    public void setId_alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %d",fecha_entrada, fecha_salida, email, telefono, id_alojamiento);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id_alojamiento == reserva.id_alojamiento && Objects.equals(fecha_entrada, reserva.fecha_entrada) && Objects.equals(telefono, reserva.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha_entrada, telefono, id_alojamiento);
    }
}
