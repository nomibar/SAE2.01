package vue;

import java.time.LocalDate;

import controleur.Main;
import exceptions.InvalidTarifException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.Spectacle;

public class CtrlModifierSpectacle {
	@FXML
    private TextField txtTarif;

    @FXML
    private TextField txtHeureDebut;

    @FXML
    private DatePicker dpDateDebut;

    @FXML
    private Button bnOK;

    @FXML
    private TextField txtIdArtiste;

    @FXML
    private TextField txtIdRepresentation;

    @FXML
    private Button bnAnnuler;

    @FXML
    private TextField txtNom;
    
    @FXML
    private Label lblTarif;
    
    private int idspec;

    @FXML public void clicAnnuler() {
        Main.fermerModifierSpectacle();
    }

    @FXML public void clicOK() {
    	float tarif = Float.parseFloat(txtTarif.getText());
    	if (tarif <= 0) {
    		lblTarif.setVisible(true);
			Main.validerModifierSpectacle(
	                idspec,
	                Integer.parseInt(txtIdArtiste.getText()),
	                Integer.parseInt(txtIdRepresentation.getText()), 
	                txtNom.getText(), 
	                tarif, 
	                dpDateDebut.getValue().getDayOfMonth(),
	                dpDateDebut.getValue().getMonthValue(),
	                dpDateDebut.getValue().getYear(),
	                txtHeureDebut.getText()
	            );
    		
    	} else {
    			lblTarif.setVisible(false);
    			
    	}
    	
    }

    public void afficherSpectacle(Spectacle e) {
        txtNom.setText(e.getNomSpectacle());
        txtHeureDebut.setText(e.getHeureDebut());
        if (!e.getDateDebut().isEmpty()) {
            String[] dateParts = e.getDateDebut().split("/");
            int jour = Integer.parseInt(dateParts[0]);
            int mois = Integer.parseInt(dateParts[1]);
            int annee = Integer.parseInt(dateParts[2]);
            dpDateDebut.setValue(LocalDate.of(annee, mois, jour));
        }
        idspec=e.getIdSpectacle();
        
        txtTarif.setText(String.valueOf(e.getTarif()));
        txtIdArtiste.setText(String.valueOf(e.getIdArtiste()));
        txtIdRepresentation.setText(String.valueOf(e.getIdRepresentation()));
    }

    public void initialize() {
        bnOK.disableProperty().bind(txtNom.textProperty().isEmpty());
        lblTarif.setVisible(false);
    }
}