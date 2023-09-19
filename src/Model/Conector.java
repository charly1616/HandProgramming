
package Model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;


public final class Conector extends Pane{
    
    //Componentes
    public Rectangle SidePart;
    public Rectangle TopPart;
    public Line linea;
    
    
    
    public String modo;
    
    
    //Propiedades
    public double ancho = 50;
    
    public double x;
    public double y;
    
    public double grosorLinea;
    public Color ColorLinea;
    
    
    
    
    public Bloque conectador;
    public Bloque conexion;
    
    
    //Constructor para el vertical
    public Conector(double x, double y, Bloque conectador, String modo){
        this.x = x;
        this.modo = modo;
        this.conectador = conectador;
        this.y = y;
        conexion = null;
        iniciarComponentes();
        pintar();
    }
    
    
    
    
    public void iniciarComponentes(){
        
        setPosicion(x,y);
        this.toBack();
        ColorLinea = Color.color(0, 0, 0);;
        grosorLinea = 8;
        
        
        SidePart = new Rectangle(-6,27, 50,50);
        TopPart = new Rectangle(-6,7, 50,56);
        
        
        
        SidePart.setFill(new Color(0,0.8,0,0.05));
        TopPart.setFill(new Color(0,0.8,0,0.05));
        
        TopPart.setStroke(Color.BLACK);
        SidePart.setStroke(Color.BLACK);
        TopPart.setStrokeLineCap(StrokeLineCap.ROUND);
        SidePart.setStrokeLineCap(StrokeLineCap.ROUND);
        
        SidePart.setStrokeWidth(4);
        TopPart.setStrokeWidth(4);
        
        //Redondeado
        SidePart.setArcHeight(20);
        SidePart.setArcWidth(20);
        TopPart.setArcHeight(20);
        TopPart.setArcWidth(20);
        
        //Liso
        SidePart.setSmooth(true);
        TopPart.setSmooth(true);
        
        
        SidePart.toBack();
        TopPart.toBack();
        
        SidePart.getStrokeDashArray().addAll(5d, 10d);
        TopPart.getStrokeDashArray().addAll(5d, 10d);
        
        SidePart.setVisible(false);
        TopPart.setVisible(false);
        
        
        if (modo.equals("h")){
            setHeight(Bloque.ALTO);
            setWidth(ancho);
        } else {
            setHeight(ancho);
            setWidth(Bloque.ALTO);
        }
        setPosicion(x,y);
        getChildren().add(SidePart);
        getChildren().add(TopPart);
    }
    
    
    
    
    public void pintar(){
        this.toBack();
        setStyle("-fx-background-color: rgba(0, 100, 100, 0); -fx-background-radius: 10;");
        
        if (modo.equals("h")){
            linea = new Line(0,getY()+getHeight()/2,40,getY()+getHeight()/2);
        } else {
            linea = new Line(0+getWidth()/2,getY(),getX()+getWidth()/2,getY()+ancho);
        }
        linea.setStrokeWidth(grosorLinea);
        linea.setStroke(ColorLinea);
        linea.getStrokeDashArray().addAll(5d, 10d);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);
        
        getChildren().add(linea);
        
        
        
//        double[] d = this.getRectVertices();
//        Circle t = new Circle(d[0],d[1],6);
//        getChildren().add(t);
//        t = new Circle(d[0],d[3],6);
//        getChildren().add(t);
//        t = new Circle(d[2],d[1],6);
//        getChildren().add(t);
//        t = new Circle(d[2],d[3],6);
//        getChildren().add(t);
    }
    
    
    
    
    
    
    
    public void setColorBorde(Color c){
        linea.setStroke(c);
        ColorLinea = c;
    }
    
    
    public void setGrosorLinea(double d){
        linea.setStrokeWidth(d);
        grosorLinea = d;
    }
    
    public void setPosicion(double x, double y){
        setLayoutX(x);
        setLayoutY(y);
        
        
        if (conexion != null) conexion.setPosicion(x, y);
    }
    
    
    
    
    
    
    
    public void setConexion(Bloque b){
        this.conexion = b;
        if (b != null) b.conectado = this;
    }
    
    
    public double getX(){
        return getLayoutX();
    }
    
    public double getY(){
        return getLayoutY();
    }
    
    
    public double[] getRectVertices(){
        double [] d = {getX(), getY(), getX()+52, getY()+80};
        return d;
    }
    
    
    
    public boolean detectarColision(Bloque b){
        if (conexion != null) return false;
        double [] p1 = b.getRecBounds();
        double[] p2 = getRectVertices();

        return (!(p1[0]+50 < p2[0] || p2[2] < p1[0] || p1[3] < p2[1] || p2[3] < p1[1]));
    }
    
    public void mostrarPreBloque(Bloque b){
        TopPart.setWidth(b.ancho);
        SidePart.setWidth(b.ancho);
        
        Color c = b.ColorBloque;
        c = new Color(c.getRed(), c.getGreen(),c.getBlue(), 0.2);
        
        TopPart.setFill(c);
        SidePart.setFill(c);
        
        TopPart.setVisible(true);
        SidePart.setVisible(true);
        linea.setVisible(false);
    }
    
    public void ocultarPreBloque(){
        TopPart.setVisible(false);
        SidePart.setVisible(false);
        linea.setVisible(true);
    }
    
    
}
