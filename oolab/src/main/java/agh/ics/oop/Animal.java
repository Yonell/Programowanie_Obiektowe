package agh.ics.oop;

import java.util.Objects;
import java.util.Vector;

import static agh.ics.oop.MapDirection.*;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    private IWorldMap map;
    private Animal(){
        orientation = MapDirection.NORTH;
        position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map){
        this();
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this(map);
        position = initialPosition;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    @Override
    public String toString(){
        return (orientation.toString());
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        switch(direction){
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case BACKWARD -> {
                if(map.canMoveTo(position.subtract(orientation.toUnitVector())))
                    position = position.subtract(orientation.toUnitVector());
            }
            case FORWARD -> {
                if(map.canMoveTo(position.add(orientation.toUnitVector())))
                    position = position.add(orientation.toUnitVector());
            }
        }
    }
}
