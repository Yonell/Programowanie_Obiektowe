package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private VBox vBox;
    public GuiElementBox(IMapElement o) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(o.getImagePath()));
        ImageView iv = new ImageView(image);
        iv.setFitHeight(20);
        iv.setFitWidth(20);
        Label label = new Label(o.getMapLabel());
        vBox = new VBox(iv, label);
        vBox.setAlignment(Pos.CENTER);
    }
    public VBox getVBox(){
        return vBox;
    }
}
