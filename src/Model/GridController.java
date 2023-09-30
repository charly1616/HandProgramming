
package Model;

import Bloques.BloqueInicio;
import Bloques.*;
import javafx.scene.Node;
import Main.Controller;
import Model.Bloque;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;

/**
 *
 * @author User
 */
public class GridController implements Initializable {
    
    @FXML
    public Pane GridView;
    public Scale scale;
    public Scene escena;
    
    @FXML
    public Pane Grid;
    
    
    public CreadorDeBloques creador;
    
    
    
    // Lo que guarda los componentes
    public ArrayList<Bloque> bloques = new ArrayList<Bloque>();
    public Pane cirs = new Pane();
    
    
    
    
    //Movimiento de los componentes
    public ArrayList<Double> posx = new ArrayList<Double>();
    public ArrayList<Double> posy = new ArrayList<Double>();
    
    
    
    
    //Movimiento del fondo
    public double mouseAnchorX;
    public double mouseAnchorY;
    
    
    public double offsetX = 0;
    public double offsetY = 0;
    double initialX, initialY;
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        
        
        Screen pantalla = Screen.getPrimary();
        javafx.geometry.Rectangle2D coordenadas = pantalla.getVisualBounds();
        
        GridView.setPrefWidth((coordenadas.getMaxX()));
        GridView.setPrefHeight((coordenadas.getMaxY()));
        Grid.setPrefWidth(GridView.getWidth());
        Grid.setPrefHeight(GridView.getHeight());
        
        cirs.setScaleX(Grid.getScaleX());
        cirs.setScaleY(Grid.getScaleY());
        crearPuntos();
        Grid.getChildren().add(cirs);
        
        
        Grid.setBackground(Background.EMPTY);
        
        hacerNavegable();
        
        
        
        Bloque p ;
        
        
        p = new BloqueLabel(-500, 1000,Color.AQUA,"Olga");
        hacerBloqueMovible(p);
        if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
        if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
        Grid.getChildren().add(p);
        bloques.add(p);
        
        
        for (int i = 0; i < 20; i++) {
            p = new BloqueValor(500, 120);
            hacerBloqueMovible(p);
            if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
            if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
            Grid.getChildren().add(p);
            bloques.add(p);
        }
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueVariable(1500, 120);
            hacerBloqueMovible(p);
            if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
            if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
            Grid.getChildren().add(p);
            bloques.add(p);
        }
        
        
        
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueMat(120, 1000,"+");
            hacerBloqueMovible(p);
            if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
            if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
            Grid.getChildren().add(p);
            bloques.add(p);
        }
        
        
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueMat(200, 1000,"-");
            hacerBloqueMovible(p);
            if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
            if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
            Grid.getChildren().add(p);
            bloques.add(p);
        }
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueMat(300, 1000,"x");
            hacerBloqueMovible(p);
            if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
            if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
            Grid.getChildren().add(p);
            bloques.add(p);
        }
        
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueMat(400, 1000,"^");
            hacerBloqueMovible(p);
            if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
            if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
            Grid.getChildren().add(p);
            bloques.add(p);
        }
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueMat(600, 1000,"/");
            hacerBloqueMovible(p);
            if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
            if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
            Grid.getChildren().add(p);
            bloques.add(p);
        }
        
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueMat(500, 1000,"%");
            hacerBloqueMovible(p);
            if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
            if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
            Grid.getChildren().add(p);
            bloques.add(p);
        }
        
        
        
        p = new BloqueInicio(0, 0);
        hacerBloqueMovible(p);
        p.chorizontal.Desactivar();
        if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
        Grid.getChildren().add(p);
        bloques.add(p);
        
        
        for (int i = 0; i < 4; i++) {
            crearBloque(Color.rgb((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)));
        }
        
        p = new BloqueInicio(0, 0);
        hacerBloqueMovible(p);
        p.chorizontal.Desactivar();
        if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
        Grid.getChildren().add(p);
        bloques.add(p);
        
        
        for (int i = 0; i < 4; i++) {
            crearBloque(Color.rgb((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)));
        }
        
        
