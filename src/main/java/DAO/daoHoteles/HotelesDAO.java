package DAO.daoHoteles;

import java.sql.SQLException;
import java.util.List;

public interface HotelesDAO {
    List<Hoteles> mostrarHoteles() throws SQLException;
    boolean annadirHotele(Hoteles hotel) throws SQLException;
    boolean borrarHotelPorId(int id_hotel) throws SQLException;
    boolean actualizarHotel();

}
