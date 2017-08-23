package hu.mixing.setting;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class OneExtruder {
	private Scanner beolvas = new Scanner(System.in);
	Date datum = new Date();
	DateFormat forma = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private double osszeMennyisegInt;
	private int mennyiseg;
	private boolean szam = false;
	private double osszSzazalek;
	private double beSzazalek;
	private String be;

	public OneExtruder() {

	}

	private double beOlvasOsszKg() {
		szam = false;
		System.out.println("Összesen hány kg szeretnél keverni ? (pl: 500)");
		do {
			String osszeMennyisegString = beolvas.next();
			try {
				osszeMennyisegInt = Integer.parseInt(osszeMennyisegString);
				szam = true;
			} catch (NumberFormatException e) {
				System.err.println("Egész számot kértem!");
			}
		} while (!szam || osszeMennyisegInt < 0);
		beolvas.reset();
		return osszeMennyisegInt;
	}

	private int beOlvasAnyagFajta() {
		szam = false;
		System.out.println("Hány fajta anyag lesz: ");
		do {
			String anyagFajta = beolvas.next();
			try {
				mennyiseg = Integer.parseInt(anyagFajta);
				szam = true;
			} catch (NumberFormatException e) {
				System.err.println("Gondlod újra!");
			}
		} while (!szam || mennyiseg < 0);
		beolvas.reset();
		return mennyiseg;
	}

	private double BeSzazalek() {
		szam = false;
		do {
			String anyagFajta = beolvas.next();
			try {
				beSzazalek = Double.parseDouble(anyagFajta);
				szam = true;
			} catch (NumberFormatException e) {
				System.err.println("Gondlod újra!");
			}
		} while (!szam || beSzazalek < 0 || beSzazalek > 100);
		beolvas.reset();
		return beSzazalek;
	}

	public void BeOlvas() {
		System.out.println("Egy Csiga!");
		osszSzazalek = 0;
		beOlvasOsszKg();
		beOlvasAnyagFajta();

		double[] anyagSzazalek = new double[mennyiseg];
		ArrayList<String> anyagNev = new ArrayList<String>();

		for (int i = 0; i < mennyiseg; i++) {
			System.out.println((i + 1) + ". Anyagneve: ");
			beolvas.nextLine();
			be = beolvas.nextLine();
			anyagNev.add(be);
			System.out.println((i + 1) + ". Százalék: ");
			BeSzazalek();
			anyagSzazalek[i] = beSzazalek;
		}
		beolvas.reset();
		for (int i = 0; i < anyagSzazalek.length; i++) {
			osszSzazalek = osszSzazalek + anyagSzazalek[i];
		}

		if (osszSzazalek == 100) {
			try (PrintWriter pw = new PrintWriter(new FileWriter("f:\\keveres.txt"))) {
				pw.println();
				pw.printf("Dátum:" + forma.format(datum));
				pw.println("\r\nZsák = 25kg\r\nVödör = 5kg");
				pw.println("Összesen: " + osszeMennyisegInt + " kg keveresz!");
				System.out.println();
				System.out.println("Zsák = 25kg\nVödör = 5kg");
				System.out.println("Összesen: " + osszeMennyisegInt + " kg keveresz!");
				for (int i = 0; i < anyagSzazalek.length; i++) {

					double egyszazalek = osszeMennyisegInt / 100;
					double eredmeny = egyszazalek * anyagSzazalek[i];
					double zsak = eredmeny / 25;
					int egeszZsak = (int) zsak;
					double getVodor = zsak - egeszZsak;
					int setVodor = (int) (getVodor * 5);
					double vodor = eredmeny / 5;
					int egeszVodor = (int) vodor;
					double getKg = vodor - egeszVodor;
					double kg = getKg * 5;
					System.out.println();
					System.out.println(anyagNev.get(i));
					System.out.print(anyagSzazalek[i] + "%\n" + "Összesen: " + eredmeny + " kg -> ");
					System.out.print("Azaz " + egeszZsak + " zsák és ");
					System.out.println(setVodor + " vödör " + String.format("%.1f", kg) + "Kg");
					System.out.println("Vagy: " + egeszVodor + " Vödör és " + String.format("%.1f", kg) + "kg");

					pw.println();
					pw.println(anyagNev.get(i));
					pw.print(anyagSzazalek[i] + "%\n" + "Összesen: " + String.format("%.1f", eredmeny) + " kg -> ");
					pw.print("Azaz " + egeszZsak + " zsák és ");
					pw.println(setVodor + " vödör " + String.format("%.1f", kg) + "Kg");
					pw.println("Vagy: " + egeszVodor + " Vödör és " + String.format("%.1f", kg) + "kg");

				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		} else if (osszSzazalek >= 100) {
			System.out.println();
			for (int i = 0; i < anyagSzazalek.length; i++) {
				System.out.println(anyagSzazalek[i] + "%");
			}
			System.out.println("____");
			System.err.println(osszSzazalek + "% Bammeg Jenőtől tanultál számolni?");
			System.out.println();

		} else {
			System.out.println();
			for (int i = 0; i < anyagSzazalek.length; i++) {
				System.out.println(anyagSzazalek[i] + "%");
			}
			System.out.println("____");
			System.err.println(osszSzazalek + "% Bammeg Jenőtől tanultál számolni?");
			System.out.println();

		}

	}

}
