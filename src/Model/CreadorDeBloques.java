
package Model;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class CreadorDeBloques {
    
        public GridController cuadricula;
    
    public CreadorDeBloques(GridController panel){
        this.cuadricula = panel;
    }
    
    
    public void crearBloque(Color c) {
        Bloque p = new Bloque(Math.random()*00-00, Math.random()*000-00, c);
        cuadricula.hacerBloqueMovible(p);
        if (p.chorizontal != null) cuadricula.Grid.getChildren().add(p.chorizontal);
        p.setAncho(150);
        p.cvertical = new ConectorMultiple(p);
        cuadricula.Grid.getChildren().add(p.cvertical);
        cuadricula.Grid.getChildren().add(p.cvertical.inner);
//        if (p.cvertical != null) Grid.getChildren().add(p.cvertical);
        cuadricula.Grid.getChildren().add(p);
        cuadricula.bloques.add(p);
    }
    
    
}
