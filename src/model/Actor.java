package model;

public class Actor {
	protected int actor_id;
	protected String actor_name;
	protected String actor_surname;
	
	public Actor(){}
	
	public Actor(String actor_name,String actor_surname) {
		super();
		this.actor_name = actor_name;
		this.actor_surname = actor_surname;
		
	}
	
	public Actor(int actor_id,String actor_name,String actor_surname) {
		super();
		this.actor_id = actor_id;
		this.actor_name = actor_name;
		this.actor_surname = actor_surname;
		
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
	
}
