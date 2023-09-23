
package Bloques;

import javafx.scene.paint.Color;


public class BloqueValor extends BloqueTexto{
    
    
    
    
    public BloqueValor(double x, double y) {
        super(x, y, Color.YELLOW.brighter(), 300,250);
    }
    
    
    
    
    @Override
    public void TypeVariable(){
        indicador.setText(GetType(valor.getText()));
    }
    
    
    public String GetType(String valor) {
        String type = "";
        if (valor.equals("")) {
            type = "Non";
        } else if (esNumero(valor)) {
            type = "Num";
        } else if (valor.equalsIgnoreCase("true") || valor.equalsIgnoreCase("false")) {
            type = "Bol";
        } else {
            type = "Str";
        }
        return type;
    }

  
  
    public boolean esNumero(String n) {
        try {
            double b = Double.parseDouble(n);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
   
    
}
