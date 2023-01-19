package service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class IMDB {

	public static void main(String[] args) throws Exception, Exception {
		
		// create a client
		HttpClient client = HttpClient.newHttpClient();

		// create a request
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("https://imdb-api.com/en/API/Top250Movies/k_9nsm9w85/"))
				.GET()
				.build();
		// use the client to send the request
//		HttpResponse<String> response =
//				client.send(request, BodyHandlers.ofString());
//		
//		System.out.println(response.statusCode());
//		System.out.println(response.body());
//		
		//async
		 client.sendAsync(request, BodyHandlers.ofString())
         .thenApply(HttpResponse::body)
         .thenAccept(System.out::println)
         .join(); 

	}
}
