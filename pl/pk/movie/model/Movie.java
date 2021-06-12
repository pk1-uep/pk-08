package pl.pk.movie.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	
	private int id;
	private String title;
	private int year;
	private String director;
	private List<String> cast = new ArrayList<>();
	
	
	/* constructor */
	public Movie() {		
	}
	
	
	/* business methods */
	public void addCastMember(String castMember) {
		cast.add(castMember);
	}
	
	
	/* getters & setters */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public List<String> getCast() {
		return cast;
	}
	public void setCast(List<String> cast) {
		this.cast = cast;
	}

}
