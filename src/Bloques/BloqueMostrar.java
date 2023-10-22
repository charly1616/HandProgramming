package Bloques;

import Model.EvaluadorExpresiones;
import javafx.scene.paint.Color;

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
            System.out.println(EvaluadorExpresiones.Expresion(Siguiente()));
    // chorizontal.conexion.setError(true);
        } else {
            System.out.println("Esta vacío");
        }
        
        //Ejecutar la siguiente linea
        if (SiguienteLinea()!= null) Siguiente().Hacer();
        else if (ejecutador != null){
            ejecutador.vaciarVariables();
        }
    }
}
