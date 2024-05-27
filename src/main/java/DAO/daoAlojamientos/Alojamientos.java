package DAO.daoAlojamientos;

import java.util.Objects;
/**
 * Clase que representa un alojamiento.
 * @author santi
 * @version 1.027/05/2024
 * @since
 */
public class Alojamientos {
    private int id_alojamiento;//primary key
    private String nombre;
    private String direccion;
    private TipoAlojamiento tipoAlojamiento ;

    /**
     * Constructor para crear una instancia de Alojamientos.
     * @param id_alojamiento  el identificador único del alojamiento
     * @param nombre          el nombre del alojamiento
     * @param direccion       la dirección del alojamiento
     * @param tipoAlojamiento el tipo de alojamiento
     */
    public Alojamientos(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento) {
        this.id_alojamiento = this.id_alojamiento;
        this.nombre = this.nombre;
        this.direccion = this.direccion;
        this.tipoAlojamiento = this.tipoAlojamiento;
    }
    /**
     * Obtiene el identificador único del alojamiento.
     * @return el id del alojamiento
     */
    public int getId_alojamiento() {
        return id_alojamiento;
    }
    /**
     * Obtiene el nombre del alojamiento.
     * @return el nombre del alojamiento
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del alojamiento.
     * @param nombre el nuevo nombre del alojamiento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene la dirección del alojamiento.
     * @return la dirección del alojamiento
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Establece la dirección del alojamiento.
     * @param direccion la nueva dirección del alojamiento
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Obtiene el tipo de alojamiento.
     * @return el tipo de alojamiento
     */
    public TipoAlojamiento getTipoAlojamiento() {
        return tipoAlojamiento;
    }
    /**
     * Establece el tipo de alojamiento.
     * @param tipoAlojamiento el nuevo tipo de alojamiento
     */
    public void setTipoAlojamiento(TipoAlojamiento tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }
    /**
     * Devuelve una representación en forma de cadena de la instancia de Alojamientos.
     * @return una cadena que contiene el id, nombre, dirección y tipo de alojamiento
     */
    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s",id_alojamiento,nombre,direccion,tipoAlojamiento);

    }
    /**
     * Compara este objeto con el objeto especificado para ver si son iguales.
     * @param o el objeto a comparar
     * @return true si los objetos son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alojamientos that = (Alojamientos) o;
        return id_alojamiento == that.id_alojamiento;
    }
    /**
     * Devuelve el valor hash para el objeto.
     * @return el valor hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_alojamiento);
    }
}
