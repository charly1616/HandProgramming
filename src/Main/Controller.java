
package Main;

import Model.BlockController;
import Model.Bloque;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller implements Initializable {

    @FXML
    public AnchorPane ventana;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        crearBloque(Color.BEIGE);
        crearBloque(Color.BURLYWOOD);
        crearBloque(Color.CORNFLOWERBLUE);
        crearBloque(Color.DARKOLIVEGREEN);
        crearBloque(Color.HOTPINK);

    }

    public void crearBloque(Color c) {
        try {
            FXMLLoader f = new FXMLLoader();
            f.setLocation(getClass().getResource("block.fxml"));
            Pane p = f.load();
            BlockController Bcon = f.getController();
            Bloque b = new Bloque(30, 30, c);
            Bcon.Pintar(b);
            ventana.getChildren().add(p);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}