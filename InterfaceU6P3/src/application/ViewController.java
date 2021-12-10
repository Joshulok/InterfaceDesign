package application;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDestinatario;

    @FXML
    private Button btnMarcha;
    
    @FXML
    private Button btnSiguiente;

    @FXML
    private ImageView ivTruck;

    @FXML
    void destinatario(ActionEvent event) {
    	//Definimos hasta donde se va a mover el objeto
    	KeyValue movimientoHasta = new KeyValue(ivTruck.translateXProperty(), 700);
    	//Definimos la duración de la animación
    	KeyFrame frames = new KeyFrame(Duration.seconds(5), movimientoHasta);
    	//creamos el timeline donde metemos los datos anteriores
    	Timeline timeline = new Timeline(frames);
    	//reproducimos la animación
    	timeline.play();
    	
    }

    @FXML
    void marcha(ActionEvent event) {
    	//Desactivamos los botones
    	btnMarcha.setDisable(true);
    	btnDestinatario.setDisable(false);
    	//Creamos el efecto
    	GaussianBlur blur = new GaussianBlur();
        blur.setRadius(6);
        //Asignamos el efecto a la imagen
        ivTruck.setEffect(blur);

    }
    
    @FXML
    void siguiente(ActionEvent e) throws IOException {
    	
    	FXMLLoader fxmlLoader =  new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("View2.fxml"));
    	Stage stage = (Stage) btnDestinatario.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert btnDestinatario != null : "fx:id=\"btnDestinatario\" was not injected: check your FXML file 'View.fxml'.";
        assert btnMarcha != null : "fx:id=\"btnMarcha\" was not injected: check your FXML file 'View.fxml'.";
        assert ivTruck != null : "fx:id=\"ivTruck\" was not injected: check your FXML file 'View.fxml'.";

    }

}
