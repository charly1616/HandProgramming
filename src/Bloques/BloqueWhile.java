
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
    
      /*
     Implementa un bucle "while" que ejecuta su contenido repetidamente mientras una cierta condición sea verdadera
     Luego continúa con la ejecución del código después del bucle cuando la condición se vuelve falsa.
    */
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
