package vue;

import java.util.function.Predicate;
import controleur.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Spectacle;

public class CtrlAnnulation {
	
    @FXML private Button bnFermer;
    @FXML private TableView<Spectacle> listeSpectaclesAnnules;
    @FXML private TextField textIdArtiste;
    
    private ObservableList<Spectacle> spectaclesAnnules = FXCollections.observableArrayList();
    private FilteredList<Spectacle> donneesFiltrees;
    
    @FXML
    void clicFermer() {
    	Main.fermerAnnulation();
    }
    
    public void ajouterListe(Spectacle spectacle) {
        spectaclesAnnules.add(spectacle);
    }
    
    @FXML 
    void initialize() {
        TableColumn<Spectacle, String> colonne1 = new TableColumn<>("Nom Spectacle");
        colonne1.setCellValueFactory(new PropertyValueFactory<>("nomSpectacle"));
        TableColumn<Spectacle, String> colonne2 = new TableColumn<>("Tarif");
        colonne2.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        TableColumn<Spectacle, String> colonne3 = new TableColumn<>("Date Début");
        colonne3.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        TableColumn<Spectacle, Integer> colonne4 = new TableColumn<>("Heure Début");
        colonne4.setCellValueFactory(new PropertyValueFactory<>("heureDebut"));
        TableColumn<Spectacle, Integer> colonne5 = new TableColumn<>("ID Spectacle");
        colonne5.setCellValueFactory(new PropertyValueFactory<>("idSpectacle"));
        TableColumn<Spectacle, Integer> colonne6 = new TableColumn<>("ID Artiste");
        colonne6.setCellValueFactory(new PropertyValueFactory<>("idArtiste"));
        TableColumn<Spectacle, Integer> colonne7 = new TableColumn<>("ID Représentation");
        colonne7.setCellValueFactory(new PropertyValueFactory<>("idRepresentation"));

        listeSpectaclesAnnules.getColumns().add(colonne1);
        listeSpectaclesAnnules.getColumns().add(colonne2);
        listeSpectaclesAnnules.getColumns().add(colonne3);
        listeSpectaclesAnnules.getColumns().add(colonne4);
        listeSpectaclesAnnules.getColumns().add(colonne5);
        listeSpectaclesAnnules.getColumns().add(colonne6);
        listeSpectaclesAnnules.getColumns().add(colonne7);

        donneesFiltrees = new FilteredList<>(spectaclesAnnules, p -> true);
        listeSpectaclesAnnules.setItems(donneesFiltrees);
        
        listeSpectaclesAnnules.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        textIdArtiste.textProperty().addListener((observable, oldValue, newValue) -> {
        	donneesFiltrees.setPredicate(createPredicate(newValue));
        });
    }
    
    private Predicate<Spectacle> createPredicate(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return spectacle -> true;
        } else {
            try {
                int idArtiste = Integer.parseInt(filterText);
                return spectacle -> spectacle.getIdArtiste() == idArtiste;
            } catch (NumberFormatException e) {
                return spectacle -> false;
            }
        }
    }
}