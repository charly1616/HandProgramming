
package Bloques;

import Model.Bloque;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;


public class BloqueLabel extends Bloque{
    public Label label;
    
    public BloqueLabel(double x, double y, Color ColorBloque) {
        super(x, y, ColorBloque);
    }
    
    
    //AJUSTAR FUNCION
    @Override
    public void IniciarComponentes(){
        super.IniciarComponentes();
        
        //Creando el Label
        label = new Label("Inicio");
        
        //Posicion del label
        label.setLayoutX(62.0);
        label.setLayoutY(15.0);
        
        //tamaño del label
        label.setPrefHeight(40.0); //altura
        label.setPrefWidth(94.0); //ancho
        
        //Se coloca la fuente
        Font font = new Font("Berlin Sans FB",35);
        label.setFont(font);
        
        //Se muestra en el bloque
        getChildren().add(label);

    }
    
    
}
