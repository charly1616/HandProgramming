
package Bloques;

import Model.Bloque;
import java.util.HashSet;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public abstract class BloqueTexto extends Bloque{
    public Label indicador;
    public TextField valor;
    
    public int Limite;
    
    public int LetrasMax;
    
    
    public BloqueTexto(double x, double y, Color ColorBloque, int Limite, int LetrasMax) {
        super(x, y, ColorBloque);
        this.Limite = Limite;
        this.LetrasMax = LetrasMax;
    }
    
    
    
    @Override
    public void IniciarComponentes(){
        super.IniciarComponentes();
        
        //Creando el Label
        indicador = new Label("Str");
        
        //alineamiento del indicador
        indicador.setAlignment(Pos.CENTER_RIGHT);
        
        //Posicion del label
        indicador.setLayoutX(22);
        indicador.setLayoutY(15);
        
        //tamaño del label
        indicador.setPrefHeight(39); //altura
        indicador.setPrefWidth(26); //ancho
        
        //Se coloca la fuente
        Font font = new Font("Berlin Sans FB",14);
        indicador.setFont(font);
        
        
        
        
        
        
        valor = new TextField();
        
        valor.setPromptText("Dato");
        
        //Posicion del label
        valor.setLayoutX(43);
        valor.setLayoutY(16);
        
        //tamaño del label
        valor.setPrefHeight(22); //altura
        valor.setPrefWidth(77); //ancho
        
        //FUENTE
        font = new Font("Berlin Sans FB",22);
        valor.setFont(font);
        
        
        valor.setStyle("-fx-text-fill: "+toHex(ColorBorde).toLowerCase()+
                "; -fx-prompt-text-fill: "+toHex(ColorBorde).toLowerCase()+
                "; -fx-background-color: "+toHex(ColorBloque).toLowerCase()+
                "; -fx-alignment: BOTTOM_CENTER;");
        
        valor.textProperty().addListener((ObservableValue<? extends String> observable, String valorviejo, String valornuevo) -> {
            
            if (valornuevo.length()>this.LetrasMax ){
                valor.setText(valorviejo);
            }
            double textWidth = computeTextWidth(valor.getFont(), valornuevo);
            
            if (textWidth + 30 > Limite+77){
            }
            else if (textWidth + 30 > 77){
                valor.setPrefWidth(textWidth + 30);
                setAncho(textWidth + 75);
            } else {
                valor.setPrefWidth(77);
                setAncho(77 + 45);
            }
            TypeVariable();
        });
        
        
        getChildren().add(valor);
        //Se muestra en el bloque
        getChildren().add(indicador);
        
        setAncho(130);
    }
    
    public abstract void TypeVariable();
    
    
    public static String toHex(Color color) {
        int r = (int) (color.getRed() * 255);
        int g = (int) (color.getGreen() * 255);
        int b = (int) (color.getBlue() * 255);

        return String.format("#%02X%02X%02X", r, g, b);
    }
     private double computeTextWidth(javafx.scene.text.Font font, String text) {
        javafx.scene.text.Text textNode = new javafx.scene.text.Text(text);
        textNode.setFont(font);
        return textNode.getBoundsInLocal().getWidth();
    }
    
}
