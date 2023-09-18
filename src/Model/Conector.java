
package Model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


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
    
    
    
    public Bloque conexion;
    
    
    //Constructor para el vertical
    public Conector(double x, double y, double scale){
        this.x = x;
        this.modo = "v";
        ancho = scale;
        this.y = y;
        conexion = null;
        iniciarComponentes();
        pintar();
    }
    
    
    //Constructor para el horizontal
    public Conector(double x, double y){
        this.x = x;
        this.modo = "h";
        this.y = y;
        conexion = null;
        iniciarComponentes();
        pintar();
    }
    
    
    public void iniciarComponentes(){
        this.toBack();
        ColorLinea = Color.color(0, 0, 0);;
        grosorLinea = 8;
        
        SidePart = new Rectangle(getX(),getY()+7, 50,Bloque.ALTO-27);
        TopPart = new Rectangle(getX(),getY()+27, 50,Bloque.ALTO-27);
        
        SidePart.toBack();
        TopPart.toBack();
        
        
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
            linea = new Line(getX(),getY()+getHeight()/2,getX()+ancho,getY()+getHeight()/2);
        } else {
            linea = new Line(getX()+getWidth()/2,getY(),getX()+getWidth()/2,getY()+ancho);
        }
        linea.setStrokeWidth(grosorLinea);
        linea.setStroke(ColorLinea);
        
        getChildren().add(linea);
        
        
        
        double[] d = this.getRectVertices();
        Circle t = new Circle(d[0],d[1],6);
        getChildren().add(t);
        t = new Circle(d[0],d[3],6);
        getChildren().add(t);
        t = new Circle(d[2],d[1],6);
        getChildren().add(t);
        t = new Circle(d[2],d[3],6);
        getChildren().add(t);
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
        b.conectado = this;
    }
    
    
    public double getX(){
        return getLayoutX();
    }
    
    public double getY(){
        return getLayoutY();
    }
    
    
    public double[] getRectVertices(){
        double [] d = {getX(), getY(), getX() + ancho, getY()+getHeight()};
        return d;
    }
    
    
    
    public boolean detectarColision(Bloque b){
        if (conexion != null) return false;
        double [] p1 = b.getRecBounds();
        double[] p2 = getRectVertices();

        return (!(p1[2] < p2[0] || p2[2] < p1[0] || p1[3] < p2[1] || p2[3] < p1[1]));
    }
    
    
}
