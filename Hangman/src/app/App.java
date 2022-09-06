package app;

import java.awt.EventQueue;

import javax.swing.SwingUtilities;

import control.MainController;

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->new MainController());		
	}
}
