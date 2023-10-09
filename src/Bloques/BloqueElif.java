
package Bloques;

import javafx.scene.paint.Color;


public class BloqueElif extends BloqueCondicional{
    
    public BloqueElif(double x, double y) {
        super(x, y, "Elif", Color.DARKCYAN.brighter());
    }
    
    
    /*
    No recibe nada y devuelve null
    Primero controla que este conectado a un bloque if o un bloque elif
    Si no se cumple la condición anterior, se verifica si existe un bloque siguiente (Siguiente())
    y se evalúa si la condición (evaluarSiguiente()) asociada a ese bloque es verdadera
    Si la condición del paso 2 es falsa, se verifica si el bloque siguiente (SiguienteLinea()) es un bloque BloqueElse/BloqueElif.
    Si es alguno de estos dos casos, se llama al método Hacer() de ese bloque
    */
    @Override
    public void Hacer(){
        if (this.conectadov.conectador instanceof BloqueIF || this.conectadov.conectador instanceof BloqueElif);
        else {
            if (SiguienteLinea() != null && SiguienteLinea().SiguienteLinea()!= null) SiguienteLinea().SiguienteLinea().Hacer();
            return;
        }
        
        if (Siguiente() != null && evaluarSiguiente()){
            super.Hacer();
        } else if (SiguienteLinea() instanceof BloqueElse || SiguienteLinea() instanceof BloqueElif){
            SiguienteLinea().Hacer();
        } else {
            if (SiguienteLinea() != null && SiguienteLinea().SiguienteLinea()!= null) SiguienteLinea().SiguienteLinea().Hacer();
        }
        
    }
    
}
