
package Bloques;

import javafx.scene.paint.Color;


public class BloqueVariable extends BloqueTexto{

    public BloqueVariable(double x, double y) {
        super(x, y, Color.ORANGE, 250, 15);
    }
    
    @Override
    public void IniciarComponentes(){
        super.IniciarComponentes();
        
        indicador.setText("Var");
        valor.setPromptText("Var");
    }
    
    
    
    @Override
    public void TypeVariable(){
    }
    
}
