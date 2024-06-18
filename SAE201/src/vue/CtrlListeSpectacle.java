package vue;

import java.util.Optional;
import java.util.function.Predicate;
import controleur.Main;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Donnees;
import modele.Spectacle;

public class CtrlListeSpectacle {

    @FXML private Button bnAjouter;
    @FXML private Button bnModifier;
    @FXML private Button bnSupprimer;
    @FXML private Button bnFermer;
    @FXML private TableView<Spectacle> tvListeSpectacles;
    @FXML private Button bnAnnulation;
    @FXML private TextField textIdArtiste;
    
    private Optional<ButtonType> res;
    
    private FilteredList<Spectacle> donneesFiltrees;

    // clic sur bouton Ajouter
    @FXML void clicAjouter(ActionEvent event) {
        Main.ouvrirNouveauSpectacle();
    }

    // clic sur bouton Modifier
    @FXML void clicModifier(ActionEvent event) {
        Main.ouvrirModifierSpectacle(tvListeSpectacles.getSelectionModel().getSelectedItem());
    }

    // clic sur bouton Supprimer
    @FXML void clicSupprimer(ActionEvent event) {
        Alert alert = new Alert(
                AlertType.CONFIRMATION,
                "Voulez-vous vraiment supprimer ce Spectacle ?",
                ButtonType.YES,
                ButtonType.NO
        );

        alert.setTitle("Confirmation de suppression");

        res = alert.showAndWait();
        if (res.isPresent() && res.get() == ButtonType.YES) {
        	Main.ajouterListe(tvListeSpectacles.getSelectionModel().getSelectedItem());
            Main.supprimerSpectacle(tvListeSpectacles.getSelectionModel().getSelectedItem());
        }
    }

    // clic sur bouton Fermer
    @FXML void clicFermer(ActionEvent event) {
        Main.fermerAppli();
    }
    
    @FXML
    void clicAnnulation(ActionEvent event) {
    	Main.ouvrirAnnulation();
    }

    @FXML void initialize() {
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

        tvListeSpectacles.getColumns().add(colonne1);
        tvListeSpectacles.getColumns().add(colonne2);
        tvListeSpectacles.getColumns().add(colonne3);
        tvListeSpectacles.getColumns().add(colonne4);
        tvListeSpectacles.getColumns().add(colonne5);
        tvListeSpectacles.getColumns().add(colonne6);
        tvListeSpectacles.getColumns().add(colonne7);
        
        donneesFiltrees = new FilteredList<>(Donnees.getLesSpectacles(), p -> true);
        tvListeSpectacles.setItems(donneesFiltrees);

        tvListeSpectacles.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Griser les boutons Modifier et Supprimer quand rien n'est selectionné
        BooleanBinding rien = Bindings.equal(tvListeSpectacles.getSelectionModel().selectedIndexProperty(), -1);
        bnSupprimer.disableProperty().bind(rien);
        bnModifier.disableProperty().bind(rien);
        
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
