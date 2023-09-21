/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

/**
 *
 * @author User
 */
public class GridController implements Initializable {
    
    @FXML
    public ScrollPane GridView;
    
    @FXML
    public AnchorPane Grid;
    
    
    
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
        cirs.setScaleX(Grid.getScaleX());
        cirs.setScaleY(Grid.getScaleY());
        crearPuntos();
        Grid.getChildren().add(cirs);
        
        
        Screen pantalla = Screen.getPrimary();
        javafx.geometry.Rectangle2D coordenadas = pantalla.getVisualBounds();
        Grid.setPrefWidth((coordenadas.getMaxX()));
        GridView.setPrefWidth((coordenadas.getMaxX()));
        Grid.setPrefHeight((coordenadas.getMaxY()));
        GridView.setPrefHeight((coordenadas.getMaxY()));
        
        hacerNavegable();
        
        for (int i = 0; i < 1; i++) {
            crearBloque(Color.BEIGE);
            crearBloque(Color.BURLYWOOD);
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

    }
    
    
    
    public void hacerBloqueMovible(Bloque b){
        b.setOnMousePressed((MouseEvent mouseEvent) -> {
            b.mouseAnchorX = mouseEvent.getX();
            b.mouseAnchorY = mouseEvent.getY();
        });
        
        
        
        b.setOnDragDetected((MouseEvent mouseEvent) -> {
            b.Agarrado();
        });
        
        b.setOnMouseDragged(mouseEvent -> {
            b.setPosicion(mouseEvent.getSceneX() -b. mouseAnchorX,mouseEvent.getSceneY() - b.mouseAnchorY);
            b.toFront();
        });
        
        
        b.setOnMouseReleased((MouseEvent mouseEvent) -> {
            b.Soltado();
            
            
            
            if (!pintarPreBloque(b) && detectarColision(b)){
                b.setPosicion(b.LastX+this.offsetX, b.LastY+ this.offsetY);
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
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
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
                bloques.get(u).setPosicion(mouseEvent.getSceneX() - mouseAnchorX + x,mouseEvent.getSceneY() - mouseAnchorY + y);
            }
            
        });

    }
    
    
    
    
    public boolean pintarPreBloque(Bloque b){
        for (Bloque p : bloques) {
            if (p == b) continue;
            if (p.chorizontal.detectarColision(b)){
                p.chorizontal.mostrarPreBloque(b);
                
                return true;
            } else {
                p.chorizontal.ocultarPreBloque();
            }
        }
        return false;
    }
    
    
    public void ConectarBloque(Bloque b){
        for (Bloque p : bloques) {
            if (p == b) continue;
            
            if (p.chorizontal.detectarColision(b)){
                p.chorizontal.setConexion(b);
            }
        }
    }
    
    
    public boolean detectarColision(Bloque b){
        for (Bloque p : bloques) {
            if (p == b) continue;
            
            double [] p2 = b.getRecBounds();
            double[] p1 = p.getRecBounds();
            
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
        Bloque p = new Bloque(0, 0, c);
        hacerBloqueMovible(p);
        if (p.chorizontal != null) Grid.getChildren().add(p.chorizontal);
        Grid.getChildren().add(p);
        bloques.add(p);
    }

}
