package sexue;

import role.Sexue;
// class Male 

public class Male extends Sexue {
	@Override
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5}; // dur�e de vie
		return vita;
	}
}
