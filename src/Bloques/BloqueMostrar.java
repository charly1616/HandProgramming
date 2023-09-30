
package Bloques;

import Model.EvaluadorExpresiones;
import javafx.scene.paint.Color;

/**
 *
 * @author juand
 */
public class BloqueMostrar extends BloqueLabel{
    
    public BloqueMostrar(double x, double y) {
        super(x, y,Color.AQUA,"Mostrar");
    }
    
    @Override
    public void Hacer() {
        if (chorizontal.conexion != null) {
            System.out.println(EvaluadorExpresiones.Expresion(chorizontal.conexion));
            chorizontal.conexion.setError(true);
        } else {
            System.out.println("Esta vacio");
        }
    }

}
