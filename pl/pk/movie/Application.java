package pl.pk.movie;

import pl.pk.movie.service.MovieService;

import java.io.IOException;

public class Application {
	
	public static void main(String[] args) {
		String file = "movies.txt";
		MovieService ms = null;
		try {
			ms = new MovieService(file);
		}
		catch (IOException ex) {
			System.out.println("Błąd: nie można odczytać danych z pliku!");
			return;
		}

		ms.findMovies("street", MovieService.TITLE, false);
		ms.findMovies("Douglas", MovieService.ACTOR, true);
		ms.findMovies("Tarantino", MovieService.DIRECTOR, true);
		ms.findMovies("1999", MovieService.YEAR, false);
	}

}
