package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GuiElementBox {
    public GuiElementBox(IMapElement o){
        Image image = new Image(o.getImagePath());
        ImageView iv = new ImageView(image);
        iv.setFitHeight(20);
        iv.setFitWidth(20);
        Label label = new Label(o.toString());
        VBox vBox = new VBox(iv, label);
    }
}
