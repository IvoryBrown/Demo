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

				String country = rs.getString("orszag");
				String capital = rs.getString("fovaros");
				String geographicLocation = rs.getString("foldr_hely");
				Integer area = rs.getInt("terulet");
				String formOfGovernment = rs.getString("allamforma");
				Integer population = rs.getInt("nepesseg");
				Integer populationCapital = rs.getInt("nep_fovaros");
				String carSignal = rs.getString("autojel");
				String countrys = rs.getString("country");
				String capitals = rs.getString("capital");
				String currency = rs.getString("penznem");
				String moneySign = rs.getString("penzjel");
				String moneyChanger = rs.getString("valtopenz");
				Integer phone = rs.getInt("telefon");
				Integer gdp = rs.getInt("gdp");
				Integer kat = rs.getInt("kat");

				System.out.print("Ország: " + country);
				System.out.print(", Főváros: " + capital);
				System.out.print(", Földrajzi hely: " + geographicLocation);
				System.out.print(", Területcapital: " + area);
				System.out.print(", Államforma: " + formOfGovernment);
				System.out.print(", Népesség: " + population);
				System.out.print(", Népesség főváros: " + populationCapital);
				System.out.print(", Autójel: " + carSignal);
				System.out.print(", Country: " + countrys);
				System.out.print(", Capital: " + capitals);
				System.out.print(", Pénznem: " + currency);
				System.out.print(", Pénzjel: " + moneySign);
				System.out.print(", Váltó pénz: " + moneyChanger);
				System.out.print(", Telefon: " + phone);
				System.out.print(", Gdp: " + gdp);
				System.out.println(", Kat: " + kat);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			System.err.println("Hiba az adatbázishoz kapcsolódás során!");
		} catch (Exception e) {
			System.err.println("Hiba a lekérdezés során");
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
			}
		}
		System.out.println("Viszlát!");
	}
}