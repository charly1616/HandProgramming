
package Bloques;

import javafx.scene.paint.Color;

/**
 *
 * @author juand
 */
public class BloqueElse extends BloqueCondicional{
    
    public BloqueElse(double x, double y) {
        super(x, y, "Else", Color.rgb(50, 229, 205));
        
    }
    
    /*
     Se ejecutará si está conectado a un "Elif" o un "IF" en la estructura condicional y su 
    lógica se ejecutará como parte de esa rama condicional. 
    Si no cumple con esa condición, el método no realiza ninguna acción.
    */
    @Override
    public void Hacer(){
        if (conectado.conectador instanceof BloqueElif || conectado.conectador instanceof BloqueIF){
            super.Hacer();
        }
    }
    
}
