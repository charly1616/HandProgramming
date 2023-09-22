
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
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;


public class BloqueInicio extends Bloque{
    
    public Label label;
    public Button boton;
    public Polyline tri;
    
    
    
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
        
        // Creando el botón
        boton = new Button ();
        
        //Posicion del botón
        boton.setLayoutX(25.0);
        boton.setLayoutY(15.0);
        
         //tamaño del botón 
        boton.setPrefHeight(40.0); //altura
        boton.setPrefWidth(36.0); //ancho
        
        // transparencia 
        boton.setMnemonicParsing(false);
        
        //
        boton.setOpacity(0.0);
        
        getChildren().add(boton);
        // creando el triangulo
        tri = new Polyline();
        
         //Posicion del triangulo
        tri.setLayoutX(49.0);
        tri.setLayoutY(34.0);
        
        //
        tri.setFill(Color.LIME);
        //tri.points();
      
        tri.getPoints().addAll(-18.0, 16.0, -18.0, -13.0, 6.0, 2.0, -18.0, 16.0);
        tri.setStroke(Color.valueOf("#2c2c2c") );
        tri.setStrokeType(StrokeType.INSIDE);
        tri.setStrokeWidth(5.0);
        
        getChildren().add(tri);

        
        
    }
       
}
