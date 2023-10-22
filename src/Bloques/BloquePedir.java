package Bloques;

import Model.Bloque;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane; // Importa la clase para mostrar el diálogo de entrada.

public class BloquePedir extends BloqueLabel {

    public BloquePedir(double x, double y) {
        super(x, y, Color.rgb(158, 160, 40),"Pedir");
        IniciarComponentes();
        Pintar();
    }

    @Override
    public void IniciarComponentes() {
        super.IniciarComponentes();
    }

    @Override
    public void Pintar() {
        super.Pintar();
    }
    
    
    @Override
    public void Hacer(){
        Bloque bloqueVariable =  Siguiente();
        // Validación para asegurarse de que se proporciona un BloqueVariable.
        if (bloqueVariable == null && !(bloqueVariable instanceof BloqueVariable)){
            this.ponerRojo(this);
            return;
        }
        capturarValor((BloqueVariable) bloqueVariable);
        super.Hacer();
    }
    
    
    public void capturarValor(BloqueVariable bloqueVariable) {
        // Utiliza JOptionPane para mostrar un cuadro de diálogo de entrada y capturar un valor.
        String valor = JOptionPane.showInputDialog("Ingrese un valor:");
        
        // Verifica si el usuario no canceló el diálogo.
        if (valor != null) {
            // Asigna el valor capturado al bloque variable.
            bloqueVariable.setValor(valor);
        }
    }
}
