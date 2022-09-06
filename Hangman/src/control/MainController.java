package control;

import static model.enums.EPersistenceType.*;

import java.awt.event.ActionEvent;
import java.util.stream.Stream;

import javax.swing.JButton;

import model.MainModel;
import model.Word;
import model.enums.EPersistenceType;
import view.MainFrame;

public class MainController {
	private MainFrame frame;
	private MainModel model;
	private EPersistenceType persistenceType;

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public MainModel getModel() {
		return model;
	}

	public void setModel(MainModel model) {
		this.model = model;
	}

	public EPersistenceType getPersistenceType() {
		return persistenceType;
	}

	public void setPersistenceType(EPersistenceType persistenceType) {
		this.persistenceType = persistenceType;
	}

	public MainController() {
		this.setFrame(new MainFrame());
		this.setModel(new MainModel());
		this.getFrame().setActionListenerToStartPanel(this::startPressed);
		this.getFrame().addActionListenerToLetterButtons(this::letterPressed);
		this.getFrame().addActionListenerToPlayAgainButton(this::playAgain);
		this.getFrame().addActionListenerToBeendenButton(this::endGame);
		this.getFrame().addActionListenerToMenuBarNewWordFile(this::addWordTextFilePressed);
		this.getFrame().addActionListenerToMenuBarNewWordDB(this::addWordDBPressed);
		this.getFrame().addActionListenerToMenuBarNewWordWebDB(this::addWordWebDBPressed);
		this.getFrame().addActionListenerToMenuBarNewWordSpringApiJson(this::addWordSpringApiJsonPressed);
		this.getFrame().addActionListenerToMenuBarNewWordSpringApiXml(this::addWordSpringApiXmlPressed);
		if (this.getFrame().askUserForGUISupplier() != 0) {
			EPersistenceType persistenceType = this.getFrame().selectWordSupplier();
			this.setPersistenceType(persistenceType);
			this.getModel().initializeWordSupplier(persistenceType);
		}		
	}

	private void startGame() {
		if (this.getPersistenceType() != null)
			this.getFrame().displayCreatedWord(this.getModel().createWordFromPersistence());
		else
			this.getFrame().displayCreatedWord(this.getModel().getWordFromString(this.getFrame().getWordFromUser()));
		this.getFrame().startGame();
	}

	/**
	 * 
	 * @toDo Sonderzeichen checken
	 */
	private boolean checkString(String s) {
		boolean ok = s.length() < 11;
		return ok;
	}

	private void playAgain(ActionEvent e) {
		this.getFrame().resetLetterButtons();
		this.startGame();
	}

	private void endGame(ActionEvent e) {
		System.exit(0);
	}

	private void startPressed(ActionEvent e) {
		this.startGame();
	}

	private void letterPressed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setEnabled(false);
		Word word = this.getModel().checkLetter(btn.getText().charAt(0));
		this.getFrame().displayCreatedWord(word);
		boolean win = true;
		for (int i = 0; i < word.getGuessedLetters().length; i++) {
			if (word.getGuessedLetters()[i] == false) {
				win = false;
			}
		}
		if (win) {
			this.getFrame().showWin();
		} else if (word.getHangManCount() == 10) {
			this.getFrame().showLoose();
		}
	}

	private void addWordTextFilePressed(ActionEvent e) {
		String word = this.getFrame().getWordFromUser();
		this.getModel().addWordToPersistence(FILE, word);
	}

	private void addWordDBPressed(ActionEvent e) {
		String word = this.getFrame().getWordFromUser();
		this.getModel().addWordToPersistence(DB, word);
	}

	private void addWordWebDBPressed(ActionEvent e) {
		String word = this.getFrame().getWordFromUser();
		this.getModel().addWordToPersistence(WEBDB, word);
	}
	private void addWordSpringApiJsonPressed(ActionEvent e) {
		String word = this.getFrame().getWordFromUser();
		this.getModel().addWordToPersistence(SPRINGAPIJSON, word);
	}
	private void addWordSpringApiXmlPressed(ActionEvent e) {
		String word = this.getFrame().getWordFromUser();
		this.getModel().addWordToPersistence(SPRINGAPIXML, word);
	}
}
