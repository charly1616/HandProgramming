
package Bloques;

import javafx.scene.paint.Color;


public class BloqueValor extends BloqueTexto{
    
    
    
    
    public BloqueValor(double x, double y) {
        super(x, y, Color.YELLOW.brighter(), 300,250);
    }
    
    
    
    
    @Override
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
