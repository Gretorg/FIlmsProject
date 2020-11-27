package model;

public class Actor_Film {
	protected int id;
	protected int actor_id;
	protected String actor_name;
	protected String actor_surname;
	protected String role;
	
	public Actor_Film(int actor_id, String actor_name,String actor_surname,String role) {
		super();
		this.actor_id=actor_id;
		this.actor_name=actor_name;
		this.actor_surname=actor_surname;
		this.role=role;
	}
	
	public Actor_Film(int id,int actor_id, String actor_name,String actor_surname,String role) {
		super();
		this.id=id;
		this.actor_id=actor_id;
		this.actor_name=actor_name;
		this.actor_surname=actor_surname;
		this.role=role;
	}
	
	public int getActorId() {
		return actor_id;
	}
	public void setActorId(int actor_id) {
		this.actor_id=actor_id;
	}
	
	public String getActorName() {
		return actor_name;
	}
	public void setActorName(String actor_name) {
		this.actor_name=actor_name;
	}
	
	public String getActorSurname() {
		return actor_surname;
	}
	public void setActorSurname(String actor_surname) {
		this.actor_surname=actor_surname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
