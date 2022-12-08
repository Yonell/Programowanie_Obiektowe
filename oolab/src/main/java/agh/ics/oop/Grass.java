package agh.ics.oop;

import java.util.Objects;
import java.util.Vector;

public class Grass extends MapElement {

    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String getImagePath() {
        return "resources/grass.png";
    }
}
