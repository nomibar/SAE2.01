package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Donnees {
	static private ObservableList<Spectacle> 		lesSpectacles 	= FXCollections.observableArrayList();

	static public void chargementDonnees() {
		lesSpectacles.add(new Spectacle(01,01,"le spectacle qui tue",6400.00f,"02/09/2005","20h30"));
		lesSpectacles.add(new Spectacle(02,02,"le spectacle qui tue",6400.00f,"02/09/2005","20h30"));
	}

	// Méthodes de consultation : elles fournissent des listes de données
	static public ObservableList<Spectacle> getLesSpectacles() {
		return lesSpectacles;
	}

	// Méthodes de mise à jour
	static public void ajouterSpectacle(Spectacle e) {
		lesSpectacles.add(e);
	}
	
	static public void supprimerSpectacle(Spectacle e) {
		boolean trouve = false;
		int i=0;
		while (!trouve && i<lesSpectacles.size()) {
			if (lesSpectacles.get(i).getIdSpectacle()==e.getIdSpectacle()){
				lesSpectacles.remove(i);
				trouve = true;
			}
			i++;
		}
	}
	
	static public void modifierSpectacle(Spectacle e) {
		boolean trouve = false;
		int i=0;
		
		while (!trouve && i<lesSpectacles.size()) {
			if (lesSpectacles.get(i).getIdSpectacle()==e.getIdSpectacle()){
				lesSpectacles.set(i, e);
				trouve = true;
			}
			i++;
		}
	}
}
