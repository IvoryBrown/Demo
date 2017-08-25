package hu.jdbc.swing;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Program {

	private boolean status;

	public Program(String title) {
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(1300, 800);
		frame.add(getTablePanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private JPanel getTablePanel() {
		JPanel tableJPanel = new JPanel();
		tableJPanel.setLayout(new BorderLayout());
		String[] columns = { "Országok", "Főváros", "Földrajzi Hely", "Terület", "Államforma", "Népesség",
				"Népesség Fővaros", "Autójel", "Country", "Capital", "Pénznem", "Pénzjel", "Váltopénz", "Telefon",
				"GDP", "KAT" };
		Object[][] data = getEmployeeDetails();
		JTable employeeTable = new JTable(data, columns);
		tableJPanel.add(employeeTable.getTableHeader(), BorderLayout.NORTH);
		tableJPanel.add(employeeTable, BorderLayout.CENTER);
		return tableJPanel;
	}

	private Object[][] getEmployeeDetails() {
		Object[][] data = null;
		final String DRIVER_NAME = "com.mysql.jdbc.Driver";
		final String CONNECTION_URL = "jdbc:mysql://localhost:3306/foldorszag";
		final String USERNAME = "root";
		final String PASSWORD = "12345";
		final String QUERY = "SELECT * FROM orszagok";
		try {
			Class.forName(DRIVER_NAME);
			Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(QUERY);
			int rowCount = getRowCount(rs);
			int columnCount = getColumnCount(rs);
			data = new Object[rowCount][columnCount];
			rs.beforeFirst();
			int i = 0;
			while (rs.next()) {
				int j = 0;
				data[i][j++] = rs.getString("orszag");
				data[i][j++] = rs.getString("fovaros");
				data[i][j++] = rs.getString("foldr_hely");
				data[i][j++] = rs.getInt("terulet");
				data[i][j++] = rs.getString("allamforma");
				data[i][j++] = rs.getInt("nepesseg");
				data[i][j++] = rs.getInt("nep_fovaros");
				data[i][j++] = rs.getString("autojel");
				data[i][j++] = rs.getString("country");
				data[i][j++] = rs.getString("capital");
				data[i][j++] = rs.getString("penznem");
				data[i][j++] = rs.getString("penzjel");
				data[i][j++] = rs.getString("valtopenz");
				data[i][j++] = rs.getInt("telefon");
				data[i][j++] = rs.getInt("gdp");
				data[i][j++] = rs.getInt("kat");
				i++;
			}
			status = true;
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	private int getRowCount(ResultSet rs) {
		try {
			if (rs != null) {
				rs.last();
				return rs.getRow();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	private int getColumnCount(ResultSet rs) {
		try {
			if (rs != null)
				return rs.getMetaData().getColumnCount();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String toString() {
		return (status) ? "Adatok felsorolása sikeresen" : "Alkalmazási hiba történt";
	}

	public static void main(String[] args) {
		String title = "Ország adatok";
		Program employeeDetails = new Program(title);
		System.out.println(employeeDetails);
	}
}