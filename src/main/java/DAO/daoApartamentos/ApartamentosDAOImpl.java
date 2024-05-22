package DAO.daoApartamentos;

import DAO.EstablecerConexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ApartamentosDAOImpl implements ApartamentosDAO {
    private final Connection conectar;
    private Statement statement;
    private PreparedStatement preparedStatement;
    public ApartamentosDAOImpl() throws SQLException, IOException {
        conectar = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    @Override
    public List<Apartamentos> getApartamentos() {
        return List.of();
    }

    @Override
    public boolean borrarAparatmentosPorId(int id) {
        return false;
    }

    @Override
    public boolean insertarApartamentos(Apartamentos apartamentos) {
        return false;
    }

    @Override
    public boolean actualizarApartamentos(Apartamentos apartamentos) {
        return false;
    }
}
