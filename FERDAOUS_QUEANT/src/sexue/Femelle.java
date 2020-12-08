package sexue;

import role.Sexue;

public class Femelle extends Sexue{
	@Override
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5};
		return vita;
	}
}
