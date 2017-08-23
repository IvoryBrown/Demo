package hu.swing.games.main;

import javax.swing.JFrame;

import hu.swing.games.setting.GamesPaint;

public class Program {
	public static void main(String[] args) {
		JFrame grafika = new JFrame();
		GamesPaint jatek = new GamesPaint();
		
		grafika.setBounds(10, 10, 700, 600);
		grafika.setTitle("Fall Labda");
		grafika.setResizable(false);
		grafika.setVisible(true);
		grafika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		grafika.add(jatek);
	}
}
