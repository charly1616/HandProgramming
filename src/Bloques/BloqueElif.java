
package Bloques;

import javafx.scene.paint.Color;


public class BloqueElif extends BloqueCondicional{
    
    public BloqueElif(double x, double y) {
        super(x, y, "Elif", Color.DARKCYAN.brighter());
    }
    
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
