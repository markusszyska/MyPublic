package app;

import javax.swing.SwingUtilities;

import controller.MainController;

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->new MainController());	
	}
}
