package hu.swing.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hu.settings.CenterWindow;
import hu.settings.DataBaseConnection;
import hu.swing.workers.WorkersDaoImpl;

@SuppressWarnings("serial")
public class Swing extends JFrame implements ActionListener {
	private JMenuBar menu;
	private JMenu fileMenu;
	private JMenuItem exitItem;
	private JPanel panel;
	private JButton workersButton;
	private JMenuItem workersItem;
	DataBaseConnection dataBase = new DataBaseConnection();
	
	
	@SuppressWarnings("static-access")
	public Swing() {
		fileMenu = new JMenu("File");

		menu = new JMenuBar();
		menu.add(fileMenu);

		exitItem = new JMenuItem("Kilépés");
		exitItem.addActionListener(this);

		workersItem = new JMenuItem("Dolgozok");
		workersItem.addActionListener(this);

		panel = new JPanel();
		panel.add(dataBase.subtitle);
		panel.setBounds(10, 650, 1160, 25);
		panel.setBackground(Color.white);

		workersButton = new JButton();
		workersButton.setIcon(new ImageIcon("Image\\Workers.png"));
		workersButton.setBounds(20, 100, 350, 200);
		workersButton.addActionListener(this);

		fileMenu.add(workersItem);
		fileMenu.add(exitItem);

		this.setLayout(null);
		this.setSize(1200, 750);
		new CenterWindow().centerWindow(this);
		this.add(panel);
		this.setJMenuBar(menu);
		this.add(workersButton);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitItem)
			System.exit(0);
		if (e.getSource() == workersButton || e.getSource() == workersItem)
			new WorkersDaoImpl();
		

	}
}
