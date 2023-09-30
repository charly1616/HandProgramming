package Bloques;

import Model.Bloque;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BloqueLabel extends Bloque {

    private StackPane stackPane;
    private Label label;
    private String Text;

    public BloqueLabel(double x, double y, Color ColorBloque, String Text) {
        super(x, y);
        this.Text = Text;
        this.ColorBloque = ColorBloque;
        IniciarComponentes();
        Pintar();
    }

    @Override
    public void IniciarComponentes() {
        super.IniciarComponentes();

        stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER_RIGHT);

        label = new Label(Text);

        Font font = new Font("Berlin Sans FB", 35);
        label.setFont(font);

        stackPane.getChildren().add(label);
        getChildren().add(stackPane);
    }

    private double computeTextWidth(javafx.scene.text.Font font, String text) {
        javafx.scene.text.Text textNode = new javafx.scene.text.Text(text);
        textNode.setFont(font);
        return textNode.getBoundsInLocal().getWidth();
    }

    @Override
    public void Pintar() {
        super.Pintar();
        double textWidth = computeTextWidth(label.getFont(), Text);

        stackPane.setPrefWidth(textWidth + 30);
        stackPane.setPrefHeight(65);
        setAncho(textWidth + 62);
        label.setVisible(true);
        System.out.println(Text);
    }
}