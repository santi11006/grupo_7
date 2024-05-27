package DAO.daoAlojamientos;

import java.sql.SQLException;
import java.util.List;
/**
 * Interfaz que define las operaciones CRUD para la entidad Alojamientos.
 * @author santi
 * @version 1.0
 * @since 27/05/2024
 */
public interface AlojamientosDAO {
    //hacer metodos crud
    /**
     * Muestra la lista de todos los alojamientos.
     * @return una lista de objetos Alojamientos
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    List<Alojamientos> mostrarAlojaminetos() throws SQLException;
    /**
     * Añade un nuevo alojamiento a la base de datos.
     * @param alojamientos el objeto Alojamientos a añadir
     * @return true si el alojamiento fue añadido con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean annadirAlojamientos(Alojamientos alojamientos) throws SQLException;
    /**
     * Borra un alojamiento de la base de datos por su id.
     * @param id_alojamiento el ID del alojamiento a borrar
     * @return true si el alojamiento fue borrado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean borraAlojamientosPorId(int id_alojamiento) throws SQLException;
    /**
     * Actualiza los datos de un alojamiento existente.
     * @param id_alojamiento  el ID del alojamiento a actualizar
     * @param nombre          el nuevo nombre del alojamiento
     * @param direccion       la nueva dirección del alojamiento
     * @param tipoAlojamiento el nuevo tipo de alojamiento
     * @return true si el alojamiento fue actualizado con éxito, false en caso contrario
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    boolean actualizarAlojamiento(int id_alojamiento, String nombre, String direccion, TipoAlojamiento tipoAlojamiento) throws SQLException;
}
