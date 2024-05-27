package DAO.daoApartamentos;

import DAO.daoAlojamientos.Alojamientos;
import DAO.daoAlojamientos.TipoAlojamiento;

import java.util.Objects;
/**
 * Clase que representa un apartamento, que es un tipo de alojamiento.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class Apartamentos extends Alojamientos {
    private int id_apartamentos;
    private int distancia;

    /**
     * Constructor para crear una instancia de Apartamentos.
     * @param id_alojamiento   el identificador único del alojamiento
     * @param nombre           el nombre del alojamiento
     * @param direccion        la dirección del alojamiento
     * @param tipoAlojamiento  el tipo de alojamiento
     * @param id_apartamentos  el identificador único del apartamento
     * @param distancia        la distancia del apartamento a un punto de interés
     */
    public Apartamentos(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento, int id_apartamentos, int distancia) {
        super(id_alojamiento, nombre, direccion, tipoAlojamiento);
        this.id_apartamentos = id_apartamentos;
        this.distancia = distancia;
    }
    /**
     * Obtiene el identificador único del apartamento.
     * @return el id del apartamento
     */
    public int getId_apartamentos() {
        return id_apartamentos;
    }

    /**
     * Obtiene la distancia del apartamento a un punto de interés.
     * @return la distancia en unidades de medida correspondientes
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * Establece la distancia del apartamento a un punto de interés.
     * @param distancia la nueva distancia en unidades de medida correspondientes
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia de Apartamentos.
     * @return una cadena que contiene la información del alojamiento, id del apartamento y distancia
     */
    @Override
    public String toString() {
        return String.format("%s, %d, %d ",super.toString(), id_apartamentos,distancia);
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
        if (!super.equals(o)) return false;
        Apartamentos that = (Apartamentos) o;
        return id_apartamentos == that.id_apartamentos;
    }

    /**
     * Devuelve el valor hash para el objeto.
     * @return el valor hash del objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id_apartamentos);
    }
}
