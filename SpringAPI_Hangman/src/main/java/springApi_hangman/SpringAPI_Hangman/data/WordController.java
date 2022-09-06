package springApi_hangman.SpringAPI_Hangman.data;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/word")
public class WordController {
	
	@Autowired
	WordRepository wordRepository;
	
	@PostMapping(path = "", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void createWord(@RequestBody Word word) {
		System.out.println(word.getWord());
		try {
			wordRepository.save(word);			
		}catch(Exception e) {
			System.out.println("Keine doppelten Einträge");
		}
	}
	
	@GetMapping(path ="/{wordId}" , produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Word getWordJson(@PathVariable Integer wordId) {
		Optional<Word> word = wordRepository.findById(wordId);
		if(word.isPresent()) {
			return word.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wort mit dieser ID wurde nicht gefunden");
	}
		
	@GetMapping(path = "/getAll")
	public Iterable<Word> getListOfWords() {
		Iterable<Word> iter = wordRepository.findAll();		
		return iter;
	}
}
