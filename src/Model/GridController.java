
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
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
    public double scale = 1;
    public Scene escena;
    
    @FXML
    public Pane Grid;
    
    
    public CreadorDeBloques creador;
    
    
    
    // Lo que guarda los componentes
    public ArrayList<Bloque> bloques = new ArrayList<Bloque>();
    public ArrayList<Circle> puntos = new ArrayList<Circle>();
    public Pane cirs = new Pane();
    
    
    
    
    
    
    //Movimiento del fondo
    public double mouseAnchorX;
    public double mouseAnchorY;
    
    
    private double lastMouseX, lastMouseY;
    
    
    /* 
        Recibe: (URL, ResourceBundle) cosas que son necesarias para JavaFX
        Devuelve: (void) (Nada)
        Hace: añade la pantalla, establece las caracteristicas como el tamaño, coloca los eventos -(Metodos {hacerNavegable}{hacerZoomeable})
        crea el bloque de inicio y los bloques iniciales -(Metodos {hacerBloqueMovible}{añadirBloque}), aparte de los puntos -(Metodo {crearPuntos})
        
    */
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
        for (int i = 0; i < 10; i++) {
            p = new BloqueMostrar(-500, 1000);
            hacerBloqueMovible(p);
            añadirBloque(p);
        }
        
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueWhile(-500, 800);
            hacerBloqueMovible(p);
            añadirBloque(p);
        }
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueIF(-500, 1200);
            hacerBloqueMovible(p);
            añadirBloque(p);
        }
        
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueElif(-500, 1400);
            hacerBloqueMovible(p);
            añadirBloque(p);
        }
        
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueElse(-500, 1600);
            hacerBloqueMovible(p);
            añadirBloque(p);
        }
        
        
        
        
        for (int i = 0; i < 20; i++) {
            p = new BloqueValor(500, 120);
            hacerBloqueMovible(p);
            añadirBloque(p);
        }
        
        for (int i = 0; i < 10; i++) {
            p = new BloqueVariable(1500, 120);
            hacerBloqueMovible(p);
            añadirBloque(p);
        }
        
        
        String [] signos = {"+","-","x","^","/","%"};
        
        for (int j = 0; j< signos.length; j++) {
            for (int i = 0; i < 10; i++) {
                p = new BloqueMat(100*j, 1000,signos[j]);
                hacerBloqueMovible(p);
                añadirBloque(p);
            }
        }
        
        String [] signos2 = {"=","!=",">","<","<=",">="};
        
        for (int j = 0; j< signos2.length; j++) {
            for (int i = 0; i < 10; i++) {
                p = new BloqueLMat(100*j, 1100,signos2[j]);
                hacerBloqueMovible(p);
                añadirBloque(p);
            }
        }
        
        String [] signos3 = {"&","o"};
        
        for (int j = 0; j< signos3.length; j++) {
            for (int i = 0; i < 10; i++) {
                p = new BloqueLogico(100*j, 1200,signos3[j]);
                hacerBloqueMovible(p);
                añadirBloque(p);
            }
        }
        
        
        
        
        p = new BloqueInicio(0, 0);
        hacerBloqueMovible(p);
        añadirBloque(p);
        
        
        for (int i = 0; i < 8; i++) {
            crearBloque(Color.rgb((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)));
        }
        
        hacerZoomeable();
       
    }
    
    
    
    /* 
        Recibe: (Nada)
        Devuelve: (void) (Nada)
        Hace: establece el evento que cuando se ruede se haga zoom, aplica el zoom a todos los componentes
        
    */
    
    public void hacerZoomeable(){
        Grid.getParent().setOnScroll((ScrollEvent event) -> {
            double scaleFactor = (event.getDeltaY() > 0) ? 1.1 : 0.9;
            scale *= scaleFactor;
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();

            // Calcular el desplazamiento del punto de enfoque
            double offsetX = (mouseX) * (1 - scaleFactor);
            double offsetY = (mouseY) * (1 - scaleFactor);

            Grid.setScaleX(scale);
            Grid.setScaleY(scale);

            // Ajustar la posición para mantener el punto de enfoque
            Grid.setTranslateX((Grid.getTranslateX()+offsetX+8)*scaleFactor);
            Grid.setTranslateY((Grid.getTranslateY()+offsetY+8)*scaleFactor);
        });
    }
    
    
    
    /* 
        Recibe: (Bloque b)
        Devuelve: (void) (Nada)
        Hace: le coloca distintos eventos al bloque "b"
        hace que "b" se pueda agarrar y arrastrar, conecta la funcion {agarrado} y {soltado}
        establece las conexiones -(funcion {detectarColision}{b.setConexion}) cuando se mueve el bloque
        hace que cuando se de click dos veces, se elimine
        
    */
    public void hacerBloqueMovible(Bloque b){
        b.setOnMousePressed(event -> {
            b.mouseAnchorX = event.getX()*scale+Grid.getTranslateX();
            b.mouseAnchorY = event.getY()*scale+Grid.getTranslateY();
            event.consume();
        });
        
        
        b.setOnDragDetected(event -> {
            b.Agarrado();
            if (b.conectado != null)  b.conectado.Desconectar();
            event.consume();
        });
        
        b.setOnMouseDragged(event -> {
            b.setPosicion((event.getSceneX()) -b.mouseAnchorX,(event.getSceneY()) - b.mouseAnchorY);
            b.setPosicion(b.getX()/scale-200/scale,b.getY()/scale-70/scale);
            b.toFront();
            pintarPreBloque(b);
            event.consume();
        });
        
        b.setOnMouseReleased(event -> {
            b.Soltado();
            OcultarPreBloques();
    
            Conector c = pintarPreBloque(b);
            if (c != null) {
                c.setConexion(b);
            } else if (detectarColision(b)) {
                b.setPosicion(b.LastX/scale-200/scale, b.LastY/scale-50/scale);
            } else {
                b.LastX = b.getX();
                b.LastY = b.getY();
            }

            organizarBloques();
            event.consume();
        });
        
        b.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                eliminarBloque(b);
            }
        });
    }
    
    
    
    /* 
        Recibe: (Nada)
        Devuelve: (void) (Nada)
        Hace: hace que el fondo "Grid" se pueda mover y que todos los bloques y puntos se muevan con él
        
    */
    public void hacerNavegable() {
        Grid.getParent().setOnMousePressed(event -> {
            lastMouseX = event.getSceneX();
            lastMouseY = event.getSceneY();
            event.consume();
        });

        Grid.getParent().setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - lastMouseX;
            double deltaY = event.getSceneY() - lastMouseY;
            Grid.setTranslateX(Grid.getTranslateX() + deltaX);
            Grid.setTranslateY(Grid.getTranslateY() + deltaY);
            lastMouseX = event.getSceneX();
            lastMouseY = event.getSceneY();
        });
        

    }
    
    
    /* 
        Recibe: (Bloque b) 
        Devuelve: (Conector) devuelve el primer conector que está colisionando con "b"
        Hace: busca en todos los bloques, en todos sus conectores si el conector está colisionando, cuando es así, muestra el prebloque de ese conector y devuelve al conector
        cuando no encuentra ninguno devuelve null
        
    */
    public Conector pintarPreBloque(Bloque b) {
        for (Bloque p : bloques) {
            
            if (p == b) {
                continue;
            }
            OcultarPreBloques();
            if (p.chorizontal.detectarColision(b)) {
                p.chorizontal.mostrarPreBloque(b);
                return p.chorizontal;
            }

            if (p.cvertical.inner != null && p.cvertical.inner.detectarColision(b)) {
                p.cvertical.inner.mostrarPreBloque(b);
                return p.cvertical.inner;
            }
            if (p.cvertical.detectarColision(b)) {
                p.cvertical.mostrarPreBloque(b);
                return p.cvertical;
            }

        }
        return null;
    }
    
    
    
    /* 
        Recibe: (Nada)
        Devuelve: (void) (Nada)
        Hace: oculta todos los prebloques de todos los conectores de todos los bloques en la lista "bloques"
        
    */
    public void OcultarPreBloques() {
        for (Bloque p : bloques) {
            p.chorizontal.ocultarPreBloque();
            p.cvertical.ocultarPreBloque();
            if (p.cvertical.inner != null) {
                p.cvertical.inner.ocultarPreBloque();
            }
        }
    }

    
      
    /* 
        Recibe: (Bloque b)
        Devuelve: (void) (Nada)
        Hace: establece las conexiones de "b" con el primer conector que esté cerca de "b" sea conector vertical u horizontal
        despues oculta todos los prebloques
        
    */
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

    
    
    /* 
        Recibe: (Bloque b)
        Devuelve: (boolean) que significa que el bloque "b" esta colisionando con otro o no
        Hace: verifica si "b" está colisionando con alguno de los otros bloques en la lista "bloques" (usa los vertices para ver si están encima de otro)
        
    */
    public boolean detectarColision(Bloque b){
        double [] p2 = b.getRecVertices();
        for (Bloque p : bloques) {
            if (p == b) continue;
            
            double[] p1 = p.getRecVertices();
            
            if (!(p1[2] < p2[0] || p2[2] < p1[0] || p1[3] < p2[1] || p2[3] < p1[1])) {
                return true;
            }
        }
        return false;
    }
    
    
    
    /* 
        Recibe: (Nada)
        Devuelve: (Void)(Nada)
        Hace: crea puntos "cir" en una cuadricula y los añade al panel y a una lista de puntos llamada "puntos"
    */
    public void crearPuntos(){
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                Circle cir = new Circle();
                
                cir.setCenterX((i-10)*50);
                cir.setCenterY((j-10)*50);
                
                cir.setRadius(1);
                cir.setStrokeWidth(0);
                cir.setFill(Color.GREY.darker().darker());
                puntos.add(cir);
                Grid.getChildren().add(cir);
            }
        }
    }
    
    
    /* 
        Recibe: (Nada)
        Devuelve: (Void)(Nada)
        Hace: organiza los bloques de mayor altura a menor altura
        Hace que los que estén mas alto se vean detrás
    */
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
    
    
    
    /* Funcion de prueba (Existe para crear bloques mientras no haya una funcion especifica)
        Recibe: (Color c) que es el color que uno le quiere poner al bloque
        Devuelve: (Void)(Nada)
        Hace: crea un bloque "p" con el color especificado en la posicion tal 
        ,hace que "p" sea movible -(otra funcion "hacerBloqueMovible") 
        y añade -(otra funcion "añadirBloque") a "p"
    */
    public void crearBloque(Color c) {
        Bloque p = new BloqueCondicional(1000, 120,"if",Color.CORNFLOWERBLUE);
        hacerBloqueMovible(p);
        añadirBloque(p);
    }

    
    
    
    /* 
        Recibe: (Bloque p) que es el bloque que se va a añadir
        Devuelve: (Void)(Nada)
        Hace: añade al bloque "p" y todos sus componentes (conectores) al panel e ingresa a "p" a la lista "bloques" 
    */
    public void añadirBloque(Bloque p){
        if (p.chorizontal != null) {
            Grid.getChildren().add(p.chorizontal);
            p.chorizontal.fixPosicion();
        }
        if (p.cvertical != null) {
            Grid.getChildren().add(p.cvertical);
            p.cvertical.fixPosicion();
        }
        if (p.cvertical.inner != null){
            Grid.getChildren().add(p.cvertical.inner);
            p.cvertical.inner.fixPosicion();
        }
        Grid.getChildren().add(p);
        bloques.add(p);
    }
    
    
    
    /* 
        Recibe: (Bloque) que es el bloque que se va a eliminar
        Devuelve: (Void)(Nada)
        Hace: Elimina el bloque y sus conexiones del panel y del arrayList
    */
    public void eliminarBloque(Bloque bloque) {
        // Eliminar el bloque del contenedor
        Grid.getChildren().removeAll(bloque, bloque.chorizontal, bloque.cvertical);
        if (bloque.cvertical.inner != null){
            Grid.getChildren().remove(bloque.cvertical.inner);
        }
        // Eliminar el bloque del ArrayList
        bloques.remove(bloque);
    }
}
