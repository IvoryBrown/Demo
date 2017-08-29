package hu.main;

import javax.swing.SwingUtilities;

import hu.swing.main.Swing;

public class Program {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Swing();
			}
		});

	}

}
