package agh.ics.oop;

import java.util.Objects;
import java.util.Vector;

public class Grass extends MapObject {

    public Grass(Vector2d position){
        this.position = position;
        id = Objects.hash(position);
    }

    @Override
    public String toString() {
        return "*";
    }
}
