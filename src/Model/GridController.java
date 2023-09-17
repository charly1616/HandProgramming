/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Main.Controller;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author User
 */
public class GridController implements Initializable {
    
    
    
    @FXML
    public AnchorPane Grid;
    
    
    public ArrayList<Pane> bloques = new ArrayList<Pane>();
    public Pane cirs = new Pane();
    
    public ArrayList<Double> posx = new ArrayList<Double>();
    public ArrayList<Double> posy = new ArrayList<Double>();
    
    public double mouseAnchorX;
    public double mouseAnchorY;
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cirs.setScaleX(Grid.getScaleX());
        cirs.setScaleY(Grid.getScaleY());
        crearPuntos();
        Grid.getChildren().add(cirs);
        
        hacerNavegable();
        
        crearBloque(Color.BEIGE);
        crearBloque(Color.BURLYWOOD);
        crearBloque(Color.CORNFLOWERBLUE);
        crearBloque(Color.DARKOLIVEGREEN);
        crearBloque(Color.HOTPINK);
        crearBloque(Color.BEIGE);
        crearBloque(Color.BURLYWOOD);
        crearBloque(Color.CORNFLOWERBLUE);
        crearBloque(Color.DARKOLIVEGREEN);
        crearBloque(Color.HOTPINK);
        
        guardarPosiciones();

    }
    
    
    public void hacerNavegable() {
        cirs.setOnMousePressed((MouseEvent mouseEvent) -> {

            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });;

        cirs.setOnMouseReleased((MouseEvent mouseEvent) -> {
            guardarPosiciones();
        });

        cirs.setOnMouseDragged(mouseEvent -> {
            int i = 0;
            for (; i < cirs.getChildren().size(); i++) {
                double x = posx.get(i);
                double y = posy.get(i);
                cirs.getChildren().get(i).setLayoutX(mouseEvent.getSceneX() - mouseAnchorX + x);
                cirs.getChildren().get(i).setLayoutY(mouseEvent.getSceneY() - mouseAnchorY + y);
            }
            for (; i < posx.size(); i++) {
                int u = i - cirs.getChildren().size();
                double x = posx.get(i);
                double y = posy.get(i);
                if (u == 0) System.out.println(mouseEvent.getSceneX() - mouseAnchorX + x + " - " + x);
                bloques.get(u).setLayoutX(mouseEvent.getSceneX() - mouseAnchorX + x);
                bloques.get(u).setLayoutY(mouseEvent.getSceneY() - mouseAnchorY + y);
            }
        });

    }
    
    public void guardarPosiciones(){
        posx.clear();
        posy.clear();
        for (Node c : cirs.getChildren()) {
            posx.add(c.getLayoutX());
            posy.add(c.getLayoutY());
        }
        for (Pane c : bloques) {
            posx.add(c.getLayoutX());
            posy.add(c.getLayoutY());
        }
    }
    
    
    
    public void crearPuntos(){
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                Circle cir = new Circle();
                cir.setRadius(1);
                cir.setCenterX((i-20)*50);
                cir.setCenterY((j-20)*50);
                cir.setStrokeWidth(0);
                cir.setFill(Color.GREY.darker().darker());
                cirs.getChildren().add(cir);
            }
        }
    }
    
    
    public void crearBloque(Color c) {
        Pane p = new Bloque(30, 30, c);
        Grid.getChildren().add(p);
        bloques.add(p);
    }

}
