package vue;

import java.time.LocalDate;

import controleur.Main;
import exceptions.InvalidTarifException;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CtrlNouveauSpectacle {

    @FXML private Button bnOK;
    @FXML private Button bnAnnuler;
    @FXML private TextField txtIdArtiste;
    @FXML private TextField txtIdRepresentation;
    @FXML private TextField txtNom;
    @FXML private TextField txtTarif;
    @FXML private TextField txtHeureDebut;
    @FXML private DatePicker dpDateDebut;

    @FXML public void clicAnnuler() {
    	controleur.Main.fermerNouveauSpectacle();
    }
    
    @FXML public void clicOK() {
    	try {
            float tarif = Float.parseFloat(txtTarif.getText());
            if (tarif < 0) {
                throw new InvalidTarifException("Le tarif doit être supérieur ou égal à 0.");
            }
    	Main.validerNouveauSpectacle(
    		Integer.parseInt(txtIdArtiste.getText()),
    		Integer.parseInt(txtIdRepresentation.getText()),
    		txtNom.getText(),
    		Float.parseFloat(txtTarif.getText()),
    		dpDateDebut.getValue().getYear(),
    		dpDateDebut.getValue().getMonthValue(),
    		dpDateDebut.getValue().getDayOfMonth(),
			txtHeureDebut.getText()
		);
    	
    } catch (NumberFormatException e) {
        System.err.println("Le format du tarif est invalide.");
    } catch (InvalidTarifException e) {
        System.err.println(e.getMessage());
    }
    }
    
    public void effacer() {
    	txtNom.clear();
    	txtTarif.clear();
    	txtIdArtiste.clear();
    	txtIdRepresentation.clear();
    	txtHeureDebut.clear();
    	dpDateDebut.setValue(LocalDate.now());
    }
    
    public void initialize() {
    	dpDateDebut.setValue(LocalDate.now());
    	
    	BooleanBinding manque = Bindings.or(txtNom.textProperty().isEmpty(), txtNom.textProperty().isEmpty());
		bnOK.disableProperty().bind(Bindings.when(manque).then(true).otherwise(false));
    }
}