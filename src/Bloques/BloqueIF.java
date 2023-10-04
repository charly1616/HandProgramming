
package Bloques;

import Model.EvaluadorExpresiones;
import javafx.scene.paint.Color;

public class BloqueIF extends BloqueCondicional{
    
    public BloqueIF(double x, double y) {
        super(x, y, "If", Color.SKYBLUE);
    }
    
    
    @Override
    public void Hacer(){
        if (Siguiente() != null && evaluarSiguiente()){
            super.Hacer();
        } else if (SiguienteLinea() instanceof BloqueElse || SiguienteLinea() instanceof BloqueElif){
            System.out.println("SIPPPP");
            SiguienteLinea().ejecutador = ejecutador;
            SiguienteLinea().Hacer();
        } else {
            if (SiguienteLinea() != null && SiguienteLinea().SiguienteLinea()!= null) SiguienteLinea().SiguienteLinea().Hacer();
        }
        
        
    }
    
    
}
