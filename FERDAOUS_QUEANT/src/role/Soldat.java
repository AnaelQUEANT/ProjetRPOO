package role;

public class Soldat extends Role{
	// class Soldat qui h�rite de Role 
	@Override
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5}; // dur�e de vie 
		return vita;
	}
}
