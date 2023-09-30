package Bloques;

import static Bloques.BloqueValor.GetType;
import static Bloques.BloqueValor.esNumero;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import Model.Bloque;
import javafx.scene.paint.Color;

public class BloqueMat extends BloqueOP {

    public BloqueMat(double x, double y, String signo) {
        super(x, y, signo, Color.PINK);
    }

    @Override
    public void IniciarComponentes() {
        super.IniciarComponentes();
    }

    @Override
    public boolean PosibleConex() {
        Bloque bloqueIzquierdo = conectado != null ? conectado.conectador : null;
        Bloque bloqueDerecho = chorizontal != null && chorizontal.conexion != null ? chorizontal.conexion : null;

        if ((bloqueIzquierdo instanceof BloqueValor || bloqueIzquierdo instanceof BloqueVariable) &&
         (bloqueDerecho instanceof BloqueValor || bloqueDerecho instanceof BloqueVariable)) {
            return true;
        }
        return false;
    }

    @Override
    public void Debug() {
        Bloque bloqueIzquierdo = conectado != null ? conectado.conectador : null;
        Bloque bloqueDerecho = chorizontal != null && chorizontal.conexion != null ? chorizontal.conexion : null;

        // Obtén los valores de los bloques izquierdo y derecho
        String valorIzquierdo = (bloqueIzquierdo).getValor();
        String valorDerecho = bloqueDerecho.getValor();

        
        boolean esNumeroIzquierdo = esNumero(valorIzquierdo);
        boolean esNumeroDerecho = esNumero(valorDerecho);

        // Si ambos valores son números, entonces usa GetType
        if (esNumeroIzquierdo && esNumeroDerecho) {
            String tipoIzquierdo = GetType(valorIzquierdo);
            String tipoDerecho = GetType(valorDerecho);
            System.out.println("Tipo Bloque Izquierdo: " + tipoIzquierdo);
            System.out.println("Tipo Bloque Derecho: " + tipoDerecho);
            
        } else if (!esNumeroDerecho ) {
            chorizontal.conexion.setError(true);
        }else if (!esNumeroIzquierdo) {
            conectado.conectador.setError(true);
        }else {
            chorizontal.conexion.setError(false);
            conectado.conectador.setError(false);
        }
    }

}
