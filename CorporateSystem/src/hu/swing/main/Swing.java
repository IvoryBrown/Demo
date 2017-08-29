package hu.swing.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hu.settings.DataBaseConnection;

@SuppressWarnings("serial")
public class Swing extends JFrame implements ActionListener {
	JMenuBar menu;
	JMenu fileMenu;
	JMenuItem exitItem;
	JPanel panel;
	DataBaseConnection dataBase = new DataBaseConnection();

	public Swing() {
		fileMenu = new JMenu("Fájl");
		menu = new JMenuBar();
		exitItem = new JMenuItem("Kilépés");
		panel = new JPanel();

		menu.add(fileMenu);
		fileMenu.add(exitItem);
		exitItem.addActionListener(this);
		panel.add(dataBase.subtitle);
		panel.setBounds(10, 650, 1160, 25);
		panel.setBackground(Color.white);

		this.setLayout(null);
		this.setSize(1200, 750);
		centerWindow(this);
		this.add(panel);
		this.setJMenuBar(menu);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void centerWindow(java.awt.Window frame) {
		java.awt.Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitItem)
			System.exit(0);

	}
}
