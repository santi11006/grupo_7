package DAO.daoApartamentos;

import java.util.List;

public interface ApartamentosDAO {
    List<Apartamentos> getApartamentos();
    boolean borrarAparatmentosPorId(int id);
    boolean insertarApartamentos(Apartamentos apartamentos);
    boolean actualizarApartamentos(Apartamentos apartamentos);
}
