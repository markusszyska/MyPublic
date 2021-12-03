package model.persistence;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WordPersistenceWebDB implements IWordPersistence {

	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

	@Override
	public void addWord(String word) {
		String json = new StringBuilder().append("{").append("\"word\":\"" + word + "\"")
				.append("}").toString();
		HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create("http://localhost/php_rest_api/api/post/post.php")).build();
		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getWord() {
		String word = "";
		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("http://localhost/php_rest_api/api/post/read.php?req=getWord")).build();
		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			String json = response.body();
			System.out.println(json);
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map;
			try {
				map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
				});
				Object wordMap = map.get("data");
				List<String> words = (List<String>) wordMap;
				word = words.get(new Random().nextInt(words.size()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return word;
	}
}
