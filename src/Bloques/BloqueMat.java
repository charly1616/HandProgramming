package Bloques;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import Model.Bloque;
/**
 *
 * @author hp
 */
public class BloqueMat extends BloqueOP{

    public BloqueMat(double x, double y, String signo) {
        super(x, y);
        operaciones.setText(signo);
    }
    
     @Override
    public void IniciarComponentes() {
        super.IniciarComponentes();
        
    }

    public boolean esOperacionPosible() {
        // Verifica si es posible realizar la operación
        if (operaciones.getText().equals("+")) {
            Bloque bloqueIzquierdo = conectado != null ? conectado.conectador : null;
            Bloque bloqueDerecho = chorizontal != null && chorizontal.conexion != null ? chorizontal.conexion : null;
        }
        
        // Por defecto, no es posible realizar la operación
        return false;
    }
   

   
}
