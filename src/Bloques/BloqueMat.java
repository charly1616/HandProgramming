package Bloques;



import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import Model.Bloque;
/**
 *
 * @author hp
 */
public class BloqueMat extends BloqueOP{
    
    
    
    public BloqueMat(double x, double y, String signo) {
        super(x, y);
        operaciones.setText("X");
    }
    
     @Override
    public void IniciarComponentes() {
        super.IniciarComponentes();
        
    }
   
    
    
    
}
