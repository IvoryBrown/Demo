package hu.swing.games;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Program implements ActionListener, MouseListener, KeyListener {

	public static Program repuloJatek;

	public final int SZELESSEG = 1000, HOSSZUSAG = 750;

	public Megjelenit megjelenit;

	public Rectangle madar;

	public int kullancs, yMozgass, pontszam;

	public ArrayList<Rectangle> oszlopok;

	public boolean vege, start;

	public Random random;

	public Program() {

		JFrame grafika = new JFrame();
		Timer ido = new Timer(20, this);

		megjelenit = new Megjelenit();
		random = new Random();

		grafika.add(megjelenit);
		grafika.setTitle("Repülő Golyó");
		grafika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grafika.setSize(SZELESSEG, HOSSZUSAG);
		grafika.addMouseListener(this);
		grafika.addKeyListener(this);
		grafika.setResizable(false);
		grafika.setVisible(true);

		madar = new Rectangle(SZELESSEG / 2 - 10, HOSSZUSAG / 2 - 10, 20, 20);
		oszlopok = new ArrayList<Rectangle>();
		addOszlop(true);
		addOszlop(true);
		addOszlop(true);
		addOszlop(true);
		ido.start();
	}

	private void addOszlop(boolean start) {
		int hely = 300;
		int szelesseg = 100;
		int hosszusag = 10 + random.nextInt(350);

		if (start) {
			oszlopok.add(new Rectangle(SZELESSEG + szelesseg + oszlopok.size() * 300, HOSSZUSAG - hosszusag - 120,
					szelesseg, hosszusag));
			oszlopok.add(new Rectangle(SZELESSEG + szelesseg + (oszlopok.size() - 1) * 300, 0, szelesseg,
					HOSSZUSAG - hosszusag - hely));
		} else {
			oszlopok.add(new Rectangle(oszlopok.get(oszlopok.size() - 1).x + 600, HOSSZUSAG - hosszusag - 120,
					szelesseg, hosszusag));
			oszlopok.add(
					new Rectangle(oszlopok.get(oszlopok.size() - 1).x, 0, szelesseg, HOSSZUSAG - hosszusag - hely));
		}
	}

	private void szinesOszlop(Graphics g, Rectangle oszlop) {
		g.setColor(Color.green.darker());
		g.fillRect(oszlop.x, oszlop.y, oszlop.width, oszlop.height);

	}

	public void ugras() {

		if (vege) {
			madar = new Rectangle(SZELESSEG / 2 - 10, HOSSZUSAG / 2 - 10, 20, 20);
			oszlopok.clear();
			yMozgass = 0;
			pontszam = 0;

			addOszlop(true);
			addOszlop(true);
			addOszlop(true);
			addOszlop(true);

			vege = false;
		}

		if (!start) {
			start = true;
		} else if (!vege) {
			if (yMozgass > 0) {
				yMozgass = 0;
			}
			yMozgass -= 10;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		int sebesseg = 10;
		kullancs++;

		if (start) {

			for (int i = 0; i < oszlopok.size(); i++) {
				Rectangle oszlop = oszlopok.get(i);
				oszlop.x -= sebesseg;
				
			}

			if (kullancs % 2 == 0 && yMozgass < 15) {
				yMozgass += 3;
			}

			for (int i = 0; i < oszlopok.size(); i++) {
				Rectangle oszlop = oszlopok.get(i);
				if (oszlop.x + oszlop.width < 0) {
					oszlopok.remove(oszlop);
					if (oszlop.y == 0) {
						addOszlop(false);
					}
				}

			}

			madar.y += yMozgass;

			for (Rectangle oszlop : oszlopok) {

				if (oszlop.y == 0 && madar.x + madar.width / 2 > oszlop.x + oszlop.width / 2 - 10
						&& madar.x + madar.width / 2 < oszlop.x + oszlop.width / 2 + 10) {
					pontszam++;
					
				}

				if (oszlop.intersects(madar)) {
					vege = true;

					if (madar.x <= oszlop.x) {
						madar.x = oszlop.x - madar.width;

					} else {
						if (oszlop.y != 0) {
							madar.y = oszlop.y - madar.height;
						} else if (madar.y < oszlop.height) {
							madar.y = oszlop.height;
						}
					}
				}
			}

			if (madar.y > SZELESSEG - 120 || madar.y < 0) {

				vege = true;
			}
			if (madar.y + yMozgass >= SZELESSEG - 400) {
				madar.y = HOSSZUSAG - 120 - madar.height;
				vege = true;
			}

			megjelenit.repaint();
		}
	}

	public void repul(Graphics g) {

		g.setColor(Color.cyan);
		g.fillRect(0, 0, SZELESSEG, HOSSZUSAG);

		g.setColor(Color.green);
		g.fillRect(0, HOSSZUSAG - 120, SZELESSEG, 120);

		g.setColor(Color.blue);
		g.fillRect(0, HOSSZUSAG - 120, SZELESSEG, 20);

		g.setColor(Color.black);
		g.fillRect(madar.x, madar.y, madar.height, madar.width);

		for (Rectangle oszlop : oszlopok) {
			szinesOszlop(g, oszlop);
		}
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 40));

		if (!start) {
			g.drawString("Klikkelj az indításhoz!", 50, HOSSZUSAG / 2 - 50);
			g.drawString("Egér vagy N-betű", 50, HOSSZUSAG / 2 - 130);

		}
		if (vege) {
			g.drawString("VÉGE A JÁTÉKNAK!", 120, HOSSZUSAG / 2 - 50);

		}

		if (!vege && start) {
			g.drawString(String.valueOf(pontszam), 330, 60);
		}
	}

	public static void main(String[] args) {
		repuloJatek = new Program();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ugras();

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_N) {
			ugras();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
