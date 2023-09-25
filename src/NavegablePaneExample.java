import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class NavegablePaneExample extends Application {
    private Pane pane;
    private double lastMouseX, lastMouseY;
    private double scale = 1.0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        pane = new Pane();
        
        Rectangle rect1 = new Rectangle(50, 50, 100, 100);
        Rectangle rect2 = new Rectangle(200, 200, 100, 100);
        pane.getChildren().addAll(rect1, rect2);
        pane.setStyle("-fx-background-color: rgba(0, 100, 100, 1); -fx-background-radius: 10;");
        
        root.setCenter(pane);

        root.setOnMousePressed(event -> {
            lastMouseX = event.getSceneX();
            lastMouseY = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - lastMouseX;
            double deltaY = event.getSceneY() - lastMouseY;
            pane.setTranslateX(pane.getTranslateX() + deltaX);
            pane.setTranslateY(pane.getTranslateY() + deltaY);
            lastMouseX = event.getSceneX();
            lastMouseY = event.getSceneY();
        });

        root.setOnScroll((ScrollEvent event) -> {
            double deltaY = event.getDeltaY();
            double scaleFactor = (deltaY > 0) ? 1.1 : 0.9;
            scale *= scaleFactor;
            pane.setScaleX(scale);
            pane.setScaleY(scale);
        });

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Navegable Pane Example");
        primaryStage.show();
    }
}