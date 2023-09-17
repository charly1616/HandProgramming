
package Model;

import javafx.scene.paint.Color;


public class Bloque {
    
    public double TamBorde;
    
    public double ancho;
    
    public double x;
    public double y;
    
    public Color ColorBloque;
    public Color ColorBorde;

    //Constructor
    public Bloque(double x, double y, Color ColorBloque) {
        this.x = x;
        this.y = y;
        this.ColorBloque = ColorBloque;
        
        this.ColorBorde = Color.color(30/255.0, 30/255.0, 30/255.0);
        this.TamBorde = 4;
        this.ancho = 100;
    }
    
    
    
    
    
    
    
}
