/**
 * 
 */
/**
 * @author nbarbotaud
 *
 */
module SAE201 {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.base;
	requires javafx.fxml;
	opens controleur to javafx.graphics,javafx.controls,javafx.base,javafx.fxml;
	opens modele to javafx.graphics,javafx.controls,javafx.base,javafx.fxml;
	opens vue to javafx.graphics,javafx.controls,javafx.base,javafx.fxml;
	opens exceptions to javafx.graphics,javafx.controls,javafx.base,javafx.fxml;
	
}