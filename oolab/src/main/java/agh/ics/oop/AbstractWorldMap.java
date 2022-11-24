package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap{

    protected Map<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition())) {
            return false;
        }
        animals.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeftBound(), upperRightBound());
    }

    protected abstract Vector2d upperRightBound();

    protected abstract Vector2d lowerLeftBound();
}
