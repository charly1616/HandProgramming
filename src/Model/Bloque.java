
package Model;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public final class Bloque extends Pane{
    
    
    //Componentes
    public Rectangle SidePart;
    public Rectangle TopPart;
    
    //Constantes
    public static final int ALTO = 0;
    
    
    //Propiedades
    public double TamBorde;
    public double ancho;
    
    public double x;
    public double y;
    
    public Color ColorBloque;
    public Color ColorBorde;
    
    
    public double mouseAnchorX;
    public double mouseAnchorY;
    
    
    //Constructor
    public Bloque(double x, double y, Color ColorBloque) {
        this.x = x;
        this.y = y;
        this.ColorBloque = ColorBloque;
        
        this.ColorBorde = Color.color(0, 0, 0);
        this.TamBorde = 4;
        this.ancho = 100+ Math.random()*50;
        
        
        IniciarComponentes();
        Pintar();
        hacerMovible();
    }
    
    
    public void IniciarComponentes(){
        SidePart = new Rectangle();
        TopPart = new Rectangle();
        
        //Redondeado
        SidePart.setArcHeight(30);
        SidePart.setArcWidth(30);
        TopPart.setArcHeight(30);
        TopPart.setArcWidth(30);
        
        //Liso
        SidePart.setSmooth(true);
        TopPart.setSmooth(true);
        
        //Posicion de los recs
        TopPart.setLayoutX(7);
        TopPart.setLayoutY(7);
        TopPart.setHeight(56);
        
        SidePart.setLayoutX(7);
        SidePart.setLayoutY(27);
        SidePart.setHeight(50);
        
        //Se añaden los rectangulos
        getChildren().add(SidePart);
        getChildren().add(TopPart);
        
        
    }
    
    
    
    public void hacerMovible(){
        setOnMousePressed((MouseEvent mouseEvent) -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });
        
        
        
        setOnDragDetected((MouseEvent mouseEvent) -> {
            Agarrado();
        });
        
        setOnMouseDragged(mouseEvent -> {
            setPosicion(mouseEvent.getSceneX() - mouseAnchorX,mouseEvent.getSceneY() - mouseAnchorY);
            toFront();
        });
        
        
        setOnMouseReleased((MouseEvent mouseEvent) -> {
            Soltado();
        });
        
    }
    
    
    public void Agarrado(){
        setColorBorde(Color.DODGERBLUE);
        setTamBorde(6);
        toFront();
    }
    
    public void Soltado(){
        setColorBorde(Color.color(0, 0, 0));
        setTamBorde(4);
    }
    
    
    
    
    
    
    
    
    
    
    public void setPosicion(double x, double y){
        setLayoutX(x);
        this.x = x;
        setLayoutY(y);
        this.y = y;
    }
    
    public double getX(){
        return getLayoutX();
    }
    
    public double getY(){
        return getLayoutY();
    }
    
    public void setColorBorde(Color s){
        TopPart.setStroke(s);
        SidePart.setStroke(s);
    }
    
    public void setTamBorde(double b){
        TopPart.setStrokeWidth(b);
        SidePart.setStrokeWidth(b);
    }
    
    
    
    //Conecta las propiedades con el bloque
    public void Pintar(){
        
        setStyle("-fx-background-color: rgba(0, 100, 100, 0); -fx-background-radius: 10;");
        
        //Aplicacion del color
        Color c = this.ColorBloque;
        TopPart.setFill(c);
        SidePart.setFill(c.darker().darker()); //La parte de abajo es un color mas oscuro
        
        Color s = this.ColorBorde;
        setColorBorde(s);
        
        //Colocar el tamaño de borde
        setTamBorde(this.TamBorde);
        
        
        //ancho de los rectangulos
        TopPart.setWidth(this.ancho);
        SidePart.setWidth(this.ancho);
        setPrefWidth(this.ancho + 15);
        
        //la posicion del bloque
        setLayoutX(this.x);
        setLayoutY(this.y);
        
    }
    
    
    
    
}
