package application;

import models.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CreateContactViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfContactName;

    @FXML
    private TextField tfContactPhone;

    @FXML
    private TextField tfContactEmail;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSubmit;
    
    private ObservableList<String> contacts = FXCollections.observableArrayList();
    private ObservableList<Contact> contactoInfo = FXCollections.observableArrayList();

    @FXML
    void cancelOperation(ActionEvent event) {

    }

    @FXML
    void submitContact(ActionEvent event) throws IOException {
    	Contact newContact = new Contact(null, null, null);
    	
    	if (tfContactName.getText() == "") {
    		
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("No name found");
    		alert.setHeaderText("The new contat must have a name, please insert a name.");
    		alert.showAndWait();
    		
    	} else {
			newContact.setName(tfContactName.getText());
			newContact.setPhoneNumber(tfContactPhone.getText());
			newContact.setEmail(tfContactEmail.getText());
			
			FXMLLoader fxmlLoader =  new FXMLLoader();
	    	fxmlLoader.setLocation(getClass().getResource("Main.fxml"));
	    	Stage stage = (Stage) btnSubmit.getScene().getWindow();
	    	Scene scene = new Scene(fxmlLoader.load());
	    	stage.setScene(scene);
	    	
	    	MainController controller = (MainController) fxmlLoader.getController();
	    	controller.setContact(newContact, contacts, contactoInfo);
		}
    }

    @FXML
    void initialize() {
    	
    	
    	
        assert tfContactName != null : "fx:id=\"tfContactName\" was not injected: check your FXML file 'CreateContactView.fxml'.";
        assert tfContactPhone != null : "fx:id=\"tfContactPhone\" was not injected: check your FXML file 'CreateContactView.fxml'.";
        assert tfContactEmail != null : "fx:id=\"tfContactEmail\" was not injected: check your FXML file 'CreateContactView.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'CreateContactView.fxml'.";
        assert btnSubmit != null : "fx:id=\"btnSubmit\" was not injected: check your FXML file 'CreateContactView.fxml'.";

    }
    
    void setContacts(ObservableList<String> contacts, ObservableList<Contact> contactInfo) {
    	this.contacts = contacts;
    	this.contactoInfo = contactInfo;
    }
}
