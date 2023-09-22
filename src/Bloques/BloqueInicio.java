
package Bloques;

import Model.Bloque;
import javafx.scene.paint.Color;


public class BloqueInicio extends Bloque{

    public BloqueInicio(double x, double y) {
        super(x,y);
        this.ColorBloque = Color.color(86, 255, 114);
        this.ancho = 160;
        chorizontal.Desactivar();
        cvertical.offX = 60;
    }
    
    
    
    
}
