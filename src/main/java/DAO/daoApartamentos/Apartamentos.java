package DAO.daoApartamentos;

import DAO.daoAlojamientos.Alojamientos;
import DAO.daoAlojamientos.TipoAlojamiento;

import java.util.Objects;

public class Apartamentos extends Alojamientos {
    private int id_apartamentos;
    private int distancia;

    public Apartamentos(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento, int id_apartamentos, int distancia) {
        super(id_alojamiento, nombre, direccion, tipoAlojamiento);
        this.id_apartamentos = id_apartamentos;
        this.distancia = distancia;
    }

    public int getId_apartamentos() {
        return id_apartamentos;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %d ",super.toString(), id_apartamentos,distancia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apartamentos that = (Apartamentos) o;
        return id_apartamentos == that.id_apartamentos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id_apartamentos);
    }
}
