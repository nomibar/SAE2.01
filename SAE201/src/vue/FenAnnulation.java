package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Spectacle;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class FenAnnulation extends Stage {

	private CtrlAnnulation ctrl;

	public FenAnnulation() throws IOException {
		this.setTitle("Liste des annulations");
		this.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}
	
	public void ajouterListe(Spectacle spectacle) {
    	ctrl.ajouterListe(spectacle);
    }

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ListeAnnulationSpectacles.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
     	return root;
	}
}