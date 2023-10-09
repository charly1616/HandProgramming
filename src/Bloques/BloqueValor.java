
package Bloques;

import javafx.scene.paint.Color;


public class BloqueValor extends BloqueTexto{
    
    
    
    
    public BloqueValor(double x, double y) {
        super(x, y, Color.YELLOW.brighter(), 300,250);
    }
    
    
    
    //Establece el texto del componente indicador utilizando el resultado del método 
    @Override
    public void TypeVariable(){
        indicador.setText(GetType(valor.getText()));
    }
    
    //Retorna el texto contenido en el componente valor.
    @Override
    public String getValor(){
        return valor.getText();
    }
    
    
    
    /*
    Recibe una cadena de texto valor como argumento y determina el tipo de esa variable.
    Si la cadena está vacía, se establece type como "Non" (para "No definido").
    Si la cadena puede ser convertida a un número (mediante el método esNumero), se establece type como "Num" (para "Número").
    Si la cadena es "true" o "false" (ignorando mayúsculas/minúsculas), se establece type como "Bol" (para "Booleano").
    En otros casos, se establece type como "Str" (para "Cadena de texto").
    Finalmente, se devuelve el tipo determinado.
    */
    public static String GetType(String valor) {
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

  
     /*
     Recibe una cadena de texto n como argumento y verifica si esta cadena puede ser convertida a un número(Double)
     Si retorna false significa que "n" no es numerico.
    */
    public static boolean esNumero(String n) {
        try {
            double b = Double.parseDouble(n);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
   
    
}
