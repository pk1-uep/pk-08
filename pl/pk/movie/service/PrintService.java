package pl.pk.movie.service;

import java.util.List;

import pl.pk.movie.model.Movie;

public class PrintService {
	
	private static void printHeader(String header) {
		System.out.println(header);
		System.out.println(header.replaceAll(".", "="));		
	}
	
	public static void printMovie(Movie one) {
		String title = one.getTitle();
		String director = one.getDirector();
		int year = one.getYear();
		List<String> cast = one.getCast();
		
		System.out.println(title);
		System.out.println(" - reżyseria: " + director);
		System.out.println(" - rok produkcji: " + year);
		System.out.println(" - obsada:");
		for (String oneCast : cast) {
			System.out.println("   " + oneCast);
		}
	}
	
	public static void printMovieList(List<Movie> movieList, String header) {
		printHeader(header);
		for (Movie one : movieList) {
			printMovie(one);
		}
		System.out.println();
	}
	
	public static void printMovieTitles(List<Movie> movieList, String header) {
		printHeader(header);
		for (Movie one : movieList) {
			String title = one.getTitle();
			System.out.println(" - " + title);
		}
		System.out.println();
	}

}
