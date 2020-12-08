package etat;

import role.Role;

public class Adulte extends Etat {
	private Role leRole;
	public Adulte() {
		super();
	}
	
	@Override
	public Etat next() {
		/*
		if((val) > leRole.getVitalite()[0]) {
			return new Mort();
		}
		*/
		val++;
		return this;
	}
	
	public void setRole(Role newRole) {
		leRole = newRole;
	}
	
	public Role getRole(){
		return leRole;
	}
	
}
