package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Contact;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar menuBar;
    
    @FXML
    private MenuItem menuItemNewContact;
    
    @FXML
    private MenuItem menuItemAbout;
    
    @FXML
    private MenuItem menuItemHowTo;

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
    
    //Lista donde se van a añadir a quitar contactos para el ListView
    private ObservableList<String> contacts = FXCollections.observableArrayList();
    private ObservableList<Contact> contactInfo = FXCollections.observableArrayList();
    
    private Contact contact = new Contact(null, null, null);
    
    @FXML
    void aboutUs(ActionEvent e) {
    	
    }
    
    @FXML
    void howTo(ActionEvent e) {
    	
    }
    
    @FXML
    void createContact(ActionEvent e) throws IOException {
    	
    	FXMLLoader fxmlLoader =  new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("CreateContactView.fxml"));
    	Stage stage = (Stage) btnEditContact.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
    	//Paso la lista de los contactos para que al limpiar la memoria la lista no se pierda
    	CreateContactViewController controller = (CreateContactViewController) fxmlLoader.getController();
    	controller.setContacts(contacts, contactInfo);
    	
    }
    
    @FXML
    void editContact(ActionEvent e) {
    	Stage stage = new Stage();
    	VBox pane = new VBox();
    	pane.setStyle("-fx-background-color: #CAA9FA");
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.setTitle("Edit Contact");
    	stage.setScene(new Scene(pane, 400, 200));
    	Label name = new Label(labelNameInfo.getText());
    	Label phone = new Label("Phone");
    	TextField tfPhone = new TextField();
    	Label emaiLabel = new Label("Email");
    	TextField tfEmailField = new TextField();
    	Button btnEdit = new Button("Submit changes");
    	pane.getChildren().addAll(name, phone, tfPhone,emaiLabel, tfEmailField, btnEdit);
    	stage.show();
    	
    	btnEdit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				labelPhoneInfo.setText(tfPhone.getText());
				labelEmailInfo.setText(tfEmailField.getText());
			}
		});
    }

    @FXML
    void initialize() {
    	
    	listViewContactos.setItems(contacts);
    	
    	//le hacemos saber al usuario que no tiene contactos añadidos
    	ObservableList<String> example = FXCollections.observableArrayList("No contacts yet");
    	
    	
    	if (listViewContactos.getItems().isEmpty()) {
			listViewContactos.setItems(example);
		}
    	
    	
    	//Para cambiar el color de las celdas del ListView
    	listViewContactos.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
    					//Las celdas que no tengan contactos, recibiran un color por defecto
                        if (item == null || empty) {
                        	
                        	setText("");
        					setStyle("-fx-control-inner-background: #444759;");
        				//las que sí tengan información, las celdas pares reciben un color, y las impares otro
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
    	
    	//Para poder traslaar la información en la ventana de al lado añadimos in listener al ListView:
    	listViewContactos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> ov, String t, String t1) {
    			labelNameInfo.setText(t1);
    			//buscamos por nombre cada uno de los objetos para encontrar el que esté seleccionado
    			for (int i = 0; i <= contactInfo.size()-1; i++) {
    				//si corresponde con el seleccionado, añadimos la información
    				if (contactInfo.get(i).getName() == t1) {
    					labelPhoneInfo.setText(contactInfo.get(i).getPhoneNumber());
    					labelEmailInfo.setText(contactInfo.get(i).getEmail());
    				}
    			}
    		}
		});
    	

        assert listViewContactos != null : "fx:id=\"listViewContactos\" was not injected: check your FXML file 'Main.fxml'.";
        assert imgPhoto != null : "fx:id=\"imgPhoto\" was not injected: check your FXML file 'Main.fxml'.";
        assert labelName != null : "fx:id=\"labelName\" was not injected: check your FXML file 'Main.fxml'.";
        assert labelPhone != null : "fx:id=\"labelPhone\" was not injected: check your FXML file 'Main.fxml'.";
        assert labelEmail != null : "fx:id=\"labelEmail\" was not injected: check your FXML file 'Main.fxml'.";
        assert btnEditContact != null : "fx:id=\"btnEditContact\" was not injected: check your FXML file 'Main.fxml'.";
    }
    
    public void setContact(Contact contact, ObservableList<String> contacts, ObservableList<Contact> contactInfo) throws IOException {
    	
    	this.contact = contact;
    	this.contacts = contacts;
    	this.contactInfo = contactInfo;
    	contactInfo.add(contact);
    	contacts.add(contact.getName());
    	initialize();
    }
    
    public Contact getContact() {
    	return this.contact;
    }
}