package model;

public class Role {
	protected int id;
	protected int actor_id;
	protected String role;
	
	public Role() {
	}
	
	public Role(int id,String role) {
		super();
		this.id=id;
		this.role=role;
		
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActorId() {
		return actor_id;
	}
	public void setActorId(int actor_id) {
		this.actor_id = actor_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
