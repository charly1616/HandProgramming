package Bloques;

import Model.Bloque;
import javafx.scene.paint.Color;

public class BloquePedir extends BloqueCondicional {

    public BloquePedir(double x, double y) {
        super(x, y, "Pedir", Color.GREEN); // Puedes ajustar el nombre y el color según tus necesidades.
    }

    @Override
    public void Hacer() {
        if (evaluarSiguiente()) {
            // Si la condición es verdadera, ejecuta el bloque "if".
            super.Hacer();
        } else {
            // Si la condición es falsa, verifica si hay un bloque "elseif".
            Bloque siguiente = Siguiente();
            if (siguiente instanceof BloqueElif) {
                // Si hay un bloque "elseif", llámalo.
                siguiente.Hacer();
            } else {
                // Si no hay un bloque "elseif", verifica si hay un bloque "else".
                if (siguiente instanceof BloqueElse) {
                    // Si hay un bloque "else", llámalo.
                    siguiente.Hacer();
                }
            }
        }
    }
}
