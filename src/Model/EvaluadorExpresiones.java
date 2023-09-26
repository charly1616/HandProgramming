
package Model;

import Bloques.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvaluadorExpresiones {
    
    
    
    
    public static String Expresion(Bloque inicial){
        
        
        if (!(InstBloqueValor(inicial))) return "";
        
        Bloque Actual = inicial;
        String lconexion = "";
        String lvalue = "";
        String exA = "";
        
        while (Actual != null){
            //Se obtiene el valor
            exA += Actual.getValor();
            lvalue = BloqueValor.GetType(Actual.getValor());
            
            //Si no hay mas bloques o el siguiente bloque es otro valor, termina ahí
            if (Actual.chorizontal.conexion == null) break;
            if (InstBloqueValor(Actual.chorizontal.conexion)) break;
            
            //Si el bloque que está conectado al anterior no es Operacion, error
            if (!(Actual.chorizontal.conexion instanceof BloqueOP)) return "";
            
            exA += Actual.chorizontal.conexion.getValor();
            Actual = Actual.chorizontal.conexion.chorizontal.conexion;
            //Si el bloque actual, osea el que se acaba de conectar no tiene valor, error
            if (!(InstBloqueValor(Actual))) return "";
        }
        
        return exA;
    }
    
    
    public static boolean OpCorrecta(Bloque b, String tipovalor){
        if (b instanceof BloqueLogico) return true;
        
        if (b instanceof BloqueLMat && b.getValor().equals("=") && tipovalor.equals("str")) return true;
        else if (b instanceof BloqueLMat && !tipovalor.equals("num"))  return false;
        
        if (b instanceof BloqueMat && b.getValor().equals("+") && tipovalor.equals("str")) return true;
        else if (b instanceof BloqueMat && !tipovalor.equals("num"))  return false;
        
        return false;
    }
    
    
    
    public static boolean InstBloqueValor(Bloque b){
        return (b instanceof BloqueValor || b instanceof BloqueVariable);
    }
    
    
}
