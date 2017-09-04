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
import hu.swing.company.CompanySwing;
import hu.swing.workers.WorkersSwing;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Swing extends JFrame implements ActionListener {
	private JMenuBar menu;
	private JMenu fileMenu;
	private JMenuItem exitItem, workersItem, companyItem;
	private JPanel panel;
	private JButton jBtnWorkers, jBtnCompany, jBtnOrders;
	DataBaseConnection dataBase = new DataBaseConnection();

	@SuppressWarnings("static-access")
	public Swing() {
		super("CGS");

		fileMenu = new JMenu("File");
		fileMenu.setIcon(new ImageIcon(Swing.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));

		menu = new JMenuBar();
		menu.add(fileMenu);

		exitItem = new JMenuItem("Kilépés");
		exitItem.setIcon(
				new ImageIcon(Swing.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		exitItem.addActionListener(this);

		workersItem = new JMenuItem("Dolgozok");
		workersItem.addActionListener(this);

		companyItem = new JMenuItem("Partnerek");
		companyItem.addActionListener(this);

		panel = new JPanel();
		panel.add(dataBase.getSubtitle());
		panel.setBounds(10, 650, 1264, 25);
		panel.setBackground(new Color(224, 255, 255));

		jBtnWorkers = new JButton("Dolgozok");
		jBtnWorkers.setBounds(10, 11, 279, 139);
		jBtnWorkers.addActionListener(this);

		jBtnCompany = new JButton("Megrendelők");
		jBtnCompany.setBounds(10, 165, 279, 139);
		jBtnCompany.addActionListener(this);

		jBtnOrders = new JButton();
		jBtnOrders.setBounds(10, 321, 279, 139);

		fileMenu.add(workersItem);
		fileMenu.add(companyItem);
		fileMenu.add(exitItem);

		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Swing.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(176, 224, 230));
		this.setSize(1300, 750);
		new CenterWindow().centerWindow(this);
		this.getContentPane().add(panel);
		this.setJMenuBar(menu);
		this.getContentPane().add(jBtnWorkers);
		this.getContentPane().add(jBtnCompany);
		this.getContentPane().add(jBtnOrders);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitItem)
			System.exit(0);
		if (e.getSource() == jBtnWorkers || e.getSource() == workersItem)
			new WorkersSwing().Start();
		if (e.getSource() == jBtnCompany || e.getSource() == companyItem)
			new CompanySwing();
	}
}
