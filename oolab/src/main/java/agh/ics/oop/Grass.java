package agh.ics.oop;

import java.util.Objects;
import java.util.Vector;

public class Grass {
    private Vector2d position;

    public Grass(Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    public boolean isAt(Vector2d pos){
        return Objects.equals(position, pos);
    }

    @Override
    public String toString() {
        return "*";
    }
}
