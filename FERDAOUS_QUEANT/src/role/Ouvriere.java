package role;
// class Ouvriere 
public class Ouvriere extends Role{

	@Override
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5};  // dur�e de vie 
		return vita;
	}

}
