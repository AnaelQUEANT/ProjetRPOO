package sexue;

import role.Sexue;

// class Femelle
public class Femelle extends Sexue {
	@Override
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5}; // dur�e de vie
		return vita;
	}
}
