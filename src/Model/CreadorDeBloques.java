
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
    
    
    public void BloqueWhile(int x, int y){
        Bloque p = new BloqueWhile(x,y);
        cuadricula.hacerBloqueMovible(p);
        cuadricula.añadirBloque(p);
    }
    
    public void BloqueOPMAT(int x, int y, String signo){
        Bloque p = new BloqueMat(x,y,signo);
        cuadricula.hacerBloqueMovible(p);
        cuadricula.añadirBloque(p);
    }
    public void BloqueMostrar(int x, int y) {
    Bloque p = new BloqueMostrar(x, y);
    cuadricula.hacerBloqueMovible(p);
    cuadricula.añadirBloque(p);
}

public void BloqueIF(int x, int y) {
    Bloque p = new BloqueIF(x, y);
    cuadricula.hacerBloqueMovible(p);
    cuadricula.añadirBloque(p);
}

public void BloqueElif(int x, int y) {
    Bloque p = new BloqueElif(x, y);
    cuadricula.hacerBloqueMovible(p);
    cuadricula.añadirBloque(p);
}

public void BloqueElse(int x, int y) {
    Bloque p = new BloqueElse(x, y);
    cuadricula.hacerBloqueMovible(p);
    cuadricula.añadirBloque(p);
}

public void BloqueValor(int x, int y) {
    Bloque p = new BloqueValor(x, y);
    cuadricula.hacerBloqueMovible(p);
    cuadricula.añadirBloque(p);
}

public void BloqueFor(int x, int y) {
    Bloque p = new BloqueFor(x, y);
    cuadricula.hacerBloqueMovible(p);
    cuadricula.añadirBloque(p);
}

public void BloqueVariable(int x, int y) {
    Bloque p = new BloqueVariable(x, y);
    cuadricula.hacerBloqueMovible(p);
    cuadricula.añadirBloque(p);
}

public void BloquePedir(int x, int y) {
    Bloque p = new BloquePedir(x, y);
    cuadricula.hacerBloqueMovible(p);
    cuadricula.añadirBloque(p);
}

public void BloqueLogico(int x, int y, String signo) {
    Bloque p = new BloqueLogico(x, y, signo);
    cuadricula.hacerBloqueMovible(p);
    cuadricula.añadirBloque(p);
}

public void BloqueLMat(int x, int y, String signo) {
    Bloque p = new BloqueLMat(x, y, signo);
    cuadricula.hacerBloqueMovible(p);
    cuadricula.añadirBloque(p);
}
}
