package model;

import model.enums.EPersistenceType;
import model.persistence.IWordPersistence;
import model.persistence.WordPersistenceDB;
import model.persistence.WordPersistenceFile;
import model.persistence.WordPersistenceSpringApiJson;
import model.persistence.WordPersistenceSpringApiXml;
import model.persistence.WordPersistenceWebDB;

public class MainModel {

	private Word theWord;
	private IWordPersistence wordPersistence;

	public Word getTheWord() {
		return theWord;
	}

	public void setTheWord(Word theWord) {
		this.theWord = theWord;
	}

	public IWordPersistence getWordPersistence() {
		return wordPersistence;
	}

	public void setWordPersistence(IWordPersistence wordPersistence) {
		this.wordPersistence = wordPersistence;
	}

	public Word createWordFromPersistence() {
		String word = this.getWordPersistence().getWord();
		this.setTheWord(new Word(word.toUpperCase().toCharArray()));
		return this.getTheWord();
	}

	public Word getWordFromString(String word) {
		this.setTheWord(new Word(word.toUpperCase().toCharArray()));
		return this.getTheWord();
	}

	public Word checkLetter(char letter) {
		int hits = 0;
		for (int i = 0; i < this.getTheWord().getWord().length; i++) {
			if (this.getTheWord().getWord()[i] == letter) {
				this.getTheWord().getGuessedLetters()[i] = true;
				hits++;
			}
		}
		if (hits == 0)
			this.getTheWord().setHangManCount(this.getTheWord().getHangManCount() + 1);
		return this.getTheWord();
	}

	public void initializeWordSupplier(EPersistenceType supplier) {
		// Initialize Wordsupplier
		switch (supplier) {
		case DB:
			this.setWordPersistence(new WordPersistenceDB());
			break;
		case FILE:
			this.setWordPersistence(new WordPersistenceFile());
			break;
		case WEBDB:
			this.setWordPersistence(new WordPersistenceWebDB());
			break;
		case SPRINGAPIJSON:
			this.setWordPersistence(new WordPersistenceSpringApiJson());
			break;
		case SPRINGAPIXML:
			this.setWordPersistence(new WordPersistenceSpringApiXml());
			break;
		}
	}

	public void addWordToPersistence(EPersistenceType type, String word) {
		switch (type) {
		case DB:
			this.setWordPersistence(new WordPersistenceDB());
			break;
		case FILE:
			this.setWordPersistence(new WordPersistenceFile());
			break;
		case WEBDB:
			this.setWordPersistence(new WordPersistenceWebDB());
			break;
		case SPRINGAPIJSON:
			this.setWordPersistence(new WordPersistenceSpringApiJson());
			break;
		case SPRINGAPIXML:
			this.setWordPersistence(new WordPersistenceSpringApiXml());
			break;
		}
		this.getWordPersistence().addWord(word);
	}

}