//        crearBloque(Color.CORNFLOWERBLUE);
//        crearBloque(Color.DARKOLIVEGREEN);
//        crearBloque(Color.HOTPINK);
//        crearBloque(Color.BEIGE);
//        crearBloque(Color.BURLYWOOD);
//        crearBloque(Color.CORNFLOWERBLUE);
//        crearBloque(Color.DARKOLIVEGREEN);
//        crearBloque(Color.HOTPINK);
        
        guardarPosiciones();
        hacerZoomeable();
    }
    
    
    public void hacerZoomeable(){
        scale = new Scale(1, 1);
        GridView.getTransforms().add(scale);
        escena = new Scene(GridView, GridView.getWidth(), GridView.getHeight());
        
        
        GridView.setOnScroll(event -> {
            double zoomFactor = 1.05; // Ajusta el factor de zoom según tus necesidades
            if (event.getDeltaY() > 0) {
                // Zoom in (aumentar el tamaño)
                scale.setX(scale.getX() * zoomFactor);
                scale.setY(scale.getY() * zoomFactor);
            } else {
                // Zoom out (disminuir el tamaño)
                scale.setX(scale.getX() / zoomFactor);
                scale.setY(scale.getY() / zoomFactor);
            }
        });
    }
    
    
    
    
    public void hacerBloqueMovible(Bloque b){
        b.setOnMousePressed((MouseEvent mouseEvent) -> {
            b.mouseAnchorX = mouseEvent.getX();
            b.mouseAnchorY = mouseEvent.getY();
        });
        
        
        
        b.setOnDragDetected((MouseEvent mouseEvent) -> {
            b.Agarrado();
            if (b.conectado != null)  b.conectado.Desconectar();
            
        });
        
        b.setOnMouseDragged(mouseEvent -> {
            b.setPosicion(mouseEvent.getSceneX() -b.mouseAnchorX,mouseEvent.getSceneY() - b.mouseAnchorY);
            b.toFront();
            pintarPreBloque(b);
        });
        
            b.setOnMouseReleased((MouseEvent mouseEvent) -> {
            b.Soltado();
            OcultarPreBloques();
    
            Conector c = pintarPreBloque(b);
            if (c != null) {
                c.setConexion(b);
            } else if (detectarColision(b)) {
                b.setPosicion(b.LastX + this.offsetX, b.LastY + this.offsetY);
            } else {
                b.LastX = b.getLayoutX() - this.offsetX;
                b.LastY = b.getLayoutY() - this.offsetY;
            }

            organizarBloques();
        });

        
    }
    
    
    public void hacerNavegable() {
        cirs.setOnMousePressed((MouseEvent mouseEvent) -> {
            guardarPosiciones();
            mouseAnchorX = mouseEvent.getX()*scale.getX();
            mouseAnchorY = mouseEvent.getY()*scale.getX();
            initialX = mouseEvent.getSceneX();
            initialY = mouseEvent.getSceneY();
        });;
        
        
        cirs.setOnMouseReleased((MouseEvent mouseEvent) -> {
            guardarPosiciones();
            
        });

        cirs.setOnMouseDragged(mouseEvent -> {
            offsetX += mouseEvent.getSceneX() - initialX;
            offsetY += mouseEvent.getSceneY() - initialY;
            
            initialX = mouseEvent.getSceneX();
            initialY = mouseEvent.getSceneY();
            
            //Mueve todo con relacion al mouse
            int i = 0;
            //Recorre los puntos
            for (; i < cirs.getChildren().size(); i++) {
                double x = posx.get(i);
                double y = posy.get(i);
                
                while (x>250){
                    x -= 500;
                }
                while (!(x>-250)){
                    x += 500;
                }
                while (y>250){
                    y -= 500;
                }
                while (!(y>-250)){
                    y += 500;
                }
                
                
                cirs.getChildren().get(i).setLayoutX(mouseEvent.getSceneX() - mouseAnchorX + x);
                cirs.getChildren().get(i).setLayoutY(mouseEvent.getSceneY() - mouseAnchorY + y);
            }
            //Recorre los Bloques
            for (; i < posx.size(); i++) {
                int u = i - cirs.getChildren().size();
                double x = posx.get(i);
                double y = posy.get(i);
                bloques.get(u).setPosicion(mouseEvent.getSceneX() - mouseAnchorX + x ,mouseEvent.getSceneY() - mouseAnchorY + y);
            }
            
        });

    }
    
    
    public Conector pintarPreBloque(Bloque b){
        for (Bloque p : bloques) {
            if (p == b) continue;
            OcultarPreBloques();
            if (p.chorizontal.detectarColision(b)){
                p.chorizontal.mostrarPreBloque(b);
                return p.chorizontal;
            }
            
            if (p.cvertical.inner != null && p.cvertical.inner.detectarColision(b)){
                p.cvertical.inner.mostrarPreBloque(b);
                return p.cvertical.inner;
            }
            if (p.cvertical.detectarColision(b)){
                p.cvertical.mostrarPreBloque(b);
                return p.cvertical;
            }
            
        }
        return null;
    }
    
    
      public void OcultarPreBloques() {
        for (Bloque p : bloques) {
            p.chorizontal.ocultarPreBloque();
            p.cvertical.ocultarPreBloque();
            if (p.cvertical.inner != null) {
                p.cvertical.inner.ocultarPreBloque();
            }
        }
    }

    
        public void ConectarBloque(Bloque b) {
        for (Bloque p : bloques) {
            if (p == b) {
                continue;
            }

            if (p.chorizontal.detectarColision(b)) {
                p.chorizontal.setConexion(b);
            } else if (p.cvertical.detectarColision(b)) {
                p.cvertical.setConexion(b);
            }
        }
        OcultarPreBloques();
    }

    
    
    
    public boolean detectarColision(Bloque b){
        for (Bloque p : bloques) {
            if (p == b) continue;
            
            double [] p2 = b.getRecVertices();
            double[] p1 = p.getRecVertices();
            
            if (!(p1[2] < p2[0] || p2[2] < p1[0] || p1[3] < p2[1] || p2[3] < p1[1])) {
                return true;
            }
        }
        return false;
    }
    
    
    
    public void guardarPosiciones(){
        posx.clear();
        posy.clear();
        for (Node c : cirs.getChildren()) {
            posx.add(c.getLayoutX());
            posy.add(c.getLayoutY());
        }
        for (Bloque c : bloques) {
            posx.add(c.getX());
            posy.add(c.getY());
        }
    }
    
    
    
    public void crearPuntos(){
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                Circle cir = new Circle();
                
                cir.setCenterX((i-10)*50);
                cir.setCenterY((j-10)*50);
                
                cir.setRadius(1);
                cir.setStrokeWidth(0);
                cir.setFill(Color.GREY.darker().darker());
                cirs.getChildren().add(cir);
            }
        }
    }
    
    
    public void organizarBloques() {
        ArrayList<Bloque> blq = new ArrayList<>(bloques);

        // Ordenar los bloques por su posición en el eje Y de manera descendente
        blq.sort((bloque1, bloque2) -> Double.compare(bloque1.getLayoutY(), bloque2.getLayoutY()));

        // Mantener las posiciones originales de los bloques al organizarlos
        for (int i = 0; i < blq.size(); i++) {
            Bloque bloque = blq.get(i);
            bloque.toFront();
        }
    }
    
    
    
    public void crearBloque(Color c) {
        Bloque p = new Bloque(1000, 120, c);
        hacerBloqueMovible(p);
        if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
        p.setAncho(150);
        p.cvertical = new ConectorMultiple(p);
        Grid.getChildren().add(p.cvertical);
        Grid.getChildren().add(p.cvertical.inner);
//        if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
        Grid.getChildren().add(p);
        bloques.add(p);
    }

}
