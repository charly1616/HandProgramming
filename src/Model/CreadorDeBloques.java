
package Model;

import Bloques.*;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class CreadorDeBloques {
    
        public GridController cuadricula;
    
    public CreadorDeBloques(GridController panel){
        this.cuadricula = panel;
    }
    
    
    
    //Crea un Bloque General, es una guia
    public void crearBloque(Color c, int x, int y) {
        Bloque p = new Bloque(x, y);
        cuadricula.hacerBloqueMovible(p);
        if (p.chorizontal != null) cuadricula.Grid.getChildren().add(p.chorizontal);
        p.setAncho(150);
        cuadricula.Grid.getChildren().add(p.cvertical);
        if (p.cvertical != null) cuadricula.Grid.getChildren().add(p.cvertical);
        cuadricula.Grid.getChildren().add(p);
        cuadricula.bloques.add(p);
    }
    
    
    
    
    
}
