package controleur;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Donnees;
import modele.Spectacle;
import vue.FenAnnulation;
import vue.FenListeSpectacle;
import vue.FenModifierSpectacle;
import vue.FenNouveauSpectacle;

public class Main extends Application {
	static private FenListeSpectacle fListe;
	static private FenNouveauSpectacle fNouvel;
	static private FenModifierSpectacle fModifier;
	static private FenAnnulation fAnnulation;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Donnees.chargementDonnees();
		
		fListe = new FenListeSpectacle();
		fNouvel = new FenNouveauSpectacle();
		fModifier = new FenModifierSpectacle();
		fAnnulation = new FenAnnulation();
		fNouvel.initModality(Modality.APPLICATION_MODAL);
		fModifier.initModality(Modality.APPLICATION_MODAL);
		fListe.show();
	}
	
	//////////////////////////////////////////////////////////
	// 				 Gestion des fenetres                   //
	//////////////////////////////////////////////////////////
	
	static public void ouvrirNouveauSpectacle() {
		fNouvel.effacer();
		fNouvel.show();
	}
	
	static public void ouvrirModifierSpectacle(Spectacle e) {
		fModifier.afficherSpectacle(e);
		fModifier.show();
	}
	
	static public void fermerNouveauSpectacle() {
		fNouvel.close();
	}
	
	static public void fermerModifierSpectacle() {
		fModifier.close();
	}
	
	static public void fermerAppli() {
		System.exit(0);
	}
	
	//////////////////////////////////////////////////////////
	//			    Mise a jour des donnees	    			//
	//////////////////////////////////////////////////////////
	
	static public void supprimerSpectacle(Spectacle e) {
		Donnees.supprimerSpectacle(e);
	}
	
	static public void validerNouveauSpectacle(int idA, int idR, String nomS, Float tari, int annee, int mois, int jour, String fin) {
		String date = jour+"/"+mois+"/"+annee;
		Spectacle spe = new Spectacle(idA, idR, nomS, tari, date, fin);
		Donnees.ajouterSpectacle(spe);
		fNouvel.close();
	}

	static public void validerModifierSpectacle(int idS,int idA, int idR, String nomS,Float tari,int jour, int mois, int annee ,String fin) {
		String date = jour+"/"+mois+"/"+annee;
		Spectacle emp=new Spectacle(idS,idA,idR,nomS,tari,date,fin);
		Donnees.modifierSpectacle(emp);
		fModifier.close();
	}

	static public void modifierSpectacle(Spectacle e) {	
		Donnees.modifierSpectacle(e);
		fModifier.close();
	}
	
	static public void ouvrirAnnulation() {
		fAnnulation.show();
	}
	
	static public void fermerAnnulation() {	
		fAnnulation.close();
	}
	
    static public void ajouterListe(Spectacle spectacle) {
    	fAnnulation.ajouterListe(spectacle);
    }
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}