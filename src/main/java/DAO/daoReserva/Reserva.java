package DAO.daoReserva;

import DAO.daoAlojamientos.TipoAlojamiento;
import DAO.daoApartamentos.Apartamentos;
import DAO.daoUsuario.Usuario;

import java.time.LocalDate;

public class Reserva extends  Apartamentos{
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    private String email;

    public Reserva(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento, int id_apartamentos, int distancia, LocalDate fecha_entrada, LocalDate fecha_salida, String email) {
        super(id_alojamiento, nombre, direccion, tipoAlojamiento, id_apartamentos, distancia);
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.email = email;
    }
}
