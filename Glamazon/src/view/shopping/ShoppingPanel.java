package view.shopping;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.data.Artikel;

public class ShoppingPanel extends JPanel {

	private List<ArtikelPanel> artikelList;
	private JPanel displayPanel;

	public List<ArtikelPanel> getArtikelList() {
		return artikelList;
	}

	public void setArtikelList(List<ArtikelPanel> artikelList) {
		this.artikelList = artikelList;
	}

	public JPanel getDisplayPanel() {
		return displayPanel;
	}

	public void setDisplayPanel(JPanel displayPanel) {
		this.displayPanel = displayPanel;
	}

	public ShoppingPanel() {
		this.setLayout(null);
		this.setBounds(0, 0, 1024, 768);
		this.setBackground(Color.LIGHT_GRAY);
		this.setOpaque(true);

		this.setDisplayPanel(new JPanel());
		/**
		 * @toDo
		 * GridLayout mit der Laenge der Liste initialisieren
		 */
		this.getDisplayPanel().setLayout(new GridLayout(20,1));

		JScrollPane sPane = new JScrollPane();
		sPane.setBounds(0, 0, 1008, 618);
		sPane.setViewportView(this.getDisplayPanel());
		this.add(sPane);
		sPane.getVerticalScrollBar().setUnitIncrement(16);
		this.setArtikelList(new ArrayList<>());

		for (int i = 0; i < 3; i++) {
			this.getDisplayPanel().add(new ArtikelPanel());
		}

	}

	public void displayArtikel(Set<Artikel> artikel) {
		this.getArtikelList().clear();
		artikel.forEach(item->{this.getArtikelList().add(new ArtikelPanel(item.getIcon(), item.getArtName(), item.getArtBeschreibung(), item.getPreis()));});
		this.getDisplayPanel().removeAll();
		this.getDisplayPanel().setLayout(new GridLayout(this.getArtikelList().size(), 1));
		this.getArtikelList().forEach(item->this.getDisplayPanel().add(item));
		this.revalidate();
		this.repaint();
		
	}

	public void addActionListenerToArtikelPanel(ActionListener al) {
		this.getArtikelList().forEach(item-> item.getBtnWarenkorb().addActionListener(al));
	}

}
