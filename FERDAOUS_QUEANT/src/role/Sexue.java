package role;
// classe Sexue qui h�rite de Role
public class Sexue extends Role {
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5}; // dur�e de vie
		return vita;
	}
}
