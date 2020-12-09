package role;
// classe Sexue qui hérite de Role
public class Sexue extends Role {
	public double[] getVitalite() {
		double[] vita = {1.5, 2.5}; // durée de vie
		return vita;
	}
}
