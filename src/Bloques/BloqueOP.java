package Bloques;
import Model.Bloque;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 *
 * @author Hands Programming
 */
public class BloqueOP extends Bloque {   
    
    public Label operaciones;

    public BloqueOP(double x, double y) {
        super(x, y, Color.BLANCHEDALMOND);
    }
    
    @Override
    public void IniciarComponentes(){
        super.IniciarComponentes();
        
        //Creando el Label
        operaciones = new Label("op");
        
        //alineamiento del indicador
        operaciones.setAlignment(Pos.CENTER_RIGHT);
        
        //Posicion del label
        operaciones.setLayoutX(19);
        operaciones.setLayoutY(15);
        
        //tamaño del label
        operaciones.setPrefHeight(39); //altura
        operaciones.setPrefWidth(26); //ancho
        
        //Se coloca la fuente
        Font font = new Font("Berlin Sans FB",14);
        operaciones.setFont(font);
   
        
        //Se muestra en el bloque
        getChildren().add(operaciones);
        
        setAncho(70);
    }
    
    
    
}
