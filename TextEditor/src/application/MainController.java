package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;


public class MainController {
	
	private File ficheroSeleccionado = null;

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
    void abrirArchivo(ActionEvent event) {
    	
    	FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        
        if (selectedFile != null) {
            // Obtenemos el nombre del archivo (con su ruta completa)
            String nomFich = selectedFile.getPath();
            System.out.println("Has seleccionado el fichero " + nomFich);
            
            File file = new File(nomFich);
            
            try (Scanner input = new Scanner(file)) {
            	
            	textAreaMain.setText("");
            	
                while (input.hasNextLine()) {
                    textAreaMain.appendText(input.nextLine());
                    textAreaMain.appendText("\n");
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        ficheroSeleccionado = selectedFile;
        labelFileName.setText(ficheroSeleccionado.getName());

    }

    @FXML
    void acercaDe(ActionEvent event) {
    	
    	Alert alerta = new Alert(AlertType.INFORMATION);
    	alerta.setTitle("Notepad Joshua");
    	alerta.setHeaderText("Crea archivos nuevos, modifica archivos existentes, copia, pega, corta y diviértete");
    	alerta.showAndWait();

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
    void guardar(ActionEvent event) throws IOException {
    	
    	if (ficheroSeleccionado != null) {
    	
	    	FileWriter fWriter = new FileWriter(ficheroSeleccionado);
	    	fWriter.write(textAreaMain.getText());
			fWriter.close();
			labelFileName.setText(ficheroSeleccionado.getName());
			barraAbajoGuardar.setDisable(true);
    	} else {
			guardarComo(event);
		}
    }

    @FXML
    void guardarComo(ActionEvent event) throws IOException {

    	FileChooser fc = new FileChooser();
    	fc.setTitle("Guarda el fichero como:");
    	File fichero = null;

  
    	if (fichero == null) {
    		fichero = fc.showSaveDialog(null);
    	}
    	
    	FileWriter fWriter = new FileWriter(fichero);
    	
    	try {
    		fWriter.write(textAreaMain.getText());
    		fWriter.close();
    		ficheroSeleccionado = fichero;
    		labelFileName.setText(ficheroSeleccionado.getName());
    		barraAbajoGuardar.setDisable(true);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    		
    }

    @FXML
    void modificado(KeyEvent event) {
    	
    	if (barraAbajoGuardar.isDisable()) {
    		barraAbajoGuardar.setDisable(false);
    	}
    }

    @FXML
    void nuevoArchivo(ActionEvent event) {
    	ficheroSeleccionado = null;
    	textAreaMain.setText("");
    	labelFileName.setText("Untitled");
    }

    @FXML
    void pegar(ActionEvent event) {
    	Clipboard systemClipboard = Clipboard.getSystemClipboard();
        String clipboardText = systemClipboard.getString();
        textAreaMain.insertText(textAreaMain.getCaretPosition(), clipboardText);
    }

    @FXML
    void salir(ActionEvent event) {
    	System.exit(0);

    }

}

