package modele;

import javafx.beans.property.*;

public class Spectacle {
	private final IntegerProperty idSpectacle;
	private final StringProperty nomSpectacle;
	private final IntegerProperty idArtiste;
	private final IntegerProperty idRepresentation;
	private final FloatProperty tarif;
	private final StringProperty dateDebut;
	private final StringProperty heureDebut;
	
	private static int lastId = 0;

	public Spectacle() {
		this.idSpectacle = new SimpleIntegerProperty(++lastId);
		this.idArtiste = new SimpleIntegerProperty();
		this.idRepresentation = new SimpleIntegerProperty();
		this.nomSpectacle = new SimpleStringProperty();
		this.tarif = new SimpleFloatProperty();
		this.dateDebut = new SimpleStringProperty();
		this.heureDebut = new SimpleStringProperty();
	}
	
	public Spectacle(int idA, int idR, String nomS,Float tari,String debut ,String fin) {
		this.idSpectacle = new SimpleIntegerProperty(++lastId);
		this.idArtiste = new SimpleIntegerProperty(idA);
		this.idRepresentation = new SimpleIntegerProperty(idR);
		this.nomSpectacle = new SimpleStringProperty(nomS);
		this.tarif = new SimpleFloatProperty(tari);
		this.dateDebut = new SimpleStringProperty(debut);
		this.heureDebut = new SimpleStringProperty(fin);
	}
	
	public Spectacle(int idS,int idA, int idR, String nomS,Float tari,String debut ,String fin) {
		this.idSpectacle = new SimpleIntegerProperty(idS);
		this.idArtiste = new SimpleIntegerProperty(idA);
		this.idRepresentation = new SimpleIntegerProperty(idR);
		this.nomSpectacle = new SimpleStringProperty(nomS);
		this.tarif = new SimpleFloatProperty(tari);
		this.dateDebut = new SimpleStringProperty(debut);
		this.heureDebut = new SimpleStringProperty(fin);
	}
	
	public void affiche() {
		System.out.println("nomSpectacle : " + this.getNomSpectacle());
		System.out.println("Tarif : " + this.getTarif());
		System.out.println("date Debut : " + this.getDateDebut());
		System.out.println("heure Debut : " + this.getHeureDebut());
	}
	
	public int getIdSpectacle() {
        return idSpectacle.get();
    }

    public void setIdSpectacle(int idS) {
        this.idSpectacle.set(idS);
    }

    public IntegerProperty idSpectacleProperty() {
        return idSpectacle;
    }

    public String getNomSpectacle() {
        return nomSpectacle.get();
    }

    public void setNomSpectacle(String nomS) {
        this.nomSpectacle.set(nomS);
    }

    public StringProperty nomSpectacleProperty() {
        return nomSpectacle;
    }

    public int getIdArtiste() {
        return idArtiste.get();
    }

    public void setIdArtiste(int idA) {
        this.idArtiste.set(idA);
    }

    public IntegerProperty idArtisteProperty() {
        return idArtiste;
    }

    public int getIdRepresentation() {
        return idRepresentation.get();
    }

    public void setIdRepresentation(int idR) {
        this.idRepresentation.set(idR);
    }

    public IntegerProperty idRepresentationProperty() {
        return idRepresentation;
    }

    public float getTarif() {
        return tarif.get();
    }

    public void setTarif(float tari) {
        this.tarif.set(tari);
    }

    public FloatProperty tarifProperty() {
        return tarif;
    }

    public String getDateDebut() {
        return dateDebut.get();
    }

    public void setDateDebut(String debut) {
        this.dateDebut.set(debut);
    }

    public StringProperty dateDebutProperty() {
        return dateDebut;
    }

    public String getHeureDebut() {
        return heureDebut.get();
    }

    public void setHeureDebut(String fin) {
        this.heureDebut.set(fin);
    }

    public StringProperty heureDebutProperty() {
        return heureDebut;
    }
	
    @Override
    public String toString() {
        return "Spectacle{" +
                "idSpectacle=" + idSpectacle.get() +
                ", nomSpectacle='" + nomSpectacle.get() + '\'' +
                ", idArtiste=" + idArtiste.get() +
                ", idRepresentation=" + idRepresentation.get() +
                ", tarif=" + tarif.get() +
                ", dateDebut='" + dateDebut.get() + '\'' +
                ", heureDebut='" + heureDebut.get() + '\'' +
                '}';
    }
	
}
