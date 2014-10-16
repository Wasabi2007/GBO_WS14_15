package simpleClasses;

import java.util.ArrayList;

public class Actor {
	
	private ArrayList<Role> roles;
	
	public Actor(){
		roles = new ArrayList<>();
	}
	
	public void action(){
		for (Role role : roles) {
			role.act();
		}
	}
	
	public void addRole(Role role){
		roles.add(role);
	}
	
	public void clearRoles(){
		roles.clear();
	}
}
