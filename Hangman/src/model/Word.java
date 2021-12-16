package model;

public class Word {
	private char[] word;
	private boolean[] guessedLetters;
	private int hangManCount;
	public char[] getWord() {
		return word;
	}

	public void setWord(char[] word) {
		this.word = word;
	}
	
	public boolean[] getGuessedLetters() {
		return guessedLetters;
	}

	public void setGuessedLetters(boolean[] guessedLetters) {
		this.guessedLetters = guessedLetters;
	}
	
	public int getHangManCount() {
		return hangManCount;
	}

	public void setHangManCount(int hangManCount) {
		this.hangManCount = hangManCount;
	}

	public Word(char[] chars) {
		this.setWord(chars);
		this.setGuessedLetters(new boolean[chars.length]);
	}
	@Override
	public String toString() {
		String s = "";
		for (char c : this.getWord()) {
			s+=c;
		}
		return s;
	}
}
