package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar menuBar;

    @FXML
    private ListView<String> listViewContactos; //La lista donde se ven los contactos

    @FXML
    private ImageView imgPhoto;

    @FXML
    private Label labelName;
    
    @FXML
    private Label labelNameInfo;

    @FXML
    private Label labelPhone;

    @FXML
    private Label labelPhoneInfo;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelEmailInfo;

    @FXML
    private Button btnEditContact;

    @FXML
    private Button btnSaveContact;
    
    @FXML
    private Button btnDelete;
    
    //Lista donde se van a añadir a quitar contactos para el ListView
    private ObservableList<String> contactStrings = FXCollections.observableArrayList();
    
    @FXML
    void saveContact(ActionEvent e) {
    	
    }
    
    @FXML
    void editContact(ActionEvent e) {
    	
    }
    
    @FXML
    void deleteContact(ActionEvent e) {
    	
    }

    @FXML
    void initialize() {
    	
    	contactStrings.addAll("Joshua", "Ana", "Pepito", "María", "Carlos", "Rosita");
    	listViewContactos.setItems(contactStrings);
    	listViewContactos.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
    					
                        if (item == null || empty) {
                        	
                        	setText(null);
        					setStyle("-fx-control-inner-background: #444759;");
        					
                        } else {
                        	
							setText(item);
							if (getIndex() % 2 == 0) {
        						setStyle("-fx-control-inner-background: #444759;");
        					} else if (getIndex() % 2 == 1) {
        						setStyle("-fx-control-inner-background: #282A36;");
        					}
						}
    					
    				}
    			};
    		}
    	});
    	
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'Main.fxml'.";
        assert listViewContactos != null : "fx:id=\"listViewContactos\" was not injected: check your FXML file 'Main.fxml'.";
        assert imgPhoto != null : "fx:id=\"imgPhoto\" was not injected: check your FXML file 'Main.fxml'.";
        assert labelName != null : "fx:id=\"labelName\" was not injected: check your FXML file 'Main.fxml'.";
        assert labelPhone != null : "fx:id=\"labelPhone\" was not injected: check your FXML file 'Main.fxml'.";
        assert labelEmail != null : "fx:id=\"labelEmail\" was not injected: check your FXML file 'Main.fxml'.";
        assert btnEditContact != null : "fx:id=\"btnEditContact\" was not injected: check your FXML file 'Main.fxml'.";
        assert btnSaveContact != null : "fx:id=\"btnSaveContact\" was not injected: check your FXML file 'Main.fxml'.";

    }
}