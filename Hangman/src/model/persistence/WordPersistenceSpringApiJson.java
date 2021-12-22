package model.persistence;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class WordPersistenceSpringApiJson implements IWordPersistence {
	
	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
	
	@Override
	public void addWord(String word) {
		String json = new StringBuilder().append("{").append("\"word\":\"" + word + "\"")
				.append("}").toString();
		HttpRequest request = HttpRequest.newBuilder()
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create("http://localhost:8080/word")).build();
		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getWord() {
		String word = "";
		HttpRequest request = HttpRequest.newBuilder()
				.header("Accept", "application/json")
				.GET()
				.uri(URI.create("http://localhost:8080/word/getAll")).build();
		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			String json = response.body();		
			ObjectMapper objectMapper = new ObjectMapper();
			CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, LinkedHashMap.class);
			List<LinkedHashMap<Object,Object>> asList = objectMapper.readValue(json, listType);
			LinkedHashMap<Object,Object> randomWord = asList.get(new Random().nextInt(0, asList.size()));
			word = (String)randomWord.get("word");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return word;
	}
}
