package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal extends AbstractMapElement {
    private MapDirection orientation;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    private IWorldMap map;
    private Animal(){
        orientation = MapDirection.NORTH;
        super.position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map){
        this();
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this(map);
        position = initialPosition;
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    @Override
    public String toString(){
        return (orientation.toString());
    }

    public void move(MoveDirection direction){
        switch(direction){
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case BACKWARD -> {
                if(map.canMoveTo(position.subtract(orientation.toUnitVector()))) {
                    positionChanged(position, position.subtract(orientation.toUnitVector()));
                    position = position.subtract(orientation.toUnitVector());
                }
            }
            case FORWARD -> {
                if(map.canMoveTo(position.add(orientation.toUnitVector()))) {
                    positionChanged(position, position.add(orientation.toUnitVector()));
                    position = position.add(orientation.toUnitVector());
                }
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.removeIf(i -> Objects.equals(observer, i));
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver i : observers) {
            i.positionChanged(oldPosition, newPosition);
        }
    }
    public String getImagePath(){
        return switch (orientation){
            case NORTH -> "src/main/resources/animalN.png";
            case SOUTH -> "src/main/resources/animalS.png";
            case WEST -> "src/main/resources/animalW.png";
            case EAST -> "src/main/resources/animalE.png";
        };
    }

    @Override
    public String getMapLabel() {
        return position.toString();
    }
}
