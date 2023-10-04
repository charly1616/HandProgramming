
package Bloques;

import javafx.scene.paint.Color;

/**
 *
 * @author juand
 */
public class BloqueElse extends BloqueCondicional{
    
    public BloqueElse(double x, double y) {
        super(x, y, "Else", Color.DARKSLATEBLUE);
        
    }
    
    @Override
    public void Hacer(){
        if (conectado.conectador instanceof BloqueElif || conectado.conectador instanceof BloqueIF){
            super.Hacer();
        }
    }
    
}
