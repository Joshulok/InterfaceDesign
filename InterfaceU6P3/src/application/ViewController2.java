package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ViewController2 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBrome;

    @FXML
    private Button btnProgramar;
    
    private Boolean bromaBoolean = false;

    @FXML
    void bromita(MouseEvent event) {
    	
    	if (!bromaBoolean) {
    		Random r = new Random();
        	btnBrome.setLayoutX(btnBrome.getLayoutX()+r.nextInt(100)+50);
        	btnBrome.setLayoutY(btnBrome.getLayoutY()+r.nextInt(100)+50);
        }
    }
    	
    	

    @FXML
    void desactivaBrome(ActionEvent event) {
    	Alert alerta = new Alert(AlertType.CONFIRMATION);
    	alerta.setHeaderText("Venga, ya puedes pulsar el otro botón");
    	alerta.setTitle("Broma desactivada");
    	alerta.showAndWait();
    	bromaBoolean = true;
    }

    @FXML
    void salir(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void initialize() {
        assert btnBrome != null : "fx:id=\"btnBrome\" was not injected: check your FXML file 'View2.fxml'.";
        assert btnProgramar != null : "fx:id=\"btnProgramar\" was not injected: check your FXML file 'View2.fxml'.";

    }

}
