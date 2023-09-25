
package Bloques;

import Model.Bloque;
import java.util.ArrayList;
import javafx.scene.paint.Color;


public class BloqueEjecutable extends Bloque{
    public ArrayList<BloqueVariable> variables = new ArrayList<BloqueVariable>();
    
    
    public BloqueEjecutable(double x, double y) {
        super(x, y);

        Inconectableh = true;
    }

    public boolean esVariable(String nombre) {
        for (BloqueVariable variable : variables) {
            if (variable.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public String getValor(BloqueVariable b) {
        for (BloqueVariable variable : variables) {
            if (variable.getNombre().equals(b.getNombre())) {
                return variable.getValor();
            }
        }
        return null;
    }
    
    
    
    public void setValor(BloqueVariable b, String valor) {
        for (BloqueVariable variable : variables) {
            if (variable.getNombre().equals(b.getNombre())) {
                variable.setValor(valor);
            } else {
                b.setValor(valor);
                variables.add(b);
            }
        }
    }
    
    
    public void vaciarVariables() {
        variables.clear();
    }

    
    //HACER
    public void EjecutarHijos(){
        
    }
    
    
    
}
