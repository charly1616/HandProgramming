
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
                exA =  exA;
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
        String[] separadores = new String[Sep.length - 1];
        
        for (int i = 0; i < Sep.length; i++) {
            if (i < Sep.length - 1) {
                separadores[i] = ev.substring(Sep[i].length(), Sep[i].length() + 2);
            }
        }
        
        if (Sep.length == 1){
            return EvLogMat(Sep[0]);
        }
        return "";
    }
    
    
    public static String EvLogMat(String ev){
        String [] Sep = ev.split(">|<|=|!=|<=|>=");
        String[] separadores = new String[Sep.length - 1];
        
        int u = 0;
        for (int i = 0; i < ev.length(); i++) {
            switch (ev.charAt(i)){
                case '>' -> {
                    if (i+1 < ev.length() && ev.charAt(i+1) == '='){
                        separadores[u] = ev.charAt(i)+"=";
                        u++;
                    } else {
                        separadores[u] = ev.charAt(i)+"";
                        u++;
                    }
                    break;
                }
                case '<' -> {
                    if (i+1 < ev.length() && ev.charAt(i+1) == '='){
                        separadores[u] = ev.charAt(i)+"=";
                        u++;
                    } else {
                        separadores[u] = ev.charAt(i)+"";
                        u++;
                    }
                    break;
                }
                case '!' -> {
                    if (i+1 < ev.length() && ev.charAt(i+1) == '='){
                        separadores[u] = ev.charAt(i)+"=";
                        u++;
                    }
                    break;
                }
                case '=' -> {
                    separadores[u] = ev.charAt(i)+"";
                    u++;
                    break;
                }
                
            }
        }
        if (Sep.length == 1){
            return EvMatSum(Sep[0]);
        }
        
        
        try {
            double x = Double.parseDouble(EvMatSum(Sep[0]));
            for (int i = 1; i < Sep.length; i++) {
                double x2 = Double.parseDouble(EvMatMult(Sep[i]));
                switch (separadores[i - 1]) {
                    case "=" -> {
                        x = x + x2;
                        break;
                    }
                    case "!=" -> {
                        x = x - x2;
                        break;
                    }
                }
            }
            return x+"";
        }catch (Exception e){
            
        }
        
        
        return "";
    }
    
    
    public static String EvMatSum(String ev){
        String [] Sep = ev.split("\\+|\\-");
        String[] separadores = new String[Sep.length - 1];
        
        int u = 0;
        for (int i = 0; i < ev.length(); i++) {
            if (ev.charAt(i) == '+'||ev.charAt(i) == '-'){
                separadores[u] = ev.charAt(i)+"";
                u++;
            }
        }
        
        if (Sep.length == 1){
            return EvMatMult(Sep[0]);
        }
        
        
        try {
            double x = Double.parseDouble(EvMatMult(Sep[0]));
            for (int i = 1; i < Sep.length; i++) {
                double x2 = Double.parseDouble(EvMatMult(Sep[i]));
                switch (separadores[i - 1]) {
                    case "+" -> {
                        x = x + x2;
                        break;
                    }
                    case "-" -> {
                        x = x - x2;
                        break;
                    }
                }
            }
            return x+"";
        }catch (Exception e){
            
        }
        
        
        return "";
    }
    
    
    public static String EvMatMult(String ev){
        if (ev.equals("")) return"";
        String [] Sep = ev.split("x|\\/|\\%");
        String[] separadores = new String[Sep.length - 1];
        
        int u = 0;
        for (int i = 0; i < ev.length(); i++) {
            if (ev.charAt(i) == 'x'||ev.charAt(i) == '/'||ev.charAt(i) == '%'){
                separadores[u] = ev.charAt(i)+"";
                u++;
            }
        }
        if (Sep.length == 1){
            return EvMatPot(Sep[0]);
        }
        
        try {
            double x = Double.parseDouble(EvMatPot(Sep[0]));
            for (int i = 1; i < Sep.length; i++) {
                double x2 = Double.parseDouble(EvMatPot(Sep[i]));
                switch (separadores[i - 1]) {
                    case "x" -> {
                        x = x * x2;
                        break;
                    }
                    case "/" -> {
                        x = x / x2;
                        break;
                    }
                    case "%" -> {
                        x = x % x2;
                        break;
                    }
                }

                
            }
            return x+"";
        }catch (Exception e){
            
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
            System.out.println("Errorcito");
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
    
    
    public static boolean MatExpresion(String s){
        char [] chars = {'1','2','3','4','5','6','7','8','9','0','+','-','x','/','%','^'};
        
        
        for (int i = 0; i < s.length(); i++) {
            boolean f = false;
            for (char u : chars){
                if (s.charAt(i) == u){
                    f = true;
                    break;
                }
            }
            if (!f) return false;
        }
        
        return true;
    }
    
    
}
