
package Bloques;

import javafx.scene.paint.Color;


public class BloqueVariable extends BloqueTexto{
    
    public BloqueInicio inicio;
    
    
    public BloqueVariable(double x, double y) {
        super(x, y, Color.ORANGE, 250, 15);
    }
    
    @Override
    public void IniciarComponentes(){
        super.IniciarComponentes();
        
        indicador.setText("Var");
        valor.setPromptText("Var");
    }
    
    
    public String getNombre(){
        return valor.getText();
    }
    
    
    @Override
    public void TypeVariable(){
    }
    
}
