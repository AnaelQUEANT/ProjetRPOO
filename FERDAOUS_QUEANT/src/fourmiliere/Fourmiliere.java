package fourmiliere;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Fourmiliere {
	public List<Fourmi> fourmis;
	
	public Fourmiliere() {
		fourmis = new ArrayList<Fourmi>();
	}
	
	public void step() {
		Iterator<Fourmi> iter = fourmis.iterator();
		while(iter.hasNext()) {
			iter.next().step();
		}
	}
}
