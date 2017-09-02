package hu.settings;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JLabel;

public class DataBaseConnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/zrt";
	static final String USER = "root";
	static final String PASS = "12345";
	private JLabel subtitle;

	public DataBaseConnection() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			subtitle = new JLabel("Csatlakozás... ", JLabel.CENTER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.close();
			subtitle.setText("Online");
			subtitle.setForeground(Color.GREEN);
		} catch (SQLException se) {
			subtitle.setText("Sikertelen Kapcsolodás");
			subtitle.setForeground(Color.RED);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	public JLabel getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(JLabel subtitle) {
		this.subtitle = subtitle;
	}
}
