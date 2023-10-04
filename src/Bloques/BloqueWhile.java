
package Bloques;

import javafx.scene.paint.Color;

/**
 *
 * @author juand
 */
public class BloqueWhile extends BloqueCondicional{
    
    public BloqueWhile(double x, double y) {
        super(x, y, "While", Color.BLUEVIOLET);
    }
    
      
    @Override
    public void Hacer(){
        if (Siguiente() != null && evaluarSiguiente()){
            super.Hacer();
            Hacer();
        }else {
            Siguiente().ejecutador = ejecutador;
            Siguiente().Hacer();
        }
    }
    
}
