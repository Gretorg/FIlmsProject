package model;

public class Film {
	protected int id;
	protected String name;
	protected int year;
	protected String director;
	
	public Film() {
	}
	
	public Film(String name, int year, String director) {
		super();
		this.name = name;
		this.year = year;
		this.director=director;
		
	}

	public Film(int id, String name, int year,String director) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.director = director;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setPrice(int year) {
		this.year =year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
}
