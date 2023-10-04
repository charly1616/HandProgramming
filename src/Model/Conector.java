
package Model;

import Bloques.BloqueInicio;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;


public class Conector extends Pane{
    
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
    
    public ConectorMultiple multiconectador;
    public Conector inner;
    
    
    public boolean identable; //Los que se conectan no pierden su habilidad de cVertical
    
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
    
    public Conector(ConectorMultiple conectador, String modo, boolean activado){
        this.modo = modo;
        this.conectador = null;
        this.multiconectador = conectador;
        this.activado = activado;
        conexion = null;
        this.offX = 0;
        iniciarComponentes();
        pintar();
    }
    
    
    public Conector(Bloque conectador, String modo){
        this.modo = modo;
        this.conectador = conectador;
        this.activado = true;
        this.offX = 0;
        conexion = null;
        iniciarComponentes();
        pintar();
    }
    
    
    public void iniciarComponentes(){
        
        if (conectador != null){
            if (modo.equals("h")){
                setHeight(Bloque.ALTO);
                setWidth(ancho);
                setLayoutX(   conectador.getX()+conectador.getWidth()-5+ offX );
                setLayoutY(conectador.getY()+7);
            } else {
                setHeight(Bloque.ALTO);
                setWidth(conectador.ancho);
                setLayoutX(conectador.getX()+7);
                setLayoutY(conectador.getHeight());
            }
        } else {
            setHeight(Bloque.ALTO);
            setWidth(ancho);
            setLayoutX(   multiconectador.getLayoutX()-5+ offX);
            setLayoutY(multiconectador.getLayoutY()+7    );

        }
        
        
        
        
        ColorLinea = Color.color(0, 0, 0);
        grosorLinea = 8;
        
        
        if (modo.equals("h")){
            if (conectador == null){
                SidePart = new Rectangle(55+7,20-8, 50,50);
                TopPart = new Rectangle(55+7,0-8, 50,56);
            } else {
                SidePart = new Rectangle(7,27, 50,50);
                TopPart = new Rectangle(7,7, 50,56);
            }
            
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
        
        //Punteado
        SidePart.getStrokeDashArray().addAll(5d, 10d);
        TopPart.getStrokeDashArray().addAll(5d, 10d);
        
        SidePart.setVisible(false);
        TopPart.setVisible(false);
        
        
        this.setMouseTransparent(true);
        
        
        
        getChildren().add(SidePart);
        getChildren().add(TopPart);
        
    }
    
    
    
    
    public void pintar(){
        this.toBack();
        setStyle("-fx-background-color: rgba(0, 100, 100, 0); -fx-background-radius: 10;");

        if (modo.equals("h")) {
            if (conectador == null) {
                linea = new Line(multiconectador.conectador.ancho / 2.0, Bloque.ALTO / 2 - 7, multiconectador.conectador.ancho / 2.0 + 40, Bloque.ALTO / 2 - 7);
            } else {
                linea = new Line(0, Bloque.ALTO / 2, 40, Bloque.ALTO / 2);
            }
        } else {
            linea = new Line(47, 0, 47, 40);

        }
        linea.setStrokeWidth(grosorLinea);
        linea.setStroke(ColorLinea);
        linea.getStrokeDashArray().addAll(5d, 10d);
        linea.setStrokeLineCap(StrokeLineCap.ROUND);

        if (!activado) {
            linea.setVisible(false);
        }
        
        
        
        
        getChildren().add(linea);
        fixPosicion();

//        double[] d = this.getRectVertices();
//        Circle t = new Circle(d[0] - getLayoutX(), d[1] - getLayoutY(), 6);
//        getChildren().add(t);
//        t = new Circle(d[0] - getLayoutX(), d[3] - getLayoutY(), 6);
//        getChildren().add(t);
//        t = new Circle(d[2] - getLayoutX(), d[1] - getLayoutY(), 6);
//        getChildren().add(t);
//        t = new Circle(d[2] - getLayoutX(), d[3] - getLayoutY(), 6);
//        getChildren().add(t);
    }
    
    
    
    
    public void Desactivar(){
        this.activado = false;
        this.ocultarLinea();
    }
    
    public void Activar(){
        this.activado = true;
        this.mostrarLinea();
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
        
        fixPosicion();
    }
    
    public Bloque getConexion(){
        return this.conexion;
    }
    
    
    
    public void fixPosicion(){
        if (conectador != null){
            if (modo.equals("h")){
                setLayoutX(conectador.getX() + conectador.ancho+offX   );
                setLayoutY(conectador.getY());
                if (conexion != null) conexion.setPosicion(this.getLayoutX(), this.getLayoutY());
            } else {
                setLayoutX(conectador.getX() + offX   );
                setLayoutY(conectador.getY()+Bloque.ALTO);
                if (conexion != null) conexion.setPosicion(this.getLayoutX(), this.getLayoutY()-20);
            }


            if (modo.equals("h")){
                linea.setLayoutX(0);
                linea.setLayoutY(0);
            } else {
                linea.setLayoutX(0);
                linea.setLayoutY(0);
            }
        } else {
            
            setLayoutX( multiconectador.getLayoutX()-5+ offX   );
            setLayoutY(   multiconectador.getLayoutY()+15);
            if (conexion != null) conexion.setPosicion(this.getLayoutX()+ offX + 55, this.getLayoutY()-15);


            linea.setLayoutX(0);
            linea.setLayoutY(0);
            
        }
        
    }

    public boolean puedeConectarse(Bloque b) {
        if (b.Inconectableh && modo.equals("h") && multiconectador == null) {
            return false;
        }
        if (b.Inconectablev && modo.equals("v")) {
            return false;
        }
        return true;
    }


    
    public void setConexion(Bloque b) {
        if (!puedeConectarse(b)) return;
        
        
        this.conexion = b;
        fixLargoLineaIdentada();
        if (modo.equals("h") && !identable) {
            b.DesactivarVertical();
        }
        if (b != null) {
            b.conectado = this;
            fixPosicion();
            ocultarPreBloque();
            ocultarLinea();
        }
        
    }
    
    
    public void fixLargoLineaIdentada(){
        
        //Propagar al identador
        if (conectador == null && conexion != null){
            
            //actualiza el largo del conector 
            multiconectador.largoConector = conexion.LargoConexionMultiple();
            multiconectador.fixPosicion();
            multiconectador.fixLargoLineaIdentada();
        } else if (conectador == null ){
            //actualiza el largo del conector 
            multiconectador.largoConector = 0;
            multiconectador.fixPosicion();
            multiconectador.fixLargoLineaIdentada();
        }
        
        //propagar al de arriba
        if (conectador != null && conectador.conectado != null){
            conectador.conectado.fixPosicion();
            conectador.conectado.fixLargoLineaIdentada();
        }
        
    }
    
    

    public void Desconectar(){
        
        this.conexion.conectado = null;
        if (modo.equals("h")) this.conexion.ActivarVertical();
        this.conexion = null;
        if (conectador == null){
            multiconectador.largoConector = 0;
            multiconectador.fixPosicion();
        }
        fixLargoLineaIdentada();
        mostrarLinea();
    }
    
    
    public double getX(){
//        if (conectador == null) return multiconectador.getX()+getLayoutX();
        return getLayoutX();
    }
    
    public double getY(){
//        if (conectador == null) return multiconectador.getY()+getLayoutY();
        return getLayoutY();
    }
    
    
    public double[] getRectVertices(){
        if (modo.equals("v")){
            double [] d = {getX()+7, getY()+7, getX()+52, getY()+Bloque.ALTO/2.0};
            return d;
        } else {
            
            if (conectador != null) {
                double [] d = {getX()+7, getY()+7, getX()+conectador.ancho/2.0, getY()+Bloque.ALTO/2.0};
                return d;
            } else {
                double [] d = {getX()+7+55, getY()+7, getX()+multiconectador.conectador.ancho/2.0+55, getY()+Bloque.ALTO/2.0};
                return d;
            }
        }
    }
    
    
    
    public boolean detectarColision(Bloque b){
        if (conexion != null || !activado) return false;
        if (modo.equals("h") && (b.cvertical.conexion != null && !identable)) return false;
        
        double [] p1 = b.getRecVertices();
        double[] p2 = getRectVertices();
//        System.out.println(p1[0] + " "+p1[1] + " " + p1[2] + " "+ p1[3]);
//        System.out.println(p2[0] + " "+p2[1] + " " + p2[2] + " "+ p2[3]);
//        System.out.println(!(p1[0]+50 < p2[0] && p2[2] < p1[0] || p1[3] < p2[1] && p2[3] < p1[1]));
//        System.out.println("\n\n\n\n\n");
        return (!(p1[0]+50 < p2[0] || p2[2] < p1[0] || p1[3] < p2[1] || p2[3] < p1[1]));
    }
    
    
    
    public void mostrarPreBloque(Bloque b) {
    if (!activado || !puedeConectarse(b)) {
        return;
    }

    TopPart.setWidth(b.ancho);
    SidePart.setWidth(b.ancho);

    Color c = b.ColorBloque;
    c = new Color(c.getRed(), c.getGreen(), c.getBlue(), 0.2);

    TopPart.setFill(c);
    SidePart.setFill(c);

    TopPart.setVisible(true);
    SidePart.setVisible(true);
}

    
    
    public void ocultarLinea(){
        linea.setVisible(false);
    }
    
    public void ocultarPreBloque(){
        TopPart.setVisible(false);
        SidePart.setVisible(false);
    }
    
    public void mostrarLinea(){
        if (activado) linea.setVisible(true);
    }

}
