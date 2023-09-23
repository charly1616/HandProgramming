
package Bloques;

import javafx.scene.paint.Color;


public class BloqueValor extends BloqueTexto{
    
    
    
    
    public BloqueValor(double x, double y) {
        super(x, y, Color.YELLOW.brighter(), 300,50);
    }
    
    
    
    
    public void TypeVariable(){
        String type = "";
        if (valor.getText().equals("")){
            type = "Non";
        } else if (esNumero(valor.getText())){
            type = "Num";
        } else if (valor.getText().toLowerCase().equals("true") || valor.getText().toLowerCase().equals("false")){
            type = "Bol";
        } else {
            type = "Str";
        }
        indicador.setText(type);
    }
    
    
    public boolean esNumero(String n){
        try {
            double b = Double.parseDouble(n);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    
    
}
