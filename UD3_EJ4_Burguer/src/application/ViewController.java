package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewController {
	
	Pedido pedido = new Pedido();
	
	@FXML
	private Button btnDrinks, btnBurgers, btnBuy;
	
	@FXML
	private Label lblSelectedDrink = new Label();
	@FXML
	private Label lblSelectedBurger = new Label();
	@FXML
	private Label lblPriceDrink = new Label();
	@FXML
	private Label lblPriceBurger = new Label();
	

    @FXML
    void hacerPedido(ActionEvent event) {
    	
    	Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
    	alerta.setTitle("Confirme compra");
    	alerta.setHeaderText(
    	
    			"Su pedido: \n" + "\t" + lblSelectedDrink.getText() + " " + lblPriceDrink.getText() + "\n"+
    			"\t" + lblSelectedBurger.getText() + " " + lblPriceBurger.getText() +"\n \t \t" +
    			"Total: " + pedido.getPrecioPedido() + "€"
    	
    	);
    	alerta.show();
    	
    }//Comprar

    @FXML
    void openBurguers(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader =  new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("ViewBurguers.fxml"));
    	Stage stage = (Stage) btnDrinks.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
    	
    	ViewBurguersController controller = (ViewBurguersController) fxmlLoader.getController();
    	controller.setPedido(pedido);
    	//System.out.println(pedido.toString());
    	
    }//Burguers

    @FXML
    void openDrinks(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader =  new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("ViewDrinks.fxml"));
    	Stage stage = (Stage) btnDrinks.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
    	
    	ViewDrinksController controller = (ViewDrinksController) fxmlLoader.getController();
    	controller.setPedido(pedido);
    	//System.out.println(pedido.toString());
    	
    }//Drinks
    
    public void setPedido(Pedido p) {
    	
    	this.pedido = p;

    	lblSelectedDrink.setText(pedido.getDrink());
    	lblPriceDrink.setText(String.valueOf(pedido.getPriceDrink()+ "€"));
    		
   		lblSelectedBurger.setText(pedido.getBurger());
   		lblPriceBurger.setText(String.valueOf(pedido.getPriceBurger() + "€"));
    		
    }
    
    public Pedido getPedido() {
    	return this.pedido;
    }
}//Class