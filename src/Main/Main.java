
package Main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Crear una escena con StackPane para superponer la barra de progreso y el fondo
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

        //Cargo la imagen
        Image backgroundImage = new Image("background.jpg"); // Reemplaza "background.jpg" con la ubicación de tu imagen
        ImageView backgroundImageView = new ImageView(backgroundImage);
        rootPane.getChildren().add(backgroundImageView);

        // Crear barra
        ProgressBar progressBar = new ProgressBar();
        progressBar.setPrefWidth(300);

        
        progressBar.setStyle("-fx-accent: orange;"); 
        progressBar.getStyleClass().add("animated-progress-bar");
        rootPane.getChildren().add(progressBar);

        primaryStage.show();

        // Simular la carga gradual con una animación
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, event -> progressBar.setProgress(0.0)),
            new KeyFrame(Duration.seconds(3), event -> progressBar.setProgress(1.0))
        );
        timeline.setCycleCount(1); // Ejecutar una vez
        timeline.play();

        
        
        
        //Programa
        timeline.setOnFinished(event -> {
            try {
                // Cargar la ventana principal
                Parent mainRoot = FXMLLoader.load(getClass().getResource("ventana.fxml"));
                Scene mainScene = new Scene(mainRoot);
                primaryStage.setScene(mainScene);
                primaryStage.setTitle("PROYECTO SISTEMAS");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Ocultar la imagen de fondo y mostrar la ventana principal
                rootPane.getChildren().remove(backgroundImageView);
                rootPane.getChildren().remove(progressBar);
                primaryStage.show();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}