package hu.mixing.main;

import java.util.Scanner;

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
		HaromCsiga haromcsiga = new HaromCsiga();
		EgyCsiga egycsiga = new EgyCsiga();
		if (osszRetegSzamInt == 1) {
			egycsiga.BeOlvas();
		} else if (osszRetegSzamInt == 3) {
			haromcsiga.InduloPont();
		} else if (osszRetegSzamInt == 4) {
			System.err.println("Hozzá csapod valamelyik géphez a GBL-t??");
			new Program();
		} else {
			System.err.println("Gondlod újra!");
			new Program();
		}
	}
}