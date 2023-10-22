package Bloques;

import Model.Bloque;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane; // Importa la clase para mostrar el diálogo de entrada.

public class BloquePedir extends Bloque {
    private BloqueVariable bloqueVariable;

    public BloquePedir(double x, double y, BloqueVariable bloqueVariable) {
        super(x, y);
        
        // Validación para asegurarse de que se proporciona un BloqueVariable.
        if (bloqueVariable == null) {
            throw new IllegalArgumentException("Se requiere un BloqueVariable.");
        }
        
        this.bloqueVariable = bloqueVariable;
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

    public void capturarValor() {
        // Utiliza JOptionPane para mostrar un cuadro de diálogo de entrada y capturar un valor.
        String valor = JOptionPane.showInputDialog("Ingrese un valor:");
        
        // Verifica si el usuario no canceló el diálogo.
        if (valor != null) {
            // Asigna el valor capturado al bloque variable.
            bloqueVariable.setValor(valor);
        }
    }
}
