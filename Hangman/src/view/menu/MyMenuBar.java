package view.menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar {
	private JMenu datei;
	private JMenu newWordM;
	private JMenuItem newWordMIFile;
	private JMenuItem newWordMIDb;
	private JMenuItem newWordMIWebDb;
	private JMenuItem newWordMISpringApi;
	public JMenu getDatei() {
		return datei;
	}

	public void setDatei(JMenu datei) {
		this.datei = datei;
	}

	public JMenu getNewWordM() {
		return newWordM;
	}

	public void setNewWordM(JMenu newWordM) {
		this.newWordM = newWordM;
	}

	public JMenuItem getNewWordMIFile() {
		return newWordMIFile;
	}

	public void setNewWordMIFile(JMenuItem newWordMIFile) {
		this.newWordMIFile = newWordMIFile;
	}

	public JMenuItem getNewWordMIDb() {
		return newWordMIDb;
	}

	public void setNewWordMIDb(JMenuItem newWordMIDb) {
		this.newWordMIDb = newWordMIDb;
	}

	public JMenuItem getNewWordMIWebDb() {
		return newWordMIWebDb;
	}

	public void setNewWordMIWebDb(JMenuItem newWordMIWebDb) {
		this.newWordMIWebDb = newWordMIWebDb;
	}
	
	public JMenuItem getNewWordMISpringApi() {
		return newWordMISpringApi;
	}

	public void setNewWordMISpringApi(JMenuItem newWordMISpringApi) {
		this.newWordMISpringApi = newWordMISpringApi;
	}

	public MyMenuBar() {
		this.setDatei(new JMenu("Datei"));
		this.setNewWordM(new JMenu("Neues Wort erstellen"));
		this.setNewWordMIDb(new JMenuItem("Datei DB"));
		this.setNewWordMIFile(new JMenuItem("Textdatei"));
		this.setNewWordMIWebDb(new JMenuItem("Web Datenbank"));
		this.setNewWordMISpringApi(new JMenuItem("Spring API"));
		
		this.add(this.getDatei());
		this.getDatei().add(this.getNewWordM());
		this.getNewWordM().add(this.getNewWordMIFile());
		this.getNewWordM().add(this.getNewWordMIDb());
		this.getNewWordM().add(this.getNewWordMIWebDb());
		this.getNewWordM().add(this.getNewWordMISpringApi());
	}

	public void addActionListenerToMenuBarNewWordFile(ActionListener al) {
		this.getNewWordMIFile().addActionListener(al);
	}

	public void addActionListenerToMenuBarNewWordDB(ActionListener al) {
		this.getNewWordMIDb().addActionListener(al);	
	}

	public void addActionListenerToMenuBarNewWordWebDB(ActionListener al) {
		this.getNewWordMIWebDb().addActionListener(al);		
	}

	public void addActionListenerToMenuBarNewWordSpringApi(ActionListener al) {
		this.getNewWordMISpringApi().addActionListener(al);		
	}
}
