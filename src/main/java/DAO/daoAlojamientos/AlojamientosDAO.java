package DAO.daoAlojamientos;

import java.sql.SQLException;
import java.util.List;

public interface AlojamientosDAO {
    //hacer metodos crud
    List<Alojamientos> mostrarAlojaminetos() throws SQLException;
    boolean annadirAlojamientos(Alojamientos alojamientos) throws SQLException;
    boolean borraAlojamientosPorId(int id_alojamiento) throws SQLException;
    boolean actualizarAlojamiento(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento) throws SQLException;
}
