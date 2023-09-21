
package Model;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public final class Bloque extends Pane{
    
    
    public Conector conectado = null;
    public Conector chorizontal;
    
    public Conector conectadov = null;
    public Conector cvertical;
    
    //Componentes
    public Rectangle SidePart;
    public Rectangle TopPart;
    
    //Constantes
    public static final int ALTO = 84;
    
    
    //Propiedades
    public double TamBorde;
    public double ancho;
    
    public double x;
    public double y;
    
    public Color ColorBloque;
    public Color ColorBorde;
    
    
    public double mouseAnchorX;
    public double mouseAnchorY;
    public double LastX;
    public double LastY;
    
    //Constructor
    public Bloque(double x, double y, Color ColorBloque) {
        this.x = x;
        LastX = x;
        this.y = y;
        LastY = y;
        this.ColorBloque = ColorBloque;
        
        this.ColorBorde = Color.color(0, 0, 0);
        this.TamBorde = 4;
        this.ancho = 50+ Math.random()*120;
        
        
        IniciarComponentes();
        Pintar();
    }
    
    
    public void IniciarComponentes(){
        chorizontal = new Conector(this, "h");
        cvertical = new Conector(this, "v");
        
        
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
        
        setHeight(77);
        
        
    }
    
    
    public void DesactivarVertical() {if (cvertical != null) cvertical.Desactivar();}
    public void ActivarVertical() {if (cvertical != null) cvertical.Activar();}
    
    public void Agarrado(){
        setColorBorde(Color.DODGERBLUE);
        setTamBorde(6);
        AlFrente();
        
        if (conectado != null){
            conectado.Desconectar();
            conectado = null;
        }
            
    }
    
    public void AlFrente(){
        toFront();
        if (chorizontal != null && chorizontal.conexion != null){
            chorizontal.conexion.AlFrente();
        }
        if (cvertical != null && cvertical.conexion != null){
            cvertical.conexion.AlFrente();
        }
    }
    
    
    
    public void Soltado(){
        setColorBorde(Color.color(0, 0, 0));
        setTamBorde(4);
    }
    
    
    
    
    public double[] getRecVertices(){
        double [] c = {9+getX(), 8+getY(),ancho+7+getX(),this.getHeight()+getY()-18};
        return c;
    }
            
    
    
    
    
    
    
    public void setPosicion(double x, double y){
        setLayoutX(x);
        setLayoutY(y);
        this.x = x;
        this.y = y;
        if (chorizontal != null) chorizontal.fixPosicion();
        if (cvertical != null) cvertical.fixPosicion();
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
        
//        double[] d = this.getRecVertices();
//        Circle t = new Circle(d[0],d[1],6);
//        getChildren().add(t);
//        t = new Circle(d[0],d[3],6);
//        getChildren().add(t);
//        t = new Circle(d[2],d[1],6);
//        getChildren().add(t);
//        t = new Circle(d[2],d[3],6);
//        getChildren().add(t);
        
    }
    
    
    
    
}
