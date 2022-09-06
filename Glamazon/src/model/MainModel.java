package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import model.crud.DataLoader;
import model.data.Artikel;
import model.data.Sortiment;
import model.data.Warenkorb;

public class MainModel {

	private Sortiment sortiment;
	private Warenkorb warenkorb;

	public Sortiment getSortiment() {
		return sortiment;
	}

	public void setSortiment(Sortiment sortiment) {
		this.sortiment = sortiment;
	}

	public Warenkorb getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(Warenkorb warenkorb) {
		this.warenkorb = warenkorb;
	}

	public MainModel() {
		this.setSortiment(DataLoader.getInstance().getArtikelFromDataBase());
		this.setWarenkorb(new Warenkorb());
	}

	public Set<Artikel> filterSortimentKategorie(String kategorie) {
		Set<Artikel> alleArtikel = new HashSet<>(this.getSortiment().getAlleArtikel());
		alleArtikel.removeIf(artikel -> !artikel.getKategorien().contains(kategorie));
		return alleArtikel;
	}

	public Set<String> getAlleKategorien() {
		Set<String> kat = new HashSet<>();
		this.getSortiment().getAlleArtikel().forEach(artikel -> kat.addAll(artikel.getKategorien()));
		return kat;
	}

	public Set<Artikel> getAlleArtikel() {
		return this.getSortiment().getAlleArtikel();
	}

	public void addItemToCart(String productName, Integer anzahl) {
		Optional<Artikel> opt = this.getSortiment().getAlleArtikel().stream().filter(a->a.getArtName().equals(productName)).findFirst();
		if(opt.isPresent()&&anzahl>0)
			this.getWarenkorb().fuegeArtikelEin(opt.get(), anzahl);
	}
}
