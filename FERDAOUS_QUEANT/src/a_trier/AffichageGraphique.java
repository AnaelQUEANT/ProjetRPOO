package a_trier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import graphicLayer.GBounded;
import graphicLayer.GOval;
import graphicLayer.GSpace;

public class AffichageGraphique {
	public static void affichageGraph(int nbFourmiOuvriere) {
		GSpace fenetre = new GSpace("La fourmilière", new Dimension(1000, 500));
		GBounded terrain = new GBounded();
		terrain.setColor(Color.RED);
		terrain.setDimension(new Dimension(1000, 500));
		fenetre.addElement(terrain);

		GBounded territoire = new GBounded();
		territoire.setColor(Color.GREEN);
		territoire.setPosition(new Point(100, 75));
		territoire.setDimension(new Dimension(750, 375));
		terrain.addElement(territoire);

		ArrayList<GOval> fourmis = genererFourmi(nbFourmiOuvriere);
		for (GOval fourmi : fourmis) {
			territoire.addElement(fourmi);
		}

		GBounded fourmiliere = new GBounded();
		fourmiliere.setColor(Color.BLACK);
		fourmiliere.setPosition(new Point(365, 180));
		fourmiliere.setDimension(new Dimension(20, 20));
		territoire.addElement(fourmiliere);

		ArrayList<GOval> proies = genererProies();
		for (GOval proie : proies) {
			terrain.addElement(proie);
		}

		fenetre.open();

		try {
			mouvementGlobal(fourmis, proies, terrain);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<GOval> genererFourmi(int nbCreation) {
		ArrayList<GOval> lesElem = new ArrayList<GOval>();
		for (int i = 0; i < nbCreation; i++) {
			GOval cercle = new GOval();
			cercle.setPosition(new Point(365, 180));
			cercle.setDimension(new Dimension(10, 10));
			cercle.setColor(Color.yellow);
			lesElem.add(cercle);
		}
		return lesElem;
	}

	private static ArrayList<GOval> genererProies() {
		ArrayList<GOval> lesElem = new ArrayList<GOval>();
		for (int i = 0; i < 4; i++) {
			GOval cercle = new GOval();
			cercle.setPosition(new Point(aleatoire(15, 800), aleatoire(15, 400)));
			cercle.setDimension(new Dimension(15, 15));
			cercle.setColor(Color.black);
			lesElem.add(cercle);
		}
		return lesElem;
	}

	private static void mouvementGlobal(ArrayList<GOval> lesFourmis, ArrayList<GOval> lesProies, GBounded terrain)
			throws InterruptedException {
		while (true) {
			for (GOval laFourmi : lesFourmis) {
				mouvementElem(laFourmi, 0, 740, 5, 365);
			}
			for (GOval laProie : lesProies) {
				if (laProie != null) {
					mouvementElem(laProie, 0, 980, 5, 480);
				}
			}
			for(GOval elemSuppr : colision(lesFourmis, lesProies)) {
				terrain.removeElement(elemSuppr);
			}
			Thread.sleep(50);
		}
	}

	private static void mouvementElem(GOval elem, int minX, int maxX, int minY, int maxY) {
		int x;
		int y;
		y = aleatoire(-5, 5);
		x = aleatoire(-5, 5);
		if (elem.getX() - x > minX && elem.getX() + x < maxX) {
			elem.setX(elem.getX() + x);
		}
		if (elem.getY() - y > minY && elem.getY() + y < maxY) {
			elem.setY(elem.getY() + y);
		}
		elem.repaint();
	}

	private static int aleatoire(int min, int max) {
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}

	private static ArrayList<GOval> colision(ArrayList<GOval> fourmis, ArrayList<GOval> proies) {
		ArrayList<GOval> proieASupprimer = new ArrayList<GOval>();
		for (GOval fourmi : fourmis) {
			for (GOval proie : proies) {
				if (proie != null && !proieASupprimer.contains(proie)) {
					if (fourmi.getX() == proie.getX() && fourmi.getY() == proie.getY()) {
						proieASupprimer.add(proie);
						break;
					}
				}
			}
		}
		return proieASupprimer;
	}

}
