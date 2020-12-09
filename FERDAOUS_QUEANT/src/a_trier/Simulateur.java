package a_trier;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Simulateur {
	static Terrain terrain;
	static PrintWriter writer;

	public static void main(String args[])
			throws InterruptedException, FileNotFoundException, UnsupportedEncodingException {
		terrain = new Terrain();
		writer = new PrintWriter("fichierLog_FERDAOUS_QUEANT.txt", "UTF-8");
		mainLoop();
		writer.close();
		AffichageGraphique.affichageGraph((int) terrain.fourmiliere.getNombreRole()[0]);
	}

	static void mainLoop() throws InterruptedException {
		int nbJour = 0;
		while (nbJour < 30 || terrain.fourmiliere.getPrefourmi()[2] != 0) {
			terrain.step(nbJour);
			nbJour++;
			fichierLog(nbJour);
			Thread.sleep(100);
		}
		
	}

	static void fichierLog(int nbJour) {
		writer.println("Nombre de jour déroulé : " + nbJour);
		writer.println("Nombre d'individu : " + terrain.fourmiliere.getNombreIndividus());
		writer.println("Nombre d'oeuf : " + terrain.fourmiliere.getPrefourmi()[0]);
		writer.println("Nombre de larve : " + terrain.fourmiliere.getPrefourmi()[1]);
		writer.println("Nombre de nymphe : " + terrain.fourmiliere.getPrefourmi()[2]);
		writer.println("Nombre d'adulte  : " + terrain.fourmiliere.getNombreAdulte());
		writer.println("Nombre d'ouvrière : " + terrain.fourmiliere.getNombreRole()[0]);
		writer.println("Nombre de soldat : " + terrain.fourmiliere.getNombreRole()[1]);
		writer.println("Nombre de sexué : " + terrain.fourmiliere.getNombreRole()[2]);
		writer.println("________________________________________________________________");
	}

}
