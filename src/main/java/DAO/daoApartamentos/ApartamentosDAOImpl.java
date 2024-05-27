package DAO.daoApartamentos;

import DAO.EstablecerConexion;
import DAO.daoAlojamientos.TipoAlojamiento;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Implementación de la interfaz ApartamentosDAO para realizar operaciones CRUD en la tabla de apartamentos.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public class ApartamentosDAOImpl implements ApartamentosDAO {
    private final Connection conectar;
    private Statement statement;
    private PreparedStatement preparedStatement;

    /**
     * Constructor que establece la conexión con la base de datos.
     * @throws SQLException si ocurre un error al acceder a la base de datos
     * @throws IOException  si ocurre un error de entrada/salida
     */
    public ApartamentosDAOImpl() throws SQLException, IOException {
        conectar = EstablecerConexion.getEstablecerConexion().getConexion();
    }

    /**
     * Obtiene una lista de todos los apartamentos.
     * @return una lista de objetos Apartamentos
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<Apartamentos> getApartamentos() throws SQLException {
        List<Apartamentos> apartamentos = new ArrayList<>();
        String sql = "SELECT * FROM apartamentos";
        statement = conectar.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Apartamentos apartamento;
        while (resultSet.next()) {
            int id_alojamiento = resultSet.getInt("id_alojamiento");
            String nombre = resultSet.getString("nombre");
            String direccion = resultSet.getString("direccion");
            TipoAlojamiento tipoAlojamiento = TipoAlojamiento.valueOf(resultSet.getString("tipoAlojamiento"));
            int id_apartamento = resultSet.getInt("id_apartamento");
            int distancia = resultSet.getInt("distancia");
            apartamento = new Apartamentos(id_alojamiento, nombre, direccion, tipoAlojamiento, id_apartamento, distancia);
            apartamentos.add(apartamento);
        }
        return apartamentos;
    }

    /**
     * Borra un apartamento de la base de datos por su id.
     * @param id el id del apartamento a borrar
     * @return true si el apartamento fue borrado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public boolean borrarAparatmentosPorId(int id) throws SQLException {
        String sql = "DELETE FROM apartamentos WHERE id_alojamiento = ?";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    /**
     * Inserta un nuevo apartamento en la base de datos.
     * @param apartamentos el objeto Apartamentos a insertar
     * @return true si el apartamento fue insertado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    @Override
    public boolean insertarApartamentos(Apartamentos apartamentos) throws SQLException {
        String sql = "INSERT INTO apartamentos (id_alojamiento, nombre, direccion, tipoAlojamiento, id_apartamento, distancia) VALUES (?, ?, ?, ?, ?, ?)";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setInt(1, apartamentos.getId_alojamiento());
        preparedStatement.setString(2, apartamentos.getNombre());
        preparedStatement.setString(3, apartamentos.getDireccion());
        preparedStatement.setString(4, apartamentos.getTipoAlojamiento().toString());
        preparedStatement.setInt(5, apartamentos.getId_apartamentos());
        preparedStatement.setInt(6, apartamentos.getDistancia());
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }

    /**
     * Actualiza los datos de un apartamento existente en la base de datos.
     * @param apartamentos el objeto Apartamentos con los datos actualizados
     * @return true si el apartamento fue actualizado con éxito, false en caso contrario
     */
 @Override
    public boolean actualizarApartamentos(Apartamentos apartamentos) throws SQLException {
        String sql = "UPDATE apartamentos SET nombre = ?, direccion = ?, tipoAlojamiento = ?, distancia = ? WHERE id_alojamiento = ?";
        preparedStatement = conectar.prepareStatement(sql);
        preparedStatement.setString(1, apartamentos.getNombre());
        preparedStatement.setString(2, apartamentos.getDireccion());
        preparedStatement.setString(3, apartamentos.getTipoAlojamiento().toString());
        preparedStatement.setInt(4, apartamentos.getDistancia());
        preparedStatement.setInt(5, apartamentos.getId_alojamiento());
        int resultado = preparedStatement.executeUpdate();
        return resultado != 0;
    }
}

