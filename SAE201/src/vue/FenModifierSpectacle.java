package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Spectacle;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class FenModifierSpectacle extends Stage {
	
	private CtrlModifierSpectacle ctrl;
	
	public FenModifierSpectacle() throws IOException {
		this.setTitle("DÃ©tail du spectacle");
		this.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/modifierSpectacle.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
     	return root;
	}
	
	public void afficherSpectacle(Spectacle e) {
		ctrl.afficherSpectacle(e);
	}
	
	

}