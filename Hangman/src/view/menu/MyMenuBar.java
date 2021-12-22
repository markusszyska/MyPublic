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
	private JMenuItem newWordMISpringApiJson;
	private JMenuItem newWordMISpringApiXml;
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
	
	public JMenuItem getNewWordMISpringApiJson() {
		return newWordMISpringApiJson;
	}

	public void setNewWordMISpringApiJson(JMenuItem newWordMISpringApiJson) {
		this.newWordMISpringApiJson = newWordMISpringApiJson;
	}
	
	public JMenuItem getNewWordMISpringApiXml() {
		return newWordMISpringApiXml;
	}

	public void setNewWordMISpringApiXml(JMenuItem newWordMISpringApiXml) {
		this.newWordMISpringApiXml = newWordMISpringApiXml;
	}

	public MyMenuBar() {
		this.setDatei(new JMenu("Datei"));
		this.setNewWordM(new JMenu("Neues Wort erstellen"));
		this.setNewWordMIDb(new JMenuItem("Datei DB"));
		this.setNewWordMIFile(new JMenuItem("Textdatei"));
		this.setNewWordMIWebDb(new JMenuItem("Web Datenbank"));
		this.setNewWordMISpringApiJson(new JMenuItem("Spring API Json"));
		this.setNewWordMISpringApiXml(new JMenuItem("Spring Api Xml"));
		
		this.add(this.getDatei());
		this.getDatei().add(this.getNewWordM());
		this.getNewWordM().add(this.getNewWordMIFile());
		this.getNewWordM().add(this.getNewWordMIDb());
		this.getNewWordM().add(this.getNewWordMIWebDb());
		this.getNewWordM().add(this.getNewWordMISpringApiJson());
		this.getNewWordM().add(this.getNewWordMISpringApiXml());
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

	public void addActionListenerToMenuBarNewWordSpringApiJson(ActionListener al) {
		this.getNewWordMISpringApiJson().addActionListener(al);		
	}

	public void addActionListenerToMenuBarNewWordSpringApiXml(ActionListener al) {
		this.getNewWordMISpringApiXml().addActionListener(al);	
	}
}
