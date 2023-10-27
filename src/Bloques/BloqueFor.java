
package Bloques;

import Model.Bloque;
import Model.EvaluadorExpresiones;
import javafx.scene.paint.Color;


public class BloqueFor extends BloqueCondicional{
    
    public BloqueFor(double x, double y) {
        super(x, y, "For", Color.rgb(226, 100, 59));
    }
    
    @Override
    public void Hacer(){
        this.LineaEjecutador();
        if (sig(1) == null) super.Hacer();
        
        if (EvaluadorExpresiones.InstBloqueValor(sig(1)) && BloqueValor.GetType(sig(1).getValor()).equals("Num") && sig(2) == null){
            for (int i = 0; i < entero(sig(1)); i++) {
                System.out.println(entero(sig(1)));
                this.EjecutarHijos();
            }
        }
        
        
//        if (sig(1) instanceof BloqueVariable && EvaluadorExpresiones.InstBloqueValor(sig(2)) 
//                && BloqueValor.GetType(sig(2).getValor()).equals("Num") 
//                && sig(3) == null){
//            int cambio = entero(sig(2));
//            cambio = Integer.signum(cambio);
//            for (this.ejecutador.setValor((BloqueVariable)sig(1), "0"); entero(sig(1)) < entero(sig(2)) * cambio ; this.setValor((BloqueVariable)sig(1), (entero(sig(1))+cambio) + "")) {
//                
//            }
//        }
        
        
        super.Hacer();
    }
    
    @Override
    public void vaciarVariables() {
        variables.clear();
        limpiarEjecutadores();
        
        //Ejecutar la siguiente linea
    }
    
    
    
    public Bloque sig(int n){
        Bloque ac = this;
        for (int i = 0; i < n; i++) {
            ac = ac.Siguiente();
        }
        return ac;
    }
    
    public int entero(Bloque n){
        return Integer.parseInt(n.getValor());
    }
    
}
