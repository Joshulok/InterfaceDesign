package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class MainController {

    @FXML
    private Menu menuArchivo;

    @FXML
    private MenuItem menuNuevo;

    @FXML
    private MenuItem menuAbrir;

    @FXML
    private MenuItem menuGuardar;

    @FXML
    private MenuItem menuGuardarComo;

    @FXML
    private MenuItem menuSalir;

    @FXML
    private MenuItem menuCopiar;

    @FXML
    private MenuItem menuPegar;

    @FXML
    private MenuItem menuCortar;

    @FXML
    private MenuItem menuAyuda;

    @FXML
    private TextArea textAreaMain;

    @FXML
    private Button barraNuevoArchivo;
    private Tooltip tpAbrir = new Tooltip("Nuevo Archivo");

    @FXML
    private Button barraAbrir;

    @FXML
    private Button barraGuardar;

    @FXML
    private Button barraCortar;

    @FXML
    private Button barraCopiar;

    @FXML
    private Button barraPegar;

    @FXML
    private Button barraSalir;

    @FXML
    private Label labelFileName;

    @FXML
    private Button barraAbajoGuardar;

    @FXML
    void abrirArchivo(MouseEvent event) {
    	
    	FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        
        if (selectedFile != null) {
            // Obtenemos el nombre del archivo (con su ruta completa)
            String nomFich = selectedFile.getPath();
            System.out.println("Has seleccionado el fichero " + nomFich);
            
            File file = new File(nomFich);
            
            try (Scanner input = new Scanner(file)) {
                while (input.hasNextLine()) {
                    textAreaMain.appendText(input.nextLine());
                    textAreaMain.appendText("\n");
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

    }

    @FXML
    void acercaDe(ActionEvent event) {

    }

    @FXML
    void copiar(ActionEvent event) {
    	
    	Clipboard clipboard = Clipboard.getSystemClipboard();
       	ClipboardContent clipContent = new ClipboardContent();
       	clipContent.putString(textAreaMain.getText());
       	clipboard.setContent(clipContent);
       	
    }

    @FXML
    void cortar(ActionEvent event) {
    	copiar(event);
    	textAreaMain.setText("");	
    }

    @FXML
    void guardar(ActionEvent event) {

    }

    @FXML
    void guardarComo(ActionEvent event) {

    }

    @FXML
    void modificado(KeyEvent event) {

    }

    @FXML
    void nuevoArchivo(MouseEvent event) {

    }

    @FXML
    void pegar(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {

    }

}

