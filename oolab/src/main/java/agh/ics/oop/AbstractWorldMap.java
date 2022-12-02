package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected Map<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition())) {
            return false;
        }
        animals.put(animal.getPosition(), animal);
        animal.addObserver(this);
        return true;
    }

    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeftBound(), upperRightBound());
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    protected abstract Vector2d upperRightBound();

    protected abstract Vector2d lowerLeftBound();

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.remove(oldPosition);
        System.out.println(animal.getPosition() == newPosition);
        animals.put(newPosition, animal);
    }
}
