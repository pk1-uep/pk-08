package pl.pk.movie.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.pk.movie.model.Movie;

public class MovieService {
	
	private List<Movie> movies;
	
	public static final String TITLE = "tytuł";
	public static final String DIRECTOR = "reżyser";
	public static final String YEAR = "rok";
	public static final String ACTOR = "aktor";
	public static final String ACTRESS = "aktorka";
	
	
	/* ---------- constructor --------- */
	public MovieService(String file) throws IOException {
		this.movies = DataService.readData(file);
	}
	
	
	/* ---------- business methods ---------- */

	/**
	 * Wyświetla listę filmów spełniających podane kryterium wyszukiwania
	 *
	 * @param phrase szukana fraza
	 * @param attribute atrybut filmu zawierajacy szukaną frazę; możliwe wartości: "tytuł", "reżyser", "rok", "aktor", "aktorka"
	 * @param fullInfo czy drukować pełną informację o znalezionych filmach
	 */
	public void findMovies(String phrase, String attribute, boolean fullInfo) {
		String header = "Wynik wyszukiwania dla: " + attribute + " = " + phrase;
		List<Movie> movieList = findMovies(phrase, attribute);

		if (fullInfo)
			PrintService.printMovieList(movieList, header);
		else
			PrintService.printMovieTitles(movieList, header);
	}


	private List<Movie> findMovies(String phrase, String attribute) {
		phrase = phrase.toLowerCase();
		List<Movie> list = new ArrayList<>();
		
		for (Movie one : movies) {
			String value = null;
			
			switch (attribute) {
				case TITLE:
					value = one.getTitle();
					break;
				case DIRECTOR:
					value = one.getDirector();
					break;
				case YEAR:
					value = Integer.toString(one.getYear());
					break;
				case ACTOR:
				case ACTRESS:
					List<String> cast = one.getCast();
					for (String member : cast) {
						value = value + member + ";";
					}
					break;
				default:
					value = "";
					break;
			}
			
			value = value.toLowerCase();
			if (value.contains(phrase)) {
				list.add(one);
			}
		}
		
		return list;
	}

}
