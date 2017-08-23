package hu.swing.games.setting;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class PalyaGenerator {
	public int palya[][];
	public int teglaSzelesseg;
	public int teglaHosszusag;

	public PalyaGenerator(int sor, int oszlop) {
		palya = new int[sor][oszlop];
		for (int i = 0; i < palya.length; i++) {
			for (int j = 0; j < palya[0].length; j++) {
				palya[i][j] = 1;
			}
		}

		teglaSzelesseg = 540 / oszlop;
		teglaHosszusag = 150 / sor;
	}

	public void rajzol(Graphics2D rajz) {
		for (int i = 0; i < palya.length; i++) {
			for (int j = 0; j < palya[0].length; j++) {
				if (palya[i][j] > 0) {
					rajz.setColor(Color.WHITE);
					rajz.fillRect(j * teglaSzelesseg + 80, i * teglaHosszusag + 50, teglaSzelesseg, teglaHosszusag);

					rajz.setStroke(new BasicStroke(3));
					rajz.setColor(Color.BLACK);
					rajz.drawRect(j * teglaSzelesseg + 80, i * teglaHosszusag + 50, teglaSzelesseg, teglaHosszusag);

				}
			}

		}

	}

	public void setTeglaBeallitas(int beallitas, int sor, int oszlop) {
		palya[sor][oszlop] = beallitas;
	}

}
