package a_trier;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Simulateur {
	static Terrain terrain;

	public static void main(String args[]) throws InterruptedException {
		terrain = new Terrain();
		mainLoop();
	}

	static void mainLoop() throws InterruptedException {
		int nbJour = 0;
		while (true) {
			terrain.step();
			terrain.fourmiliere.ponte();
			nbJour++;
			System.out.println("Jour " + nbJour + " : ");
			System.out.print("Pourcentage adulte : Ouvriere : " + terrain.fourmiliere.getPourcentageRole()[0] + "%");
			System.out.print(" | Soldat : " + terrain.fourmiliere.getPourcentageRole()[1] + "%");
			System.out.println(" | Sexue : " + terrain.fourmiliere.getPourcentageRole()[2] + "%");
			fichierLog(nbJour);
			Thread.sleep(100);
		}
	}

	static void fichierLog(int nbJour) {
		try {
			PrintWriter writer = new PrintWriter("fichierLog.txt", "UTF-8");
			writer.println("Nombre de jour déroulé : " + nbJour);
			writer.println("Nombre d'individu :");
			writer.println("Nombre d'oeuf : ");
			writer.println("Nombre de larve : ");
			writer.println("Nombre de nymphe : ");
			writer.println("Nombre d'adulte  : ");
			writer.println("Nombre d'ouvrière : ");
			writer.println("Nombre de soldat : ");
			writer.println("Nombre de sexué : ");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
