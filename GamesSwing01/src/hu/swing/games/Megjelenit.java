package hu.swing.games;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Megjelenit extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Program.repuloJatek.repul(g);
	}
}
