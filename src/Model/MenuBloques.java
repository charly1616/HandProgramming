
package Model;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class MenuBloques extends VBox{
    
    private CreadorDeBloques creadorb;
    
    
    
    public MenuBloques(CreadorDeBloques creadorb) {
        this.creadorb = creadorb;
        inicializar();
    }
    
    
    
    
    
    public void inicializar(){
        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setPrefHeight(342.0);
        setPrefWidth(66.0);
        setSpacing(12.0);
        this.setLayoutX(20);
        this.setLayoutY(300);
        
        setStyle("-fx-background-color: #E7E7E7;");

        
          // Botón 9
            Button button9 = createButton("/Images/For.png", "#EA4E00");
        getChildren().add(button9);
        button9.setOnAction(e -> {
            crearFor();
        });
        
        // Botón 1
        Button button1 = createButton("/Images/Box.png", "#FFA917");
        getChildren().add(button1);
        button1.setOnAction(e -> {
            crearVar();
        });

        // Botón 2
        Button button2 = createButton("/Images/Tags_3.png", "#F3FD8B");
        getChildren().add(button2);
        button2.setOnAction(e -> {
            crearDat();
        });

        // Separador
        Separator separator1 = new Separator();
        separator1.setPrefWidth(200.0);
        getChildren().add(separator1);


        // Botón 3
        Button button3 = createButton("/Images/Repeat.png", "#A77CE0");
        getChildren().add(button3);
        button3.setOnAction(e -> {
            crearWhile();
        });

        // Botón 4
        Button button4 = createButton("/Images/if.png", "#88DBFF");
        getChildren().add(button4);
        button4.setOnAction(e -> {
            crearIf();
        });
        
        // Botón 0
        Button button0 = createButton("/Images/Else.png", "#0DF7A9");
        getChildren().add(button0);
        button0.setOnAction(e -> {
            crearElse();
        });
        
        // Botón 01
        Button button01 = createButton("/Images/Multicast.png", "#01D527");
        getChildren().add(button01);
        button01.setOnAction(e -> {
            crearElif();
        });

        // Separador
        Separator separator3 = new Separator();
        separator3.setPrefWidth(200.0);
        getChildren().add(separator3);

        // Botón 5
        Button button5 = createButton("/Images/Next.png", "#FF6D87");
        getChildren().add(button5);
        button5.setOnAction(e -> {
            crearMostrar();
        });

        // Botón 6
        Button button6 = createButton("/Images/Input.png", "#7EAA00");
        getChildren().add(button6);
        button6.setOnAction(e -> {
            System.out.println("Pedir");
            crearPedir();
        });
        
        
        
        // Padding
        setPadding(new Insets(20.0));

    }
    
    
    
    
    private void crearMostrar(){
        creadorb.BloqueMostrar(400 - (int)creadorb.cuadricula.Grid.getTranslateX(), 300 - (int)creadorb.cuadricula.Grid.getTranslateY());
    }
    
     private void crearElif(){
        creadorb.BloqueElif(400 - (int)creadorb.cuadricula.Grid.getTranslateX(), 300 - (int)creadorb.cuadricula.Grid.getTranslateY());
    }
    private void crearFor(){
        creadorb.BloqueFor(400 - (int)creadorb.cuadricula.Grid.getTranslateX(), 300 - (int)creadorb.cuadricula.Grid.getTranslateY());
    }
    
        private void crearElse(){
        creadorb.BloqueElse(400 - (int)creadorb.cuadricula.Grid.getTranslateX(), 300 - (int)creadorb.cuadricula.Grid.getTranslateY());
    }
    private void crearWhile(){
        creadorb.BloqueWhile(400 - (int)creadorb.cuadricula.Grid.getTranslateX(), 300 - (int)creadorb.cuadricula.Grid.getTranslateY());
    }
    
    private void crearDat(){
        creadorb.BloqueValor(400 - (int)creadorb.cuadricula.Grid.getTranslateX(), 300 - (int)creadorb.cuadricula.Grid.getTranslateY());
    }
    
    
    private void crearVar(){
        creadorb.BloqueVariable(400 - (int)creadorb.cuadricula.Grid.getTranslateX(), 300 - (int)creadorb.cuadricula.Grid.getTranslateY());
    }
    
    private void crearPedir(){
        creadorb.BloquePedir(400 - (int)creadorb.cuadricula.Grid.getTranslateX(), 300 - (int)creadorb.cuadricula.Grid.getTranslateY());
    }
    
    
    private void crearIf(){
        creadorb.BloqueIF(400 - (int)creadorb.cuadricula.Grid.getTranslateX(), 300 - (int)creadorb.cuadricula.Grid.getTranslateY());
    }
    
    
    private Button createButton(String imageUrl, String backgroundColor) {
        Button button = new Button();
        try {
            ImageView i = new ImageView(new Image(imageUrl));
            i.setFitHeight(25);
            i.setFitWidth(25);
            button.setGraphic(i);
        } catch (Exception e) {
            System.out.println("Error al cargar imagen uwu");
        }
        
        button.setGraphicTextGap(2.0);
        button.setMinHeight(Button.USE_PREF_SIZE);
        button.setMinWidth(Button.USE_PREF_SIZE);
        button.setMnemonicParsing(false);
        button.setPrefHeight(35.0);
        button.setPrefWidth(35.0);
        button.setStyle("-fx-background-color: " + backgroundColor + "; -fx-border-radius: 25;");

        return button;
    }
    
}
