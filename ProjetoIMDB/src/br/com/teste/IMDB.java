package br.com.teste;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.teste.entity.Filme;

public class IMDB {

	public static void main(String[] args) throws Exception, Exception {
		
		String apiKey = "k_9nsm9w85";
		ArrayList<Filme> arrayFilme = new ArrayList<>(); 
		
		// create a client
		HttpClient client = HttpClient.newHttpClient();
		
		// create a request
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
				.GET()
				.build();
		// use the client to send the request
		HttpResponse<String> response =
				client.send(request, BodyHandlers.ofString());
		
//		System.out.println(response.statusCode());
//		System.out.println(response.body());
		String json = response.body();
		String[] moviesArray = parseJsonMovies(json, arrayFilme);
		System.out.println(arrayFilme);

//		List<String> titles = parseTitles(moviesArray);
//		titles.forEach(System.out::println);
//
//		List<String> urlImages = parseUrlImages(moviesArray);
//		urlImages.forEach(System.out::println);
//		
		//async
//		 client.sendAsync(request, BodyHandlers.ofString())
//         .thenApply(HttpResponse::body)
//         .thenAccept(System.out::println)
//         .join(); 

	}

	private static String[] parseJsonMovies(String json, ArrayList<Filme> arrayFilme) {
		Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("no match in " + json);
		}
		
		String[] moviesArray = matcher.group(1).split("\\},\\{");
		
		moviesArray[0] = moviesArray[0].substring(1);
		int last = moviesArray.length - 1;
		String lastString = moviesArray[last];
		moviesArray[last] = lastString.substring(0, lastString.length() - 1);
		
		for(int i = 0; i < moviesArray.length; i++) {
			
			String titulo = moviesArray[i].split("\",\"")[3].split(":\"")[1];
			String urlPoster = moviesArray[i].split("\",\"")[5].split(":\"")[1];
			String nota = moviesArray[i].split("\",\"")[7].split(":\"")[1];
			String ano = moviesArray[i].split("\",\"")[4].split(":\"")[1];
			
			Filme filme = new Filme(titulo,urlPoster,nota,ano);
			arrayFilme.add(filme);
		}
		
		return moviesArray;
	}
}
