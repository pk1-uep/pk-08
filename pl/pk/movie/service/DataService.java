package pl.pk.movie.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import pl.pk.movie.model.Movie;

public class DataService {
	
	public static List<Movie> readData(String filePath) throws IOException {
		List<String> lines = getLines(filePath, true);
		
		List<Movie> data = new ArrayList<>();
		
		for (String oneLine : lines) {
			if (oneLine.trim().equals("")) {
				continue;
			}
			
			String[] parts = oneLine.split(";");
			if (parts.length != 5) {
				continue;
			}

			Movie movie = new Movie();
			
			// id
			Integer id = doInt(parts[0]);
			movie.setId(id);
			
			// title
			String title = doString(parts[1]);
			movie.setTitle(title);
			
			// year
			Integer year = doInt(parts[2]);
			movie.setYear(year);
			
			// director
			String director = doString(parts[3]);
			movie.setDirector(director);
			
			// cast
			String cast = doString(parts[4]);
			String[] castMembers = cast.split(",");
			for (String member : castMembers) {
				member = doString(member);
				movie.addCastMember(member);
			}
			
			// add movie to data
			data.add(movie);
		}

		return data;
	}

	protected static String doString(String text) {
		text = text.trim();
		return text;
	}

	private static Integer doInt(String text) {
		text = text.trim();
		Integer value = Integer.parseInt(text);
		return value;
	}

	private static List<String> getLines(String filePath, boolean removeHeader) throws IOException {
		Path path = Paths.get(filePath);
		List<String> lines = Files.readAllLines(path);
		if (removeHeader) {
			lines.remove(0);     // remove the header line
		}

		return lines;
	}

}
