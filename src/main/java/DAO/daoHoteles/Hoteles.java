package DAO.daoHoteles;

import DAO.daoAlojamientos.Alojamientos;
import DAO.daoAlojamientos.TipoAlojamiento;

public class Hoteles extends Alojamientos {
    private int numeroEstrella;
    private String tipoHabitacion;

    public Hoteles(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento, int numeroEstrella, String tipoHabitacion) {
        super(id_alojamiento, nombre, direccion, tipoAlojamiento);
        this.numeroEstrella = numeroEstrella;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNumeroEstrella() {
        return numeroEstrella;
    }

    public void setNumeroEstrella(int numeroEstrella) {
        this.numeroEstrella = numeroEstrella;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public java.lang.String toString() {
        return java.lang.String.format("%s , %d, %s",super.toString(),numeroEstrella,tipoHabitacion);
    }


}
