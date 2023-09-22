
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
    
    public boolean activado;
    
    public String modo;
    
    
    //Propiedades
    public double ancho = 50;
    
    
    public double grosorLinea;
    public Color ColorLinea;
    
    
    public double offX;
    
    public Bloque conectador;
    public Bloque conexion;
    
    
    //Constructor para el vertical
    public Conector(Bloque conectador, String modo, boolean activado, double offX){
        this.modo = modo;
        this.conectador = conectador;
        this.activado = activado;
        this.offX = offX;
        conexion = null;
        iniciarComponentes();
        pintar();
    }
    
    public Conector(Bloque conectador, String modo){
        this.modo = modo;
        this.conectador = conectador;
        this.activado = true;
        conexion = null;
        iniciarComponentes();
        pintar();
    }
    
    
    public void iniciarComponentes(){
        
        if (modo.equals("h")){
            setHeight(Bloque.ALTO);
            setWidth(ancho);
            setPosicion(   conectador.getX()+conectador.getWidth()-5+ offX   ,    conectador.getY()+7    );
        } else {
            setHeight(Bloque.ALTO);
            setWidth(conectador.ancho);
            setPosicion(conectador.getX()+7,conectador.getHeight());
        }
        
        
        this.toBack();
        ColorLinea = Color.color(0, 0, 0);
        grosorLinea = 8;
        
        
        if (modo.equals("h")){
            SidePart = new Rectangle(7,27, 50,50);
            TopPart = new Rectangle(7,7, 50,56);
        }else {
            SidePart = new Rectangle(7,15, 50,50);
            TopPart = new Rectangle(7,-5, 50,56);
        }
        
        
        
        
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
        
        
        
        
        
        
        getChildren().add(SidePart);
        getChildren().add(TopPart);
    }
    
    
    
    
    public void pintar(){
        this.toBack();
        setStyle("-fx-background-color: rgba(0, 100, 100, 0); -fx-background-radius: 10;");
        
        if (modo.equals("h")){
            linea = new Line(0,getY()+getHeight()/2,40,getY()+getHeight()/2);
        } else {
            linea = new Line((conectador.ancho)/2.0,0,(conectador.ancho)/2.0,40);
        }
        linea.setStrokeWidth(grosorLinea);
        linea.setStroke(ColorLinea);
        linea.getStrokeDashArray().addAll(5d, 10d);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);
        
        if (!activado) linea.setVisible(false);
        
        getChildren().add(linea);
        fixPosicion();
        
        
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
    
    
    
    
    public void Desactivar(){
        this.activado = false;
        this.linea.setVisible(false);
    }
    
    public void Activar(){
        this.activado = true;
        this.linea.setVisible(true);
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
    
    
    
    public void fixPosicion(){
        if (modo.equals("h")){
            setLayoutX(conectador.getX() + conectador.ancho+offX   );
            setLayoutY(conectador.getY());
            if (conexion != null) conexion.setPosicion(this.getLayoutX(), this.getLayoutY());
        } else {
            setLayoutX(conectador.getX() + offX   );
            setLayoutY(conectador.getY()+Bloque.ALTO);
            if (conexion != null) conexion.setPosicion(this.getLayoutX(), this.getLayoutY()-20);
        }
        
    }
        

    
    
    
    
    public void setConexion(Bloque b){
        this.conexion = b;
        if (modo.equals("h")) b.DesactivarVertical();
        System.out.println(b);
        if (b != null){
            b.conectado = this;
            fixPosicion();
            ocultarPreBloque();
        }
    }
    
    
    public void Desconectar(){
        this.conexion.conectado = null;
        if (modo.equals("h")) this.conexion.ActivarVertical();
        this.conexion = null;
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
        if (conexion != null || !activado) return false;
        if (modo.equals("h") && b.cvertical.conexion != null) return false;
        
        double [] p1 = b.getRecVertices();
        double[] p2 = getRectVertices();
//        System.out.println(p1[0] + " "+p1[1] + " " + p1[2] + " "+ p1[3]);
//        System.out.println(p2[0] + " "+p2[1] + " " + p2[2] + " "+ p2[3]);
//        System.out.println(!(p1[0]+50 < p2[0] && p2[2] < p1[0] || p1[3] < p2[1] && p2[3] < p1[1]));
//        System.out.println("\n\n\n\n\n");
        return (!(p1[0]+50 < p2[0] || p2[2] < p1[0] || p1[3] < p2[1] || p2[3] < p1[1]));
    }
    
    
    
    public void mostrarPreBloque(Bloque b){
        if (!activado) return;
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
        if (activado) linea.setVisible(true);
    }
    
    
}
