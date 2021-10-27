package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ViewController {
	
	@FXML
	private Label labelUser;
	
	@FXML
	private Label labelPass;
	
	@FXML
	private Label labelScript;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField passWord;

    @FXML
    ComboBox<String> cbIdioma;

    @FXML
    void selection(MouseEvent event) {
    	cbIdioma.getItems().addAll("Español", "Inglés", "Alemán", "Klingon");
    	
    }
    
    @FXML
    void language() {
    	String language = cbIdioma.getValue();
    	
    	if (language == "Español") {
    		
    		labelUser.setText("Usuario");
  			labelPass.setText("Constraseña");
  			userName.setPromptText("Usuario");
  			passWord.setPromptText("Contraseña");
  			
    	} else if (language == "Inglés") {
    		
    		labelUser.setText("User");
  			labelPass.setText("Password");
  			userName.setPromptText("User");
  			passWord.setPromptText("Password");
    		
    	}else if (language == "Alemán") {
    		
    		labelUser.setText("Nutzername");
  			labelPass.setText("Passwort");
  			userName.setPromptText("Nutzername");
  			passWord.setPromptText("Passwort");
    		
    	} else if (language == "Klingon") {
    		
    		labelUser.setText("gho");
  			labelPass.setText("polonyuS");
  			userName.setPromptText("gho");
  			passWord.setPromptText("polonyuS");
    		
    	}
    }

    @FXML
    void initialize() {
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'View.fxml'.";
        assert passWord != null : "fx:id=\"passWord\" was not injected: check your FXML file 'View.fxml'.";
        assert cbIdioma != null : "fx:id=\"cbIdioma\" was not injected: check your FXML file 'View.fxml'.";

    }
	
}
