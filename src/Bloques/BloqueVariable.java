
package Bloques;

import javafx.scene.paint.Color;


public class BloqueVariable extends BloqueTexto{
    
    
    public String valorVariable;
    
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
    
    public String getValor(){
        return valorVariable;
    }
    
    public void setValor(){
        
    }
    
    public String encontrarValor(){
        return "Non";
    }
    
    
    
    @Override
    public void TypeVariable(){
        valorVariable = valor.getText();
    }
    
}
