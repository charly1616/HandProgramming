
package Model;

import Bloques.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        String other = "";
        
        
        
        while (Actual != null){
            //Se obtiene el valor
            exA += Actual.getValor();
            lvalue = BloqueValor.GetType(Actual.getValor());
            
            //Si no hay mas bloques o el siguiente bloque es otro valor, termina ahí
            if (Actual.chorizontal.conexion == null) break;
            
            if ((BloqueValor.GetType(Actual.getValor()).equals("Str"))){
                other += Expresion(Actual.chorizontal.conexion);
                break;
            }
            
            if (InstBloqueValor(Actual.chorizontal.conexion) && (BloqueValor.GetType(Actual.chorizontal.conexion.getValor()).equals("Str"))){
                other += Expresion(Actual.chorizontal.conexion);
                break;
            }
            
            //Si el bloque que está conectado al anterior no es Operacion, error
            if (!(Actual.chorizontal.conexion instanceof BloqueOP)) return "";
            
            exA += Actual.chorizontal.conexion.getValor();
            Actual = Actual.chorizontal.conexion.chorizontal.conexion;
            //Si el bloque actual, osea el que se acaba de conectar no tiene valor, error
            if (!(InstBloqueValor(Actual))) return "";
        }
        
        return EvLog(exA) + other;
    }
    
    
    
    public static String EvLog(String ev){
        
        String [] Sep = ev.split("&|or");
        String [] separators = {};
        
        if (Sep.length == 1){
            return EvLogMat(Sep[0]);
        }
        return "";
    }
    
    
    public static String EvLogMat(String ev){
        String [] Sep = ev.split(">|<|=|!=|<=|>=");
        String [] separators = {};
        if (Sep.length == 1){
            return EvMatSum(Sep[0]);
        }
        return "";
    }
    
    
    public static String EvMatSum(String ev){
        String [] Sep = ev.split("\\+|\\-");
        String [] separators = {};
        if (Sep.length == 1){
            return EvMatMult(Sep[0]);
        }
        return "";
    }
    
    
    public static String EvMatMult(String ev){
        String [] Sep = ev.split("\\*|\\/|\\%");
        String [] separators = {};
        if (Sep.length == 1){
            return EvMatPot(Sep[0]);
        }
        return "";
    }
    
    
    
    
    public static String EvMatPot(String ev){
        String [] Sep = ev.split("\\^");
        if (Sep.length == 1){
            return ev;
        }
        
        try {
            double x = Double.parseDouble(Sep[0]);
            for (int i = 1; i < Sep.length; i++) {
                double x2 = Double.parseDouble(Sep[i]);
                x = Math.pow(x, x2);
            }
            return x+"";
        }catch (Exception e){
            
        }
        
        return "";
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
