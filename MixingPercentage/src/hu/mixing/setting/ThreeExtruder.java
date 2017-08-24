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

public class ThreeExtruder {

	Scanner beolvas = new Scanner(System.in);
	Date datum = new Date();
	DateFormat forma = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private double[] anyagSzazalekA, anyagSzazalekB, anyagSzazalekC;
	private ArrayList<String> anyagNevTombA, anyagNevTombB, anyagNevTombC;
	private double osszSzazalekA, osszSzazalekB, osszSzazalekC;

	private double osszeMennyisegInt;
	private String osszeMennyisegString;

	private int aExtruderSzazalekInt, bExtruderSzazalekInt, cExtruderSzazalekInt;
	private String aExtruderSzazalekString, bExtruderSzazalekString, cExtruderSzazalekString;

	private int anyagMennyiseg;
	private String anyagFajta;
	private String anyagSzazalek;
	private double beSzazalek;
	private String be;
	private boolean szam = false;

	public ThreeExtruder() {
		System.out.println("Három Extruder");
		beOlvasOsszKg();
		AExtruder();
		BExtruder();
		CExtruder();
		int abcExtruder = aExtruderSzazalekInt + bExtruderSzazalekInt + cExtruderSzazalekInt;
		if (abcExtruder == 100) {
			BeOlvasAExtruder();
		} else {
			System.out.println(abcExtruder + "% Biztos, hogy jó a % ?");
			new ThreeExtruder();
		}
	}

