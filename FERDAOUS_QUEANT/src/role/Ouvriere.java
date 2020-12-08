package role;

public class Ouvriere extends Role{

	@Override
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5};
		return vita;
	}

}
