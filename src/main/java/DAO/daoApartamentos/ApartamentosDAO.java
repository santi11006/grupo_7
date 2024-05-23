package DAO.daoApartamentos;

import java.sql.SQLException;
import java.util.List;

public interface ApartamentosDAO {
    List<Apartamentos> getApartamentos() throws SQLException;
    boolean borrarAparatmentosPorId(int id) throws SQLException;
    boolean insertarApartamentos(Apartamentos apartamentos) throws SQLException;
    boolean actualizarApartamentos(Apartamentos apartamentos) throws SQLException;
}
