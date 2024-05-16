package DAO.daoApartamentos;

import DAO.daoAlojamientos.Alojamientos;
import DAO.daoAlojamientos.TipoAlojamiento;

import java.util.Objects;

public class Apartamentos extends Alojamientos {

    private int id_alojamiento;
    private int distancia;

    public Apartamentos(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento, int id_alojamiento1, int distancia) {
        super(id_alojamiento, nombre, direccion, tipoAlojamiento);
        this.id_alojamiento = id_alojamiento1;
        this.distancia = distancia;
    }

    public int getDistancia() {
        return distancia;
    }

    @Override
    public int getId_alojamiento() {
        return id_alojamiento;
    }

    public void setId_alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %d",super.toString(),id_alojamiento,distancia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apartamentos that = (Apartamentos) o;
        return id_alojamiento == that.id_alojamiento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id_alojamiento);
    }
}
