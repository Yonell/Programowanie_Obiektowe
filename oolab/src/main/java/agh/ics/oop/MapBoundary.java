package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    private final SortedSet<ClassTypeAndPositionTuple> objectsX = new TreeSet<>(ClassTypeAndPositionTuple.compareToByX);
    private final SortedSet<ClassTypeAndPositionTuple> objectsY = new TreeSet<>(ClassTypeAndPositionTuple.compareToByY);

    public MapBoundary(){
        return;
    }

    public void place(IMapElement object){
        objectsX.add(new ClassTypeAndPositionTuple(object.getPosition(), object.getClass()));
        objectsY.add(new ClassTypeAndPositionTuple(object.getPosition(), object.getClass()));
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        objectsX.remove(new ClassTypeAndPositionTuple(oldPosition, Animal.class)); 
        objectsX.add(new ClassTypeAndPositionTuple(newPosition, Animal.class));
        objectsY.remove(new ClassTypeAndPositionTuple(oldPosition, Animal.class));
        objectsY.add(new ClassTypeAndPositionTuple(newPosition, Animal.class));
    }
    public Vector2d lowerLeftBound(){
        return new Vector2d(objectsX.first().position().x(), objectsY.first().position().y());
    }
    public Vector2d upperRightBound(){
        return new Vector2d(objectsX.last().position().x(), objectsY.last().position().y());
    }
}