	private double beOlvasOsszKg() {
		szam = false;
		System.out.println("Összesen hány kg szeretnél keverni ? (pl: 500)");
		do {
			osszeMennyisegString = beolvas.next();
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

	private int AExtruder() {
		szam = false;
		System.out.println("Az \"A\" extruder hány százalék: ");
		do {
			aExtruderSzazalekString = beolvas.next();
			try {
				aExtruderSzazalekInt = Integer.parseInt(aExtruderSzazalekString);
				szam = true;
			} catch (NumberFormatException e) {
				System.err.println("Számot kértem!");
			}
		} while (!szam || aExtruderSzazalekInt < 0 || aExtruderSzazalekInt > 100);
		beolvas.reset();
		return aExtruderSzazalekInt;
	}

	private int BExtruder() {
		szam = false;
		System.out.println("Az \"B\" extruder hány százalék: ");
		do {
			bExtruderSzazalekString = beolvas.next();
			try {
				bExtruderSzazalekInt = Integer.parseInt(bExtruderSzazalekString);
				szam = true;
			} catch (NumberFormatException e) {
				System.err.println("Számot kértem!");
			}
		} while (!szam || bExtruderSzazalekInt < 0 || bExtruderSzazalekInt > 100);
		beolvas.reset();
		return bExtruderSzazalekInt;
	}

	private int CExtruder() {
		szam = false;
		System.out.println("Az \"C\" extruder hány százalék: ");
		do {
			cExtruderSzazalekString = beolvas.next();
			try {
				cExtruderSzazalekInt = Integer.parseInt(cExtruderSzazalekString);
				szam = true;
			} catch (NumberFormatException e) {
				System.err.println("Számot kértem!");
			}
		} while (!szam || cExtruderSzazalekInt < 0 || cExtruderSzazalekInt > 100);
		beolvas.reset();
		return cExtruderSzazalekInt;
	}

	private int beOlvasAnyagFajta() {
		szam = false;
		System.out.println(" hány fajta anyag lesz: ");
		do {
			anyagFajta = beolvas.next();
			try {
				anyagMennyiseg = Integer.parseInt(anyagFajta);
				szam = true;
			} catch (NumberFormatException e) {
				System.err.println("Számot kértem!");
			}
		} while (!szam || anyagMennyiseg < 0);
		beolvas.reset();
		return anyagMennyiseg;
	}

	private double BeSzazalek() {
		szam = false;
		do {
			anyagSzazalek = beolvas.next();
			try {
				beSzazalek = Double.parseDouble(anyagSzazalek);
				szam = true;
			} catch (NumberFormatException e) {
				System.err.println("Számot kértem!");
			}
		} while (!szam || beSzazalek < 0 || beSzazalek > 100);
		beolvas.reset();
		return beSzazalek;
	}

	private void BeOlvasAExtruder() {
		System.out.print("\"A\"-ba");
		beOlvasAnyagFajta();
		anyagSzazalekA = new double[anyagMennyiseg];
		anyagNevTombA = new ArrayList<String>();

		System.out.println("\"A\" csiga");
		for (int i = 0; i < anyagMennyiseg; i++) {
			System.out.println((i + 1) + ". Anyagneve: ");
			beolvas.nextLine();
			be = beolvas.nextLine();
			anyagNevTombA.add(be);
			System.out.println((i + 1) + ". Százalék: ");
			BeSzazalek();
			anyagSzazalekA[i] = beSzazalek;
		}
		beolvas.reset();
		for (int i = 0; i < anyagSzazalekA.length; i++) {
			osszSzazalekA = osszSzazalekA + anyagSzazalekA[i];
		}
		System.out.print("\"B\"-ba");
		beOlvasAnyagFajta();
		anyagSzazalekB = new double[anyagMennyiseg];
		anyagNevTombB = new ArrayList<String>();

		System.out.println("\"B\" csiga");
		for (int i = 0; i < anyagMennyiseg; i++) {
			System.out.println((i + 1) + ". Anyagneve: ");
			beolvas.nextLine();
			be = beolvas.nextLine();
			anyagNevTombB.add(be);
			System.out.println((i + 1) + ". Százalék: ");
			BeSzazalek();
			anyagSzazalekB[i] = beSzazalek;
		}
		beolvas.reset();
		for (int i = 0; i < anyagSzazalekB.length; i++) {
			osszSzazalekB = osszSzazalekB + anyagSzazalekB[i];
		}
		System.out.print("\"C\"-ba");
		beOlvasAnyagFajta();
		anyagSzazalekC = new double[anyagMennyiseg];
		anyagNevTombC = new ArrayList<String>();

		System.out.println("\"C\" csiga");
		for (int i = 0; i < anyagMennyiseg; i++) {
			System.out.println((i + 1) + ". Anyagneve: ");
			beolvas.nextLine();
			be = beolvas.nextLine();
			anyagNevTombC.add(be);
			System.out.println((i + 1) + ". Százalék: ");
			BeSzazalek();
			anyagSzazalekC[i] = beSzazalek;
		}
		beolvas.reset();
		for (int i = 0; i < anyagSzazalekC.length; i++) {
			osszSzazalekC = osszSzazalekC + anyagSzazalekC[i];
		}

		if (osszSzazalekA == 100 || osszSzazalekB == 100 || osszSzazalekC == 100) {
			try (PrintWriter pw = new PrintWriter(new FileWriter("f:\\keveres.txt"))) {
				pw.println();
				pw.printf("Dátum:" + forma.format(datum));
				pw.println("\r\nZsák = 25kg\r\nVödör = 5kg");
				pw.println("Összesen: " + osszeMennyisegInt + " kg keveresz!");
				System.out.println();
				System.out.println("Zsák = 25kg\nVödör = 5kg");
				for (int i = 0; i < anyagSzazalekA.length; i++) {

					double egySzazalekA = osszeMennyisegInt / 100;
					double eredmenyA = egySzazalekA * aExtruderSzazalekInt;
					double egyszazalek = eredmenyA / 100;
					double eredmeny = egyszazalek * anyagSzazalekA[i];
					double zsak = eredmeny / 25;
					int egeszZsak = (int) zsak;
					double getVodor = zsak - egeszZsak;
					int setVodor = (int) (getVodor * 5);
					double vodor = eredmeny / 5;
					int egeszVodor = (int) vodor;
					double getKg = vodor - egeszVodor;
					double kg = getKg * 5;
					System.out.println();
					System.out.println("Az \"A\" csiga " + aExtruderSzazalekInt + "%" + " azaz " + eredmenyA + "kg");
					System.out.println(anyagNevTombA.get(i));
					System.out.print(
							anyagSzazalekA[i] + "%\n" + "Összesen: " + String.format("%.1f", eredmeny) + " kg -> ");
					System.out.print("Azaz " + egeszZsak + " zsák és ");
					System.out.println(setVodor + " vödör " + String.format("%.1f", kg) + "Kg");
					System.out.println("Vagy: " + egeszVodor + " Vödör és " + String.format("%.1f", kg) + "kg");

					pw.println();
					pw.println(anyagNevTombA.get(i));
					pw.print(anyagSzazalekA[i] + "%\n" + "Összesen: " + String.format("%.1f", eredmeny) + " kg -> ");
					pw.print("Azaz " + egeszZsak + " zsák és ");
					pw.println(setVodor + " vödör " + String.format("%.1f", kg) + "Kg");
					pw.println("Vagy: " + egeszVodor + " Vödör és " + String.format("%.1f", kg) + "kg");

				}
				for (int i = 0; i < anyagSzazalekB.length; i++) {

					double egySzazalekA = osszeMennyisegInt / 100;
					double eredmenyA = egySzazalekA * bExtruderSzazalekInt;
					double egyszazalek = eredmenyA / 100;
					double eredmeny = egyszazalek * anyagSzazalekB[i];
					double zsak = eredmeny / 25;
					int egeszZsak = (int) zsak;
					double getVodor = zsak - egeszZsak;
					int setVodor = (int) (getVodor * 5);
					double vodor = eredmeny / 5;
					int egeszVodor = (int) vodor;
					double getKg = vodor - egeszVodor;
					double kg = getKg * 5;
					System.out.println();
					System.out.println("A \"B\" csiga " + bExtruderSzazalekInt + "%" + " azaz " + eredmenyA + "kg");
					System.out.println(anyagNevTombB.get(i));
					System.out.print(
							anyagSzazalekB[i] + "%\n" + "Összesen: " + String.format("%.1f", eredmeny) + " kg -> ");
					System.out.print("Azaz " + egeszZsak + " zsák és ");
					System.out.println(setVodor + " vödör " + String.format("%.1f", kg) + "Kg");
					System.out.println("Vagy: " + egeszVodor + " Vödör és " + String.format("%.1f", kg) + "kg");

					pw.println();
					pw.println(anyagNevTombB.get(i));
					pw.print(anyagSzazalekB[i] + "%\n" + "Összesen: " + String.format("%.1f", eredmeny) + " kg -> ");
					pw.print("Azaz " + egeszZsak + " zsák és ");
					pw.println(setVodor + " vödör " + String.format("%.1f", kg) + "Kg");
					pw.println("Vagy: " + egeszVodor + " Vödör és " + String.format("%.1f", kg) + "kg");
				}
				for (int i = 0; i < anyagSzazalekC.length; i++) {

					double egySzazalekA = osszeMennyisegInt / 100;
					double eredmenyA = egySzazalekA * cExtruderSzazalekInt;
					double egyszazalek = eredmenyA / 100;
					double eredmeny = egyszazalek * anyagSzazalekC[i];
					double zsak = eredmeny / 25;
					int egeszZsak = (int) zsak;
					double getVodor = zsak - egeszZsak;
					int setVodor = (int) (getVodor * 5);
					double vodor = eredmeny / 5;
					int egeszVodor = (int) vodor;
					double getKg = vodor - egeszVodor;
					double kg = getKg * 5;
					System.out.println();
					System.out.println("A \"C\" csiga " + cExtruderSzazalekInt + "%" + " azaz " + eredmenyA + "kg");
					System.out.println(anyagNevTombC.get(i));
					System.out.print(
							anyagSzazalekC[i] + "%\n" + "Összesen: " + String.format("%.1f", eredmeny) + " kg -> ");
					System.out.print("Azaz " + egeszZsak + " zsák és ");
					System.out.println(setVodor + " vödör " + String.format("%.1f", kg) + "Kg");
					System.out.println("Vagy: " + egeszVodor + " Vödör és " + String.format("%.1f", kg) + "kg");

					pw.println();
					pw.println(anyagNevTombC.get(i));
					pw.print(anyagSzazalekC[i] + "%\n" + "Összesen: " + String.format("%.1f", eredmeny) + " kg -> ");
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
		} else if (osszSzazalekA > 100 || osszSzazalekB > 100) {
			System.out.println();
			for (int i = 0; i < anyagSzazalekA.length; i++) {
				System.out.println(anyagSzazalekA[i] + "%");
			}
			System.out.println("____");
			System.err.println(osszSzazalekA + "% Bammeg Jenőtől tanultál számolni?");
			System.out.println();

		} else {
			System.out.println();
			for (int i = 0; i < anyagSzazalekA.length; i++) {
				System.out.println(anyagSzazalekA[i] + "%");
			}
			System.out.println("____");
			System.err.println(osszSzazalekA + "% Bammeg Jenőtől tanultál számolni?");
			System.out.println();

		}

	}

}
