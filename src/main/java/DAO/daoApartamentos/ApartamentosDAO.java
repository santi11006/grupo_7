package DAO.daoApartamentos;

import java.sql.SQLException;
import java.util.List;

public interface ApartamentosDAO {
    List<Apartamentos> getApartamentos() throws SQLException;
    boolean borraApartametosPorId(int id) throws SQLException;
    boolean actualizarApartametos(Apartamentos apartamentos) throws SQLException;
    boolean insertarApartamentos(Apartamentos apartamentos);
}
