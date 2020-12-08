package a_trier;

import etat.Mort;
import fourmiliere.Fourmi;

public class Simulateur {
	static Terrain terrain;
	
	public static void main(String args[]) throws InterruptedException {
		terrain = new Terrain();
		mainLoop();
	}
	
	static void mainLoop() throws InterruptedException {
		int i = 0;
		while(true) {
			terrain.fourmiliere.fourmis.add(new Fourmi());
			terrain.step();
			i++;
			System.out.println("Nombre de fourmi au jour "+i +" : " + nombreFourmiVie());
			Thread.sleep(100);
		}
	}
	
	static int nombreFourmiVie() {
		int i = 0;
		for(Fourmi laFourmi: terrain.fourmiliere.fourmis) {
			if(!Mort.class.isInstance(laFourmi.etat)) {
				i++;
			}
		}
		return i;
	}
}
