package DAO.daoHoteles;

import DAO.daoAlojamientos.Alojamientos;
import DAO.daoAlojamientos.TipoAlojamiento;
/**
 * Clase que representa un hotel, que es un tipo de alojamiento.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class Hoteles extends Alojamientos {
    private int numeroEstrella;
    private String tipoHabitacion;

    /**
     * Constructor para crear una instancia de Hoteles.
     * @param id_alojamiento  el identificador único del alojamiento
     * @param nombre          el nombre del alojamiento
     * @param direccion       la dirección del alojamiento
     * @param tipoAlojamiento el tipo de alojamiento
     * @param numeroEstrella  el número de estrellas del hotel
     * @param tipoHabitacion  el tipo de habitación del hotel
     */
    public Hoteles(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento, int numeroEstrella, String tipoHabitacion) {
        super(id_alojamiento, nombre, direccion, tipoAlojamiento);
        this.numeroEstrella = numeroEstrella;
        this.tipoHabitacion = tipoHabitacion;
    }

    /**
     * Obtiene el número de estrellas del hotel.
     * @return el número de estrellas
     */
    public int getNumeroEstrella() {
        return numeroEstrella;
    }

    /**
     * Establece el número de estrellas del hotel.
     * @param numeroEstrella el nuevo número de estrellas
     */
    public void setNumeroEstrella(int numeroEstrella) {
        this.numeroEstrella = numeroEstrella;
    }

    /**
     * Obtiene el tipo de habitación del hotel.
     * @return el tipo de habitación
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * Establece el tipo de habitación del hotel.
     * @param tipoHabitacion el nuevo tipo de habitación
     */
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia de Hoteles.
     * @return una cadena que contiene la información del alojamiento, el número de estrellas y el tipo de habitación
     */
    @Override
    public java.lang.String toString() {
        return java.lang.String.format("%s , %d, %s",super.toString(),numeroEstrella,tipoHabitacion);
    }
}
