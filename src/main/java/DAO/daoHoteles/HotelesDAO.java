package DAO.daoHoteles;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad Hoteles.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public interface HotelesDAO {

    /**
     * Obtiene una lista de todos los hoteles.
     *
     * @return una lista de objetos Hoteles
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    List<Hoteles> mostrarHoteles() throws SQLException;

    /**
     * Añade un nuevo hotel a la base de datos.
     *
     * @param hotel el objeto Hoteles a añadir
     * @return true si el hotel fue añadido con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean annadirHotele(Hoteles hotel) throws SQLException;

    /**
     * Borra un hotel de la base de datos por su id.
     *
     * @param id_alojamiento el id del hotel a borrar
     * @return true si el hotel fue borrado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean borrarHotelPorId(int id_alojamiento) throws SQLException;

    /**
     * Actualiza los datos de un hotel existente en la base de datos.
     *
     * @param hotele el objeto Hoteles con los datos actualizados
     * @return true si el hotel fue actualizado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean actualizarHotel(Hoteles hotele) throws SQLException;
}

