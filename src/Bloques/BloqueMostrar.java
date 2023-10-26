package Bloques;

import Model.EvaluadorExpresiones;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author juand
 */
public class BloqueMostrar extends BloqueLabel {
    
    public BloqueMostrar(double x, double y) {
        super(x, y,  Color.rgb(255, 102, 128), "Mostrar");
    }
    
    /*
    Si hay una siguiente línea conectada (Siguiente() != null), se ejecuta el siguiente código
    Se utiliza para evaluar una expresión, mostrar su resultado en la consola.
    */
    @Override
    public void Hacer() {
        if (Siguiente() != null) {
            LineaEjecutador();
            JOptionPane.showMessageDialog(null,EvaluadorExpresiones.Expresion(Siguiente()));
    // chorizontal.conexion.setError(true);
        } else {
            System.out.println("Esta vacío");
        }
        
        //Ejecutar la siguiente linea
        super.Hacer();
    }
}
