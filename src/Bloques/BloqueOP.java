package Bloques;
import Model.Bloque;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Hands Programming
 */
public class BloqueOP extends Bloque {   
    
    public Label operaciones;

    public BloqueOP(double x, double y) {
        super(x, y, Color.BLANCHEDALMOND);
    }
    
    @Override
    public void IniciarComponentes(){
        super.IniciarComponentes();
        
        //Creando el Label
        operaciones = new Label("Op");
        
        //alineamiento del indicador
        operaciones.setAlignment(Pos.CENTER_RIGHT);
        
        //Posicion del label
        operaciones.setLayoutX(19);
        operaciones.setLayoutY(15);
        
        //tamaño del label
        operaciones.setPrefHeight(39); //altura
        operaciones.setPrefWidth(26); //ancho
        
        //Se coloca la fuente
        Font font = Font.font("Berlin Sans FB", FontWeight.BOLD, 21);
        operaciones.setFont(font);
   
        
        //Se muestra en el bloque
        getChildren().add(operaciones);
        
        setAncho(70);
    }
    
    
    public boolean PosibleConex() {
        Bloque bloqueIzquierdo = conectado != null ? conectado.conectador : null;
        Bloque bloqueDerecho = chorizontal != null && chorizontal.conexion != null ? chorizontal.conexion : null;
        
        if (bloqueIzquierdo instanceof BloqueValor || bloqueIzquierdo instanceof BloqueVariable) {
            if (bloqueDerecho instanceof BloqueValor || bloqueDerecho instanceof BloqueVariable) {
                return true;
            }
        }
      return false;
    }
    
    
}
