
package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class ConectorMultiple extends Conector{
    
    
    
    public double largoConector=0;
    
    public ConectorMultiple(Bloque conectador) {
        super(conectador, "v");
        
        setLargoLinea();
        setPreBloqueY();
        conectador.Inconectableh = true;
//        Circle cir = new Circle(inner.getLayoutX(), inner.getLayoutY(),5);
//        cir.setFill(Color.RED);
//        getChildren().add(cir);
    }
    
    @Override
    public void iniciarComponentes(){
        super.iniciarComponentes();
        inner = new Conector(this,"h",true);
        inner.multiconectador = this;
        inner.linea.setStartX(45);
        inner.identable = true;
        inner.setPosicion(0, 0);
        setPreBloqueY();
        
    }
    
    
    
    public final void setLargoLinea(){
        linea.setEndY(altoLinea());
    }
    
    public double altoLinea(){
        return (Bloque.ALTO-18)*(largoConector)+80;
    }
    
    
    public final void setPreBloqueY(){
        this.SidePart.setY(-27 + altoLinea());
        this.TopPart.setY( -7 + altoLinea());
    }
    
    
    
    @Override
    public void setPosicion(double x, double y){
        setLayoutX(x);
        setLayoutY(y);
        
        if (conexion != null) conexion.setPosicion(x, y+altoLinea());
        if (inner != null) inner.setPosicion(x+conectador.ancho/2.0, y);
        fixPosicion();
    }
    
    
    
    
    @Override
    public void fixPosicion(){
        setLargoLinea();
        setPreBloqueY();
                
        setLayoutX(conectador.getX() + offX);
        setLayoutY(conectador.getY() + (Bloque.ALTO-15));
        if (conexion != null) {
            conexion.setPosicion(this.getLayoutX(), this.getLayoutY()-27+ altoLinea());
        }
        
        if (inner != null){
            inner.setPosicion(this.getLayoutX()+conectador.ancho/2.0, getLayoutY());
        }
        
        linea.setLayoutX(-8);
        linea.setLayoutY(0);

    }
    
    
    
    
//    @Override
//    public void fixLargoLineaIdentada(){
//        if (conectador == null && conexion != null){
//            int c = 0;
//            
//            if (inner.conexion != null){
//                c = inner.conexion.LargoConexionMultiple()+1;
//            }
//            
//            multiconectador.largoConector = conexion.LargoConexionMultiple()+ c;
//            multiconectador.fixPosicion();
//            multiconectador.fixLargoLineaIdentada();
//            if (multiconectador.conexion != null && multiconectador.conexion.conectado != null){
//                multiconectador.conexion.conectado.fixLargoLineaIdentada();
//            }
//        }
//        if (conectador != null && conectador.conectado != null){
//            conectador.conectado.fixLargoLineaIdentada();
//        }
//    }
//    
    
    @Override
    public void ocultarLinea(){
    }
    
    
    
    @Override
    public double[] getRectVertices(){
        double [] d = {getX()+7, getY()+altoLinea(), getX()+conectador.ancho/2.0, getY()+(Bloque.ALTO-15)/2.0+altoLinea()};
        return d;
    }
    
}
