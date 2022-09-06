package app;

import java.awt.EventQueue;

import control.MainController;

public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new MainController();
		});
	}
}
