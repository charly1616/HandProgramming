
package Bloques;

import Model.ConectorMultiple;
import javafx.scene.paint.Color;


public class BloqueCondicional extends BloqueLabel{
    
    public BloqueCondicional(double x, double y, String Text) {
        super(x, y, Color.DARKCYAN, Text);
    }
    
    @Override
    public void IniciarComponentes(){
        cvertical = new ConectorMultiple(this);
    }
    
    
    
    
    
    
    
}
