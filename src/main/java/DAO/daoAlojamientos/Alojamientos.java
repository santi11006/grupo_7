package DAO.daoAlojamientos;

import java.util.Objects;

public class Alojamientos {
    private int id_alojamiento;//primary key
    private String nombre;
    private String direccion;
    private TipoAlojamiento tipoAlojamiento ;

    public Alojamientos() {
        this.id_alojamiento = id_alojamiento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public int getId_alojamiento() {
        return id_alojamiento;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoAlojamiento getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(TipoAlojamiento tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s",id_alojamiento,nombre,direccion,tipoAlojamiento);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alojamientos that = (Alojamientos) o;
        return id_alojamiento == that.id_alojamiento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_alojamiento);
    }
}
