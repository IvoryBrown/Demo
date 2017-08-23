package hu.swing.games.setting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamesPaint extends JPanel implements KeyListener, ActionListener {
	private boolean jatek = false;
	private int pontszam = 0;

	private int osszesKocka = 28;

	private Timer ido;
	private int kesleletettes = 8;

	private int jatekosX = 310;

	private int labdaX = 120;
	private int labdaY = 350;
	private int labdaXdir = -2;
	private int labdaYdir = -3;

	private PalyaGenerator palya;

	public GamesPaint() {
		palya = new PalyaGenerator(4, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		ido = new Timer(kesleletettes, this);
		ido.start();
	}

	public void paint(Graphics szinek) {

		szinek.setColor(Color.BLACK);
		szinek.fillRect(1, 1, 692, 592);

		palya.rajzol((Graphics2D) szinek);

		szinek.setColor(Color.yellow);
		szinek.fillRect(0, 0, 3, 592);
		szinek.fillRect(0, 0, 692, 3);
		szinek.fillRect(691, 0, 3, 592);

		szinek.setColor(Color.WHITE);
		szinek.setFont(new Font("van", Font.BOLD, 25));
		szinek.drawString("" + pontszam, 590, 30);

		szinek.setColor(Color.green);
		szinek.fillRect(jatekosX, 550, 100, 8);

		szinek.setColor(Color.yellow);
		szinek.fillOval(labdaX, labdaY, 20, 20);

		if (osszesKocka <= 0) {
			jatek = false;
			labdaXdir = 0;
			labdaYdir = 0;
			szinek.setColor(Color.red);
			szinek.setFont(new Font("van", Font.BOLD, 30));
			szinek.drawString("Nyertél", 190, 300);

			szinek.setFont(new Font("van", Font.BOLD, 20));
			szinek.drawString("Nyomj ENTERT az újrainditásra ", 260, 350);

		}
		if (labdaY > 590) {
			jatek = false;
			labdaXdir = 0;
			labdaYdir = 0;
			szinek.setColor(Color.pink);
			szinek.setFont(new Font("van", Font.BOLD, 30));
			szinek.drawString("Vége a játéknak, pontszám: " + pontszam, 230, 300);

			szinek.setFont(new Font("van", Font.BOLD, 20));
			szinek.drawString("Nyomj ENTERT az újrainditásra ", 230, 350);

		}

		szinek.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ido.start();
		if (jatek) {
			if (new Rectangle(labdaX, labdaY, 20, 20).intersects(new Rectangle(jatekosX, 550, 100, 8))) {
				labdaYdir = -labdaYdir;
			}

			A: for (int i = 0; i < palya.palya.length; i++) {
				for (int j = 0; j < palya.palya[0].length; j++) {
					if (palya.palya[i][j] > 0) {
						int teglaX = j * palya.teglaSzelesseg + 80;
						int teglaY = i * palya.teglaHosszusag + 50;
						int teglaSzelesseg = palya.teglaSzelesseg;
						int teglaHosszusag = palya.teglaHosszusag;

						Rectangle teg = new Rectangle(teglaX, teglaY, teglaSzelesseg, teglaHosszusag);
						Rectangle labdaRec = new Rectangle(labdaX, labdaY, 20, 20);
						Rectangle tegRec = teg;

						if (labdaRec.intersects(tegRec)) {
							palya.setTeglaBeallitas(0, i, j);
							osszesKocka--;
							pontszam += 5;

							if (labdaX + 19 <= tegRec.x || labdaX + 1 >= tegRec.x + tegRec.width) {
								labdaXdir = -labdaXdir;
							} else {
								labdaYdir = -labdaYdir;
							}
							break A;
						}
					}
				}
			}

			labdaX += labdaXdir;
			labdaY += labdaYdir;
			if (labdaX < 0) {
				labdaXdir = -labdaXdir;
			}
			if (labdaY < 0) {
				labdaYdir = -labdaYdir;
			}
			if (labdaX > 670) {
				labdaXdir = -labdaXdir;
			}
		}

		repaint();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Automatikusan előállított metóduscsonk

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Automatikusan előállított metóduscsonk

	}

	@Override
	public void keyPressed(KeyEvent akcio) {
		if (akcio.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (jatekosX >= 600) {
				jatekosX = 600;
			} else {
				mozgasJobbra();
			}
		}
		if (akcio.getKeyCode() == KeyEvent.VK_LEFT) {
			if (jatekosX < 10) {
				jatekosX = 10;
			} else {
				mozgasBalra();
			}
		}
		if (akcio.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!jatek) {
				jatek = true;
				labdaX = 120;
				labdaY = 350;
				labdaXdir = -2;
				labdaYdir = -3;
				jatekosX = 310;
				pontszam = 0;
				osszesKocka = 28;
				palya = new PalyaGenerator(4, 7);
				repaint();
			}
		}

	}

	private void mozgasJobbra() {
		jatek = true;
		jatekosX += 20;

	}

	private void mozgasBalra() {
		jatek = true;
		jatekosX -= 20;

	}

}
