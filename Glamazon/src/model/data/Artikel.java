package model.data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.swing.ImageIcon;

public class Artikel {
	private int artikelId;
	private String artName;
	private String artBeschreibung;
	private double preis;
	private ImageIcon icon;
	private Set<String> kategorien;
	private int mwst;

	public int getArtikelId() {
		return artikelId;
	}

	public void setArtikelId(int artikelId) {
		this.artikelId = artikelId;
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getArtBeschreibung() {
		return artBeschreibung;
	}

	public void setArtBeschreibung(String artBeschreibung) {
		this.artBeschreibung = artBeschreibung;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public Set<String> getKategorien() {
		return kategorien;
	}

	public void setKategorien(Set<String> kategorien) {
		this.kategorien = kategorien;
	}

	public int getMwst() {
		return mwst;
	}

	public void setMwst(int mwst) {
		this.mwst = mwst;
	}

	public Artikel(int id, String name, String beschreibung, double preis, ImageIcon icon, Set<String> kategorien,
			int mwst) {
		this.setArtikelId(id);
		this.setArtName(name);
		this.setArtBeschreibung(beschreibung);
		this.setPreis(preis);
		this.setIcon(icon);
		this.setKategorien(kategorien);
		this.setMwst(mwst);
	}

	public Artikel(int id, String name, String beschreibung, double preis, int mwst) {
		this(id, name, beschreibung, preis, new ImageIcon(), new HashSet<String>(), mwst);
	}

	public Artikel(String name) {
		this(-1, name, "", 0.0, 0);
	}

	public Artikel() {
		this("");
	}

	@Override
	public String toString() {
		return "Artikel [getArtikelId()=" + getArtikelId() + ", getArtName()=" + getArtName()
				+ ", getArtBeschreibung()=" + getArtBeschreibung() + ", getPreis()=" + getPreis() + ", getBild()="
				+ getIcon() + ", getKategorien()=" + getKategorien() + ", getMwst()=" + getMwst() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikel artikel = (Artikel) obj;
		return this.getArtikelId() == artikel.getArtikelId() && this.getArtName().equals(artikel.getArtName())
				&& this.getArtBeschreibung().equals(artikel.getArtBeschreibung())
				&& this.getMwst() == artikel.getMwst();
	}

	@Override
	public int hashCode() {
		return Objects.hash(artBeschreibung, artName, artikelId, icon, kategorien, mwst, preis);
	}


	@Override
	public Artikel clone() {
		return new Artikel(this.getArtikelId(), this.getArtName(), this.getArtBeschreibung(), this.getPreis(),
				this.getIcon(), this.getKategorien(), this.getMwst());
	}


}
