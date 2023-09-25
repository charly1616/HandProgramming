package Main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Crear una escena con StackPane para superponer el fondo
        StackPane rootPane = new StackPane();
        Scene loadingScene = new Scene(rootPane);

        // Configurar el tamaño de la ventana de carga para que ocupe toda la pantalla
        Screen pantalla = Screen.getPrimary();
        javafx.geometry.Rectangle2D coordenadas = pantalla.getVisualBounds();
        primaryStage.setX(coordenadas.getMinX());
        primaryStage.setY(coordenadas.getMinY());
        primaryStage.setWidth(coordenadas.getWidth());
        primaryStage.setHeight(coordenadas.getHeight());

        primaryStage.setScene(loadingScene);

        // Cargar la imagen de fondo
        Image backgroundImage = new Image("2.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        rootPane.getChildren().add(backgroundImageView);
        
        primaryStage.show();

        // Simular la carga gradual con una animación
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, event -> {
                }),
                new KeyFrame(Duration.seconds(3), event -> {
                    try {
                        Parent mainRoot = FXMLLoader.load(getClass().getResource("ventana.fxml"));
                        Scene mainScene = new Scene(mainRoot);
                        primaryStage.setScene(mainScene);
                        primaryStage.setTitle("PROYECTO SISTEMAS");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        // Ocultar la imagen de fondo y mostrar la ventana principal
                        rootPane.getChildren().remove(backgroundImageView);
                    }
                })
        );
        timeline.setCycleCount(1); // Ejecutar una vez
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
