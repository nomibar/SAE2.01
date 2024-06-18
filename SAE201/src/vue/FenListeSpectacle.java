package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class FenListeSpectacle extends Stage {
	
	public FenListeSpectacle() throws IOException {
		this.setTitle("Liste des Spectacles");
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
		this.setMinWidth(300);
		this.setMinHeight(300);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/listeSpectacles.fxml"));
        Pane root = loader.load();
        loader.getController();
     	return root;
	}
}