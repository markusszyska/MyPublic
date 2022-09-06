package model.crud;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.data.Artikel;
import model.data.Sortiment;

public class DataLoader {

	private static DataLoader instance;
	private ArrayList<IDBConnection> connections;

	public static DataLoader getInstance() {
		if(instance == null)
			instance = new DataLoader();
		return DataLoader.instance;
	}


	private ArrayList<IDBConnection> getConnections() {
		return connections;
	}

	private void setConnections(ArrayList<IDBConnection> connections) {
		this.connections = connections;
	}

	private DataLoader() {
		this.setConnections(new ArrayList<IDBConnection>());
		this.getConnections().add(new SQLiteConnection());
		this.getConnections().add(new FileHandler());
	}

	public Sortiment getArtikelFromDataBase() {
		Sortiment sortiment = new Sortiment();
		Set<Artikel> artikelliste = new HashSet<>();
		this.getConnections().forEach(con->artikelliste.addAll(con.getAllArtikel()));
		sortiment.setAlleArtikel(artikelliste);
		return sortiment;
	}
}
