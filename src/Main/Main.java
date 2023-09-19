
package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ventana.fxml"));

        primaryStage.setTitle("PROYECT SISTEMAS");

        // Obtener el tamaño de la pantalla
        Screen pantalla = Screen.getPrimary();
        javafx.geometry.Rectangle2D coordenadas = pantalla.getVisualBounds();

        // Configurar el tamaño de la ventana para que ocupe toda la pantalla
        primaryStage.setX(coordenadas.getMinX());
        primaryStage.setY(coordenadas.getMinY());
        primaryStage.setWidth(coordenadas.getWidth());
        primaryStage.setHeight(coordenadas.getHeight());

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
