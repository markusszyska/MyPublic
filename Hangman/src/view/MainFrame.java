package view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import model.Word;
import model.enums.EPersistenceType;
import view.menu.MyMenuBar;
import view.panels.MainPanel;

public class MainFrame extends JFrame {
	private MainPanel mainPanel;
	private MyMenuBar myMenuBar;

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public MyMenuBar getMyMenuBar() {
		return myMenuBar;
	}

	public void setMyMenuBar(MyMenuBar myMenuBar) {
		this.myMenuBar = myMenuBar;
	}

	public MainFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		this.setTitle("Hangman");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(2000, 300, 1024, 768);
		this.setMyMenuBar(new MyMenuBar());
		this.setJMenuBar(this.getMyMenuBar());
		this.setMainPanel(new MainPanel());
		this.getMainPanel().setLayout(null);
		this.setContentPane(this.getMainPanel());
		this.setResizable(false);
		this.setVisible(true);
	}

	public void setActionListenerToStartPanel(ActionListener a) {
		this.getMainPanel().addActionListenerToStartPanel(a);
	}

	public void startGame() {
		this.getMainPanel().startGame();
	}

	public void addActionListenerToLetterButtons(ActionListener al) {
		this.getMainPanel().addActionListenerToLetterButtons(al);
	}

	public void paintHangMan(int count) {
		this.getMainPanel().paintHangMan(count);
	}

	public void displayCreatedWord(Word word) {
		this.getMainPanel().displayCreatedWord(word);
	}

	public void showWin() {
		this.getMainPanel().showWin();
	}

	public void showLoose() {
		this.getMainPanel().showLoose();
	}

	public EPersistenceType selectWordSupplier() {
		return (EPersistenceType) JOptionPane.showInputDialog(this, "Welche Datenquelle soll verwendet werden?",
				"Auswahl Datenquelle", JOptionPane.QUESTION_MESSAGE, null, EPersistenceType.values(),
				EPersistenceType.values()[0]);
	}

	public void showErrorMessageForWord() {
		JOptionPane.showMessageDialog(this, "Maximal 10 Buchstaben", "Wort zu lang!", JOptionPane.ERROR_MESSAGE);
	}

	public void resetLetterButtons() {
		this.getMainPanel().resetLetterButtons();
	}

	public void addActionListenerToPlayAgainButton(ActionListener al) {
		this.getMainPanel().addActionListenerToPlayAgainButton(al);
	}

	public void addActionListenerToBeendenButton(ActionListener al) {
		this.getMainPanel().addActionListenerToBeendenButton(al);

	}

	public void addActionListenerToMenuBarNewWordFile(ActionListener al) {
		this.getMyMenuBar().addActionListenerToMenuBarNewWordFile(al);	
	}

	public void addActionListenerToMenuBarNewWordDB(ActionListener al) {
		this.getMyMenuBar().addActionListenerToMenuBarNewWordDB(al);
		
	}

	public void addActionListenerToMenuBarNewWordWebDB(ActionListener al) {
		this.getMyMenuBar().addActionListenerToMenuBarNewWordWebDB(al);
		
	}
	public void addActionListenerToMenuBarNewWordSpringApi(ActionListener al) {
		this.getMyMenuBar().addActionListenerToMenuBarNewWordSpringApi(al);

	}
	public String getWordFromUser() {
		return JOptionPane.showInputDialog(this,"Bitte Wort eingeben", "Wortauswahl",
				JOptionPane.QUESTION_MESSAGE);
	}

	public int askUserForGUISupplier() {
		return JOptionPane.showConfirmDialog(this, "Wort eingeben?", "Datenquelle GUI?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
	}

	

}
