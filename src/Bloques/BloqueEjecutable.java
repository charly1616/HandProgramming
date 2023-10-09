
package Bloques;

import Model.Bloque;
import java.util.ArrayList;
import javafx.scene.paint.Color;


public class BloqueEjecutable extends Bloque{
    public ArrayList<BloqueVariable> variables = new ArrayList<BloqueVariable>();
    
    
    public BloqueEjecutable(double x, double y) {
        super(x, y);

        Inconectableh = true;
    }

    /*
     Verifica si una variable con un nombre específico existe en la lista de variables 
    del objeto BloqueEjecutable y devuelve true si existe y false si no existe. 
    */
    public boolean esVariable(String nombre) {
        for (BloqueVariable variable : variables) {
            if (variable.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

 
    //permite obtener el valor de una variable específica buscándola por nombre en la lista de variables del objeto BloqueEjecutable
    public String getValor(BloqueVariable b) {
        for (BloqueVariable variable : variables) {
            if (variable.getNombre().equals(b.getNombre())) {
                return variable.getValor();
            }
        }
        return null;
    }
    
    
    /*
    permite establecer o modificar el valor de una variable específica en la lista de variables del objeto BloqueEjecutable.
    Si la variable con el mismo nombre ya existe en la lista
    Actualiza su valor; de lo contrario, agrega una nueva variable a la lista con el nombre y valor especificados
    */
    public void setValor(BloqueVariable b, String valor) {
        for (BloqueVariable variable : variables) {
            if (variable.getNombre().equals(b.getNombre())) {
                variable.setValor(valor);
            } else {
                b.setValor(valor);
                variables.add(b);
            }
        }
    }
    
    //Hasta ahora elimina todas las variables almacenadas en la lista variables de un objeto BloqueEjecutable
    public void vaciarVariables() {
        variables.clear();
        limpiarEjecutadores();
        
        //Ejecutar la siguiente linea
        if (SiguienteLinea()== null) ejecutador.vaciarVariables();
    }
    
    public void limpiarEjecutadores(){
    }
    
    
    
    
    /*
    realiza acciones relacionadas con la manipulación de variables y la ejecución de bloques condicionales. 
    El comportamiento exacto dependerá de la implementación de las clases y
    objetos específicos que utilizan esta función en el código completo.
    */
    @Override
    public void Hacer(){
        if (ejecutador.variables !=  null && ejecutador.variables != null) variables.addAll(ejecutador.variables);
        if (this instanceof BloqueCondicional) EjecutarHijos();
        
    }
    
    /*
     se utiliza para ejecutar los bloques hijos de un bloque condicional en ciertas condiciones.
    Verifica si existe una conexión (conexion) con un bloque hijo y, si es el caso,
    configura el objeto actual como el ejecutador del bloque hijo y ejecuta dicho bloque. 
    */
    public void EjecutarHijos(){
        if (this.cvertical.inner.conexion == null) return;
        this.cvertical.inner.conexion.ejecutador = this;
        this.cvertical.inner.conexion.Hacer();
    }
    
    
    
}
