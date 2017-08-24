package hu.mixing.main;

import java.util.Scanner;

import hu.mixing.setting.OneExtruder;
import hu.mixing.setting.ThreeExtruder;

public class Program {
	private boolean szam = true;
	private String osszRetegSzamString;
	private int osszRetegSzamInt;
	private Scanner beolvas = new Scanner(System.in);

	public Program() {
		beOlvasRetegSzam();
		getOsszRetegSzamInt();
	}

	public static void main(String[] args) {
		new Program();
	}

	public void beOlvasRetegSzam() {
		szam = false;
		System.out.println("Réteg szám:");
		do {
			osszRetegSzamString = beolvas.next();
			try {
				osszRetegSzamInt = Integer.parseInt(osszRetegSzamString);
				szam = true;
			} catch (NumberFormatException e) {
				System.err.println("Egész számot kértem!");
			}
		} while (!szam || osszRetegSzamInt < 0);
		beolvas.reset();
	}

	public void getOsszRetegSzamInt() {
		if (osszRetegSzamInt == 1) {
			new OneExtruder();
		} else if (osszRetegSzamInt == 3) {
			new ThreeExtruder();
		} else {
			System.err.println("Gondlod újra!");
			new Program();
		}
	}
}