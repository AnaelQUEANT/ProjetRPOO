package role;

public class Soldat extends Role{
	// class Soldat qui hérite de Role 
	@Override
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5}; // durée de vie 
		return vita;
	}
}
