package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.MusicaConnectionProvider;
import model.Banda;

public class BandaDAOImpl implements IBandaDAO {
	
	private Banda toBanda(ResultSet result) {
		//Constructor: int id, String nombre, int genero_id, int calificacion
		try {
			return new Banda(result.getInt(1),
							result.getString(2),
							result.getInt(3),
							result.getInt(4));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public List<Banda> findAll() {
		try {
			/* 1- Crear Consulta
			 * 2- Obtener Conexxion
			 * 3- Preparar la Consulta
			 * 4- Ejecutar Consulta
			 * 5- Leer Resultados
			 * */
			String query = "SELECT * FROM BANDAS"; // 1
			Connection conn = MusicaConnectionProvider.getConnection(); // 2
			
			PreparedStatement statement = conn.prepareStatement(query); // 3
			ResultSet results = statement.executeQuery(); // 4
			
			List<Banda> bandas = new LinkedList<Banda>();
			while(results.next()) {
				bandas.add(toBanda(results));
			}
			return bandas; // 5
			
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			/* 1- Crear Consulta
			 * 2- Obtener Conexxion
			 * 3- Preparar la Consulta
			 * 4- Ejecutar Consulta
			 * 5- Leer Resultados
			 * */
			String query = "SELECT COUNT(ID) AS TOTAL FROM BANDAS"; // 1
			Connection conn = MusicaConnectionProvider.getConnection(); // 2
			
			PreparedStatement statement = conn.prepareStatement(query); // 3
			ResultSet result = statement.executeQuery(); // 4
			return result.getInt("TOTAL"); // 5
			
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public int insert(Banda t) {
		try {
			/* 1- Crear Consulta
			 * 2- Obtener Conexion
			 * 3- Preparar la Consulta
			 * 4- Ejecutar Consulta
			 * 5- Leer Resultados
			 * */
			String query = "INSERT INTO BANDAS (ID, NOMBRE, GENERO_ID, CALIFICACION) "
							+ "VALUES(?, ?, ?, ?)"; // 1
			Connection conn = MusicaConnectionProvider.getConnection(); // 2
			
			PreparedStatement statement = conn.prepareStatement(query); // 3
			statement.setInt(1, t.getId());
			statement.setString(2, t.getNombre());
			statement.setInt(3, t.getGenero_id());
			statement.setInt(4, t.getCalificacion());
			
			return statement.executeUpdate(); // 4 y 5
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Banda t) {
		try {
			/* 1- Crear Consulta
			 * 2- Obtener Conexion
			 * 3- Preparar la Consulta
			 * 4- Ejecutar Consulta
			 * 5- Leer Resultados
			 * */
			String query = "UPDATE BANDAS SET CALIFICACION = ?, GENERO_ID = ? WHERE ID = ?"; // 1
			Connection conn = MusicaConnectionProvider.getConnection(); // 2
			
			PreparedStatement statement = conn.prepareStatement(query); // 3
			statement.setInt(1, t.getCalificacion());
			statement.setInt(2, t.getGenero_id());
			statement.setInt(3, t.getId());
			
			return statement.executeUpdate(); // 4 y 5
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Banda t) {
		try {
			/* 1- Crear Consulta
			 * 2- Obtener Conexion
			 * 3- Preparar la Consulta
			 * 4- Ejecutar Consulta
			 * 5- Leer Resultados
			 * */
			String query = "DELETE FROM WHERE ID = ?"; // 1
			Connection conn = MusicaConnectionProvider.getConnection(); // 2
			
			PreparedStatement statement = conn.prepareStatement(query); // 3
			statement.setInt(1, t.getId());
			
			return statement.executeUpdate(); // 4 y 5
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public Banda findById(int id) {
		// "SELECT * FROM ... WHERE ID = ?"
		// statement.setInt(...)
		// if(result.next()){ return toBanda(result)} else return null
		try {
			/* 1- Crear Consulta
			 * 2- Obtener Conexion
			 * 3- Preparar la Consulta
			 * 4- Ejecutar Consulta
			 * 5- Leer Resultados
			 * */
			String query = "SELECT * FROM BANDAS WHERE ID = ?"; // 1
			Connection conn = MusicaConnectionProvider.getConnection(); // 2
			
			PreparedStatement statement = conn.prepareStatement(query); // 3
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return toBanda(result);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@SuppressWarnings("unused")
	public List<Banda> findByNombre(String nombre) {
		// mezcla de findById con findAll, porque puede retornar una lista.
		try {
			/* 1- Crear Consulta
			 * 2- Obtener Conexion
			 * 3- Preparar la Consulta
			 * 4- Ejecutar Consulta
			 * 5- Leer Resultados
			 * */
			String query = "SELECT * FROM BANDAS WHERE NOMBRE = ?"; // 1
			Connection conn = MusicaConnectionProvider.getConnection(); // 2
			
			PreparedStatement statement = conn.prepareStatement(query); // 3
			statement.setString(1, nombre);
			
			ResultSet results = statement.executeQuery();
			
			List<Banda> bandas = new LinkedList<Banda>();
			while(results.next()) {
				bandas.add(toBanda(results));
			}
			if(bandas != null) {
				return bandas;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

}
