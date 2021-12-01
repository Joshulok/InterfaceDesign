package votaciones;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StatsViewController {
	
	Partido P1;
	Partido P2;
	Partido P3;
	Partido P4;
	Partido P5;
	Partido P6;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String, Integer>  bcVotaciones;
    
   @FXML
   private Button btnAtras;
   
   @FXML
   void salir(ActionEvent event) throws IOException {
	   FXMLLoader fxmlLoader =  new FXMLLoader();
	   	fxmlLoader.setLocation(getClass().getResource("MainView.fxml"));
	   	Stage stage = (Stage) btnAtras.getScene().getWindow();
	   	Scene scene = new Scene(fxmlLoader.load());
	   	stage.setScene(scene);
   }
    
    void pasarPartidos(Partido p1, Partido p2 , Partido p3, Partido p4, Partido p5, Partido p6) {
    	P1 = p1;
    	P2 = p2;
    	P3 = p3;
    	P4 = p4;
    	P5 = p5;
    	P6 = p6;
    	
    	XYChart.Series<String, Integer> datosP1 = new XYChart.Series<String, Integer>();
    	datosP1.setName("P1");
    	datosP1.getData().add(new XYChart.Data("P1", P1.getVotos()));
    	XYChart.Series<String, Integer> datosP2 = new XYChart.Series<String, Integer>();
    	datosP2.setName("P2");
    	datosP2.getData().add(new XYChart.Data("P2", P2.getVotos()));
    	XYChart.Series<String, Integer> datosP3 = new XYChart.Series<String, Integer>();
    	datosP3.setName("P3");
    	datosP3.getData().add(new XYChart.Data("P3", P3.getVotos()));
    	XYChart.Series<String, Integer> datosP4 = new XYChart.Series<String, Integer>();
    	datosP4.setName("P4");
    	datosP4.getData().add(new XYChart.Data("P4", P4.getVotos()));
    	XYChart.Series<String, Integer> datosP5 = new XYChart.Series<String, Integer>();
    	datosP5.setName("P5");
    	datosP5.getData().add(new XYChart.Data("P5", P5.getVotos()));
    	XYChart.Series<String, Integer> datosP6 = new XYChart.Series<String, Integer>();
    	datosP6.setName("P6");
        datosP6.getData().add(new XYChart.Data("P6", P6.getVotos()));
        
        bcVotaciones.getData().addAll(datosP1, datosP2, datosP3, datosP4, datosP5, datosP6);
    }

    @FXML
    void initialize() {
        assert bcVotaciones != null : "fx:id=\"bcVotaciones\" was not injected: check your FXML file 'StatsView.fxml'.";
        
        //intento de cambiar el color pero no tengo claro cómo
        //datosP1.getNode().setStyle("-fx-bar-fill: navy;");
    }
}