
package Bloques;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import Model.Bloque;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;


public class BloqueInicio extends Bloque{
    
    public Label label;
    public Button boton;
    public Polyline triangulo;
    
    
    
    public BloqueInicio(double x, double y) {
        super(x,y);
        this.ColorBloque = Color.rgb(86, 255, 114);
        this.ancho = 160;
        
        IniciarComponentes();
        Pintar();
        chorizontal.Desactivar();
        cvertical.offX = 60;
    }
    
    @Override
    public void IniciarComponentes(){
        super.IniciarComponentes();
        
        //Creando el Label
        label = new Label("Inicio");
        
        //Posicion del label
        label.setLayoutX(0);
        label.setLayoutY(0);
        
        //tamaño del label
        label.setPrefHeight(50); //altura
        label.setPrefWidth(100); //ancho
        
        //Se coloca la fuente
        Font font = new Font("Berlin Sans FB",35);
        label.setFont(font);
        
        //Se muestra en el bloque
        getChildren().add(label);
        
    }
    
    
}
