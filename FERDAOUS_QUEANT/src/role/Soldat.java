package role;

public class Soldat extends Role{
	@Override
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5};
		return vita;
	}
}
