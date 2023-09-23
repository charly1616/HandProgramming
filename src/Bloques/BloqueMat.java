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

   public boolean PosibleConex() {
        Bloque bloqueIzquierdo = conectado != null ? conectado.conectador : null;
        Bloque bloqueDerecho = chorizontal != null && chorizontal.conexion != null ? chorizontal.conexion : null;
        
        if (bloqueIzquierdo instanceof BloqueValor || bloqueIzquierdo instanceof BloqueVariable) {
            if (bloqueDerecho instanceof BloqueValor || bloqueDerecho instanceof BloqueVariable) {
                return true;
            }
        }
      return false;
    }
   
}
