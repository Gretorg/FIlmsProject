package model;

public class Crew_film {
	protected int film_id;
	protected String film_director;
	protected String film_doph;
	protected String film_composer;
	protected String film_name;
	
	public Crew_film(int film_id, String film_director, String film_doph,String film_composer,String film_name) {
		super();
		this.film_id = film_id;
		this.film_director = film_director;
		this.film_doph = film_doph;
		this.film_composer = film_composer;
		this.film_name=film_name;
	}
	
	public Crew_film( String film_director, String film_doph,String film_composer,String film_name) {
		super();
		this.film_name=film_name;
		this.film_director = film_director;
		this.film_doph = film_doph;
		this.film_composer = film_composer;
		
	}
	
	public int getFilmId() {
		return film_id;
	}
	public void setFilmId(int film_id) {
		this.film_id = film_id;
	}
	
	public String getDirector() {
		return film_director;
	}
	public void setDirector(String film_director) {
		this.film_director = film_director;
	}
	public String getDoph() {
		return film_doph;
	}
	public void setDoph(String film_doph) {
		this.film_doph = film_doph;
	}
	public String getComposer() {
		return film_composer;
	}
	public void setComposer(String film_composer) {
		this.film_composer = film_composer;
	}
	public String getFilmName() {
		return film_name;
	}
	public void setFilmName(String film_name) {
		this.film_name = film_name;
	}
}
