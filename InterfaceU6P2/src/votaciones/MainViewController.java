package votaciones;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class MainViewController {
	
	Partido P1 = new Partido("P1", 0);
	Partido P2 = new Partido("P2", 0);
	Partido P3 = new Partido("P3", 0);
	Partido P4 = new Partido("P4", 0);
	Partido P5 = new Partido("P5", 0);
	Partido P6 = new Partido("P6", 0);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnP1;

    @FXML
    private Tooltip tpP1;

    @FXML
    private Button btnP6;

    @FXML
    private Tooltip tpP6;

    @FXML
    private Button btnP5;

    @FXML
    private Tooltip tpP5;

    @FXML
    private Button btnP4;

    @FXML
    private Tooltip tpP4;

    @FXML
    private Button btnP3;

    @FXML
    private Tooltip tpP3;

    @FXML
    private Button btnP2;

    @FXML
    private Tooltip tpP2;

    @FXML
    private Button btnStats;

    @FXML
    void abrirStats(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader =  new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("StatsView.fxml"));
    	Stage stage = (Stage) btnP1.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
    	
    	StatsViewController controller = (StatsViewController) fxmlLoader.getController();
    	controller.pasarPartidos(P1, P2, P3, P4, P5, P6);
    	
    }

    @FXML
    void votar(ActionEvent event) {
    	//saco la fuente de donde viene el click, y saco la parte de toString en la cual sale la id del botón
    	String fuente = event.getSource().toString().substring(13,15);
    	
    	switch (fuente) {
    	case "P1":
    		P1.voto();
    		break;
    	case "P2":
    		P2.voto();
    		break;
    	case "P3":
    		P3.voto();
    		break;
    	case "P4":
    		P4.voto();
    		break;
    	case "P5":
    		P5.voto();
    		break;
    	case "P6":
    		P6.voto();
    		break;
    	}
    	
    }

    @FXML
    void initialize() {
        assert btnP1 != null : "fx:id=\"btnP1\" was not injected: check your FXML file 'MainView.fxml'.";
        assert tpP1 != null : "fx:id=\"tpP1\" was not injected: check your FXML file 'MainView.fxml'.";
        assert btnP6 != null : "fx:id=\"btnP6\" was not injected: check your FXML file 'MainView.fxml'.";
        assert tpP6 != null : "fx:id=\"tpP6\" was not injected: check your FXML file 'MainView.fxml'.";
        assert btnP5 != null : "fx:id=\"btnP5\" was not injected: check your FXML file 'MainView.fxml'.";
        assert tpP5 != null : "fx:id=\"tpP5\" was not injected: check your FXML file 'MainView.fxml'.";
        assert btnP4 != null : "fx:id=\"btnP4\" was not injected: check your FXML file 'MainView.fxml'.";
        assert tpP4 != null : "fx:id=\"tpP4\" was not injected: check your FXML file 'MainView.fxml'.";
        assert btnP3 != null : "fx:id=\"btnP3\" was not injected: check your FXML file 'MainView.fxml'.";
        assert tpP3 != null : "fx:id=\"tpP3\" was not injected: check your FXML file 'MainView.fxml'.";
        assert btnP2 != null : "fx:id=\"btnP2\" was not injected: check your FXML file 'MainView.fxml'.";
        assert tpP2 != null : "fx:id=\"tpP2\" was not injected: check your FXML file 'MainView.fxml'.";
        assert btnStats != null : "fx:id=\"btnStats\" was not injected: check your FXML file 'MainView.fxml'.";
        
        btnP1.setTooltip(tpP1);
        btnP2.setTooltip(tpP2);
        btnP3.setTooltip(tpP3);
        btnP4.setTooltip(tpP4);
        btnP5.setTooltip(tpP5);
        btnP6.setTooltip(tpP6);
    }
}
