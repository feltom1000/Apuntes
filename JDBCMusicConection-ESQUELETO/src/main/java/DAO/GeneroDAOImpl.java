package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.MusicaConnectionProvider;
import model.Banda;
import model.Genero;

public class GeneroDAOImpl implements IGeneroDAO {
	
	private Genero toGenero(ResultSet result) {
		try {
			return new Genero(result.getInt(1),
							result.getString(2));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public List<Genero> findAll() {
		try {
			/* 1- Crear Consulta
			 * 2- Obtener Conexxion
			 * 3- Preparar la Consulta
			 * 4- Ejecutar Consulta
			 * 5- Leer Resultados
			 * */
			String query = "SELECT * FROM GENEROS"; // 1
			Connection conn = MusicaConnectionProvider.getConnection(); // 2
			
			PreparedStatement statement = conn.prepareStatement(query); // 3
			ResultSet results = statement.executeQuery(); // 4
			
			List<Genero> generos = new LinkedList<Genero>();
			while(results.next()) {
				generos.add(toGenero(results));
			}
			return generos; // 5
			
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

	public int insert(Genero t) {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

	public int update(Genero t) {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

	public int delete(Genero t) {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

}
