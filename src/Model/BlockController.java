
package Model;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class BlockController implements Initializable {
    
    @FXML
    public Pane Sense;
    
    @FXML
    public Rectangle SidePart;
    
    @FXML
    public Rectangle TopPart;
    
    public double mouseAnchorX;
    public double mouseAnchorY;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hacerMovible();
    }
    
    
    public void hacerMovible(){
        Sense.setOnMousePressed((MouseEvent mouseEvent) -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });
        
        
        
        Sense.setOnDragDetected((MouseEvent mouseEvent) -> {
            Agarrado();
        });
        
        Sense.setOnMouseDragged(mouseEvent -> {
            Sense.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            Sense.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);
            Sense.toFront();
        });
        
        
        Sense.setOnMouseReleased((MouseEvent mouseEvent) -> {
            Soltado();
        });
        
    }
    
    
    public void Agarrado(){
        setColorBorde(Color.DODGERBLUE);
        setTamBorde(6);
        Sense.toFront();
    }
    
    public void Soltado(){
        setColorBorde(Color.color(30/255.0, 30/255.0, 30/255.0));
        setTamBorde(4);
    }
    
    
    
    
    
    public void setColorBorde(Color s){
        TopPart.setStroke(s);
        SidePart.setStroke(s);
    }
    
    public void setTamBorde(double b){
        TopPart.setStrokeWidth(b);
        SidePart.setStrokeWidth(b);
    }
    
    
    
    //Conecta el Bloque Conceptual a un bloque que es visible
    public void Pintar(Bloque bloq){
        
        Sense.setStyle("-fx-background-color: rgba(0, 100, 100, 0); -fx-background-radius: 10;");
        
        //Aplicacion del color
        Color c = bloq.ColorBloque;
        TopPart.setFill(c);
        SidePart.setFill(c.darker().darker()); //La parte de abajo es un color mas oscuro
        
        Color s = bloq.ColorBorde;
        setColorBorde(s);
        
        //Colocar el tamaño de borde
        setTamBorde(bloq.TamBorde);
        
        Sense.setBackground(Background.fill(new Color(1,1,1,1)));
        
        
        //ancho de los rectangulos
        TopPart.setWidth(bloq.ancho);
        SidePart.setWidth(bloq.ancho);
        Sense.setPrefWidth(bloq.ancho + 15);
        
        //la posicion del bloque
        Sense.setLayoutX(bloq.x);
        Sense.setLayoutY(bloq.y);
        
    }
    
    
    
    
    
    
}
