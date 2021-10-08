package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MusicaConnectionProvider {
	
	private static String url = "jdbc:sqlite:C:\\Users\\PC\\eclipse-workspace\\DataBases\\DB1.db";
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if(connection == null) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
	}
}
