package sexue;

public class Reine extends Femelle {
	// Classe reine
	@Override
	public double[] getVitalite() {
		double[] vita = {4, 10}; // Durée de vie
		return vita;
	}
}
