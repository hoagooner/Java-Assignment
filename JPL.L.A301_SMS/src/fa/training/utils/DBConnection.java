package fa.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static final String HOSTNAME = "localhost";
	public static final String PORT = "1433";
	public static final String DATABASE = "customer";
	public static final String USER = "sa";
	public static final String PASSWORD = "123456";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";databaseName=" + DATABASE;
			conn = DriverManager.getConnection(url, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("connect failure");
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}