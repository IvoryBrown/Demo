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
import hu.swing.workers.WorkersSwing;

@SuppressWarnings("serial")
public class Swing extends JFrame implements ActionListener {
	private JMenuBar menu;
	private JMenu fileMenu;
	private JMenuItem exitItem;
	private JPanel panel;
	private JButton workersButton;
	private JButton connectButton;
	private JMenuItem workersItem;
	DataBaseConnection dataBase = new DataBaseConnection();
	WorkersSwing workersSwing = new WorkersSwing();
	
	@SuppressWarnings("static-access")
	public Swing() {
		super("Jdbc");
		fileMenu = new JMenu("File");

		menu = new JMenuBar();
		menu.add(fileMenu);

		exitItem = new JMenuItem("Kilépés");
		exitItem.addActionListener(this);

		workersItem = new JMenuItem("Dolgozok");
		workersItem.addActionListener(this);

		panel = new JPanel();
		panel.add(dataBase.subtitle);
		panel.setBounds(10, 650, 1050, 25);
		panel.setBackground(Color.white);

		workersButton = new JButton();
		workersButton.setIcon(new ImageIcon("Image\\Workers.png"));
		workersButton.setBounds(20, 100, 350, 200);
		workersButton.addActionListener(this);

		connectButton = new JButton("Connect");
		connectButton.setBounds(1070, 650, 100, 25);
		connectButton.addActionListener(this);

		fileMenu.add(workersItem);
		fileMenu.add(exitItem);

		this.setLayout(null);
		this.setSize(1200, 750);
		new CenterWindow().centerWindow(this);
		this.add(panel);
		this.setJMenuBar(menu);
		this.add(workersButton);
		this.add(connectButton);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitItem)
			System.exit(0);
		if (e.getSource() == workersButton || e.getSource() == workersItem)
			workersSwing.Start();
		if (e.getSource() == connectButton)
			dataBase.subtitle.setText("todo");;
	}
}
