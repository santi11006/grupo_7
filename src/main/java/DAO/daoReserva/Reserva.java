package DAO.daoReserva;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa una reserva de alojamiento.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class Reserva {
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    private String email;
    private String telefono;
    private int id_alojamiento;

    /**
     * Constructor para crear una instancia de Reserva.
     * @param fecha_entrada    la fecha de entrada de la reserva
     * @param fecha_salida     la fecha de salida de la reserva
     * @param email            el correo electrónico del usuario que realiza la reserva
     * @param telefono         el número de teléfono del usuario que realiza la reserva
     * @param id_alojamiento   el identificador único del alojamiento reservado
     */
    public Reserva(LocalDate fecha_entrada, LocalDate fecha_salida, String email, String telefono, int id_alojamiento) {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.email = email;
        this.telefono = telefono;
        this.id_alojamiento = id_alojamiento;
    }

    /**
     * Obtiene la fecha de entrada de la reserva.
     * @return la fecha de entrada
     */
    public LocalDate getFecha_entrada() {
        return fecha_entrada;
    }

    /**
     * Establece la fecha de entrada de la reserva.
     * @param fecha_entrada la nueva fecha de entrada
     */
    public void setFecha_entrada(LocalDate fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    /**
     * Obtiene la fecha de salida de la reserva.
     * @return la fecha de salida
     */
    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    /**
     * Establece la fecha de salida de la reserva.
     * @param fecha_salida la nueva fecha de salida
     */
    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    /**
     * Obtiene el correo electrónico del usuario que realiza la reserva.
     * @return el correo electrónico
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario que realiza la reserva.
     * @param email el nuevo correo electrónico
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono del usuario que realiza la reserva.
     * @return el número de teléfono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario que realiza la reserva.
     * @param telefono el nuevo número de teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el identificador único del alojamiento reservado.
     * @return el identificador del alojamiento
     */
    public int getId_alojamiento() {
        return id_alojamiento;
    }

    /**
     * Establece el identificador único del alojamiento reservado.
     * @param id_alojamiento el nuevo identificador del alojamiento
     */
    public void setId_alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia de Reserva.
     * @return una cadena que contiene la información de la reserva
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %d", fecha_entrada, fecha_salida, email, telefono, id_alojamiento);
    }

    /**
     * Compara esta reserva con el objeto especificado para igualdad.
     * @param o el objeto a comparar
     * @return true si los objetos son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id_alojamiento == reserva.id_alojamiento && Objects.equals(fecha_entrada, reserva.fecha_entrada) && Objects.equals(telefono, reserva.telefono);
    }

    /**
     * Devuelve un valor de hash para esta reserva.
     * @return un valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(fecha_entrada, telefono, id_alojamiento);
    }
}
