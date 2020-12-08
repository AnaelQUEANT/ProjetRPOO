package sexue;

import role.Sexue;

public class Male extends Sexue{
	@Override
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5};
		return vita;
	}
}
