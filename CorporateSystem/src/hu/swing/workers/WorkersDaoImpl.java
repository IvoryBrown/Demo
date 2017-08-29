package hu.swing.workers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import hu.settings.CenterWindow;

@SuppressWarnings("serial")
public class WorkersDaoImpl extends JFrame implements WorkersInterface {

	@SuppressWarnings("static-access")
	public WorkersDaoImpl() {
		this.setLayout(null);
		this.setSize(1200, 750);
		new CenterWindow().centerWindow(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(getTablePanel());
		this.setVisible(true);
	}

	private JPanel getTablePanel() {
		JPanel tableJPanel = new JPanel();
		tableJPanel.setLayout(new BorderLayout());
		String[] columns = { "Azonosító", "Vezeték Név", "Kereszt Név" };
		Object[][] data = getAllworkers();
		JTable employeeTable = new JTable(data, columns);
		employeeTable.setGridColor(Color.BLUE);
		tableJPanel.add(employeeTable.getTableHeader(), BorderLayout.NORTH);
		tableJPanel.add(employeeTable, BorderLayout.CENTER);
		return tableJPanel;
	}

	@Override
	public void add(WorkersConfig workersConfig) {
		// TODO Automatikusan előállított metóduscsonk

	}

	@Override
	public Object[][] getAllworkers() {
		Object[][] data = null;
		final String DRIVER_NAME = "com.mysql.jdbc.Driver";
		final String CONNECTION_URL = "jdbc:mysql://localhost:3306/zrt";
		final String USERNAME = "root";
		final String PASSWORD = "12345";
		final String QUERY = "SELECT * FROM workers";
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
				data[i][j++] = rs.getInt("id_workers");
				data[i][j++] = rs.getString("last_name");
				data[i][j++] = rs.getString("first_name");
				i++;
			}

			statement.close();
			connection.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}

	private int getColumnCount(ResultSet rs) {
		try {
			if (rs != null)
				return rs.getMetaData().getColumnCount();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}

}
