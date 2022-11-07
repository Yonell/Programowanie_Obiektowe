package agh.ics.oop;

import java.util.Vector;

import static agh.ics.oop.MapDirection.*;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    public Animal(){
        orientation = MapDirection.NORTH;
        position = new Vector2d(2,2);
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    @Override
    public String toString(){
        return ("Location: " + position.toString() + "\nOrientation: " + orientation);
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        switch(direction){
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case BACKWARD -> position = position.subtract(orientation.toUnitVector());
            case FORWARD -> position = position.add(orientation.toUnitVector());
        }

        position = position.upperRight(new Vector2d(0,0));
        position = position.lowerLeft(new Vector2d(4,4));
    }
}
