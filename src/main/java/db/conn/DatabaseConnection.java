package db.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private Connection con = null;
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=IssueTrace";
	private static final String USER = "sa";
	private static final String PASSWORD = "Aa123456";

	public DatabaseConnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public Connection getConnection() throws Exception {
		return con;
	}

	public void close() throws Exception {
		if (con != null) {
			con.close();
		}
	}
}