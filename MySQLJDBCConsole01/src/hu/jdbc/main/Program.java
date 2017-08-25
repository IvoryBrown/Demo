package hu.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/foldorszag";

	static final String USER = "root";
	static final String PASS = "12345";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("MySQL kapcsolódás...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Lekérdezés folyamatban...\n");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT *  FROM orszagok";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String id = rs.getString("orszag");
				String age = rs.getString("fovaros");
				String first = rs.getString("foldr_hely");

				System.out.print("Ország: " + id);
				System.out.print(", " + age);
				System.out.print(", " + first + "\n");

			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			System.err.println("Hiba az adatbázishoz kapcsolódás során!");
		} catch (Exception e) {
			System.err.println("Hiba a lekérdezés során");
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				System.err.println("Hiba a lekérdezés során");
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}