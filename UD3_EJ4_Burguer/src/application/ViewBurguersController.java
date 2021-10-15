package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewBurguersController {
	
	Pedido pedido = new Pedido();

    @FXML
    private ImageView imgBurger1;

    @FXML
    private ImageView imgBurger2;

    @FXML
    void sellBurger2(MouseEvent event) throws IOException {
    	
    	pedido.setBurger("Burger Veggie", 6);
    	
    	FXMLLoader fxmlLoader =  new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("View.fxml"));
    	Stage stage = (Stage) imgBurger1.getScene().getWindow();
    	Scene scene = new Scene(fxmlLoader.load());
    	stage.setScene(scene);
    	
    	ViewController controller = (ViewController) fxmlLoader.getController();
    	controller.setPedido(pedido);
    	
    }

    @FXML
    void sellBurguer1(MouseEvent event) throws IOException {

    	pedido.setBurger("Burger Classic", 8);
    	
    	FXMLLoader fxmlLoader =  new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("View.fxml"));
    	Stage stage = (Stage) imgBurger1.getScene().getWindow();
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
