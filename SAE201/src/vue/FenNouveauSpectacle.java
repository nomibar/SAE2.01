package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class FenNouveauSpectacle extends Stage {
	
	private CtrlNouveauSpectacle ctrl;

	public FenNouveauSpectacle() throws IOException {
		this.setTitle("Nouveau Spectacle");
		this.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/nouveauSpectacle.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
     	return root;
	}
	
	public void effacer() {
		ctrl.effacer();
	}

}

