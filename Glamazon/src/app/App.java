package app;

import java.awt.EventQueue;

import controller.MainController;

public class App {

	/*
	 * Kommentar A Kommentar B Kommentar DE
	 */

	// Kommentar C
	public static void main(String[] args) {

//		FileHandler fh = new FileHandler();
//
//		String json = fh.readAsString("./DB/artikel-liste.json");
//		System.out.println(json);
//
//		// GSON
//		Artikel artikel = new Gson().fromJson(json, Artikel.class);
//		System.out.println(artikel);

//		DataLoader dl = DataLoader.getInstance();
//		DataLoader dl2 = DataLoader.getInstance();
//		System.out.println(dl == dl2);

//
//		Sortiment sortiment = dl.getArtikelFromDataBase();
//
//		// Enhanced For-Loop
//		for(Artikel artikel : sortiment.getAlleArtikel()) {
//			System.out.println(artikel);
//		}

//		for(int i = 0; i < artikel_liste.size(); i++) {
//			System.out.println(artikel_liste.get(i));
//		}

		EventQueue.invokeLater(()->new MainController());

	}
}
