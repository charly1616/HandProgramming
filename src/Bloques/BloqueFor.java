
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
        
        
        //Primer caso solo un numero
        if (EvaluadorExpresiones.InstBloqueValor(sig(1)) && BloqueValor.GetType(sig(1).getValor()).equals("Num") && sig(2) == null){
            for (int i = 0; i < entero(sig(1)); i++) {
                System.out.println(entero(sig(1)));
                this.EjecutarHijos();
            }
        }
        
        
        //Segundo caso
        if (sig(1) instanceof BloqueVariable && EvaluadorExpresiones.InstBloqueValor(sig(2)) 
                && BloqueValor.GetType(sig(2).getValor()).equals("Num") 
                && sig(3) == null){
            
            int cambio = (int)entero(sig(2));
            cambio = Integer.signum(cambio);
            for (ejecutador.setValor((BloqueVariable)sig(1), "0"); entero(sig(1)) * cambio < entero(sig(2)) * cambio ; ejecutador.setValor((BloqueVariable)sig(1), (entero(sig(1))+cambio) + "")) {
                System.out.println(entero(sig(1)));
                if (ejecutador.variables !=  null) variables.putAll(ejecutador.variables);
                this.EjecutarHijos();
            }
            ejecutador.deleteValor((BloqueVariable)sig(1));
        }
        
        
        //Tercer caso
        if (sig(1) instanceof BloqueVariable && EvaluadorExpresiones.InstBloqueValor(sig(2)) && EvaluadorExpresiones.InstBloqueValor(sig(3)) 
                && BloqueValor.GetType(sig(2).getValor()).equals("Num") && BloqueValor.GetType(sig(3).getValor()).equals("Num") 
                && sig(4) == null){
            
            int cambio = (int)(entero(sig(3)) - entero(sig(2)));
            cambio = Integer.signum(cambio);
            for (ejecutador.setValor((BloqueVariable)sig(1), sig(2).getValor()); entero(sig(1)) * cambio < entero(sig(3)) * cambio ; ejecutador.setValor((BloqueVariable)sig(1), (entero(sig(1))+cambio) + "")) {
                System.out.println(entero(sig(1)));
                if (ejecutador.variables !=  null) variables.putAll(ejecutador.variables);
                this.EjecutarHijos();
            }
            ejecutador.deleteValor((BloqueVariable)sig(1));
        }
        
        
        //cuarto caso
        if (sig(1) instanceof BloqueVariable && EvaluadorExpresiones.InstBloqueValor(sig(2)) && EvaluadorExpresiones.InstBloqueValor(sig(3)) && EvaluadorExpresiones.InstBloqueValor(sig(4))
                && BloqueValor.GetType(sig(2).getValor()).equals("Num") && BloqueValor.GetType(sig(3).getValor()).equals("Num") && BloqueValor.GetType(sig(4).getValor()).equals("Num")){
            
            int cambio = (int)(entero(sig(3)) - entero(sig(2)));
            cambio = Integer.signum(cambio);
            cambio *= Math.abs(entero(sig(4)));
            
            for (ejecutador.setValor((BloqueVariable)sig(1), sig(2).getValor()); entero(sig(1)) * cambio < entero(sig(3)) * cambio ; ejecutador.setValor((BloqueVariable)sig(1), (entero(sig(1))+cambio) + "")) {
                System.out.println(entero(sig(1)));
                if (ejecutador.variables !=  null) variables.putAll(ejecutador.variables);
                this.EjecutarHijos();
            }
            ejecutador.deleteValor((BloqueVariable)sig(1));
        }
        
        
        super.vaciarVariables();
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
    
    public double entero(Bloque n){
        return Double.parseDouble(n.getValor());
    }
    
    
    
}
