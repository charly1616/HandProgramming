
package Bloques;

import javafx.scene.paint.Color;

/**
 *
 * @author juand
 */
public class BloqueWhile extends BloqueCondicional{
    
    public BloqueWhile(double x, double y) {
        super(x, y, "While", Color.rgb(147, 120, 201));
    }
    
    
    //Hasta ahora elimina todas las variables almacenadas en la lista variables de un objeto BloqueEjecutable
    @Override
    public void vaciarVariables() {
        variables.clear();
        limpiarEjecutadores();
        
        //Ejecutar la siguiente linea
        if (Siguiente() != null && evaluarSiguiente()){
            Hacer();
        } else {
            super.Hacer();
        }
    }
    
    
    
    
      /*
     Implementa un bucle "while" que ejecuta su contenido repetidamente mientras una cierta condición sea verdadera
     Luego continúa con la ejecución del código después del bucle cuando la condición se vuelve falsa.
    */
    @Override
    public void Hacer(){
        EjecutarHijos();
    }
    
}
