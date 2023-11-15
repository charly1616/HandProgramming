/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class PrincipalController implements Initializable {

    @FXML
    private Button buttontablero;
    @FXML
    private Button buttontutoriales;
    @FXML
    private Button buttonautores;
    @FXML
    private Button buttonsalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnActionButtontablero(ActionEvent event) {
          try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ventana.fxml"));
        Parent root = loader.load();
        
        // Obtén la escena actual y cámbiala a la nueva escena con "ventana.fxml"
        Scene scene = buttontablero.getScene();
        scene.setRoot(root);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    private void OnActionButtontutorial(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Tutorial.fxml"));
        Parent root = loader.load();
        
        // Obtén la escena actual y cámbiala a la nueva escena con "ventana.fxml"
        Scene scene = buttontutoriales.getScene();
        scene.setRoot(root);
    } catch (IOException e
            ) {
        e.printStackTrace();
    }
    }

    private void OnActionButtonautores(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Autores.fxml"));
        Parent root = loader.load();
        
        // Obtén la escena actual y cámbiala a la nueva escena con "ventana.fxml"
        Scene scene = buttonautores.getScene();
        scene.setRoot(root);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void OnActionButtonsalir(ActionEvent event) {
    System.exit(0);
}
}
