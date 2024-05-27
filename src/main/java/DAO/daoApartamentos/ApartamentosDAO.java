package DAO.daoApartamentos;

import java.sql.SQLException;
import java.util.List;
/**
 * Interfaz que define las operaciones CRUD para la entidad Apartamentos.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public interface ApartamentosDAO {
    /**
     * Obtiene una lista de todos los apartamentos.
     * @return una lista de objetos Apartamentos
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    List<Apartamentos> getApartamentos() throws SQLException;
    /**
     * Borra un apartamento de la base de datos por su id.
     * @param id el id del apartamento a borrar
     * @return true si el apartamento fue borrado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean borrarAparatmentosPorId(int id) throws SQLException;
    /**
     * Inserta un nuevo apartamento en la base de datos.
     * @param apartamentos el objeto Apartamentos a insertar
     * @return true si el apartamento fue insertado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean insertarApartamentos(Apartamentos apartamentos) throws SQLException;
    /**
     * Actualiza los datos de un apartamento existente en la base de datos.
     * @param apartamentos el objeto Apartamentos con los datos actualizados
     * @return true si el apartamento fue actualizado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean actualizarApartamentos(Apartamentos apartamentos) throws SQLException;
}
