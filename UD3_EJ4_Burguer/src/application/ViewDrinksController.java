package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewDrinksController {
	
	Pedido pedido = new Pedido();

    @FXML
    private ImageView imgSoda;

    @FXML
    private ImageView imgWater;

    @FXML
    void sellSoda(MouseEvent event) throws IOException {
    	pedido.setDrink("Soda", 2);
    	
    	FXMLLoader fxmlLoader =  new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("View.fxml"));
    	Stage stage = (Stage) imgWater.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
    	
    	ViewController controller = (ViewController) fxmlLoader.getController();
    	controller.setPedido(pedido);
    }

    @FXML
    void sellWater(MouseEvent event) throws IOException {
    	pedido.setDrink("Agua", 1);
    	
    	FXMLLoader fxmlLoader =  new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("View.fxml"));
    	Stage stage = (Stage) imgWater.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
    	
    	ViewController controller = (ViewController) fxmlLoader.getController();
    	controller.setPedido(pedido);
    }
    
    public void setPedido(Pedido p) {
    	this.pedido = p;
    }
    
    public Pedido getPedido() {
    	return this.pedido;
    }

}
