package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private List<Animal> animals = new ArrayList<>();
    private static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    private static Vector2d UPPER_BOUND; /* Yup, I know it's not a constant value,
    but I will still use it like that, because it's convenient */

    RectangularMap(int width, int height){
        UPPER_BOUND = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d dest){
        if(!(LOWER_BOUND.precedes(dest))) return false;
        if(!(UPPER_BOUND.follows(dest))) return false;
        if(isOccupied(dest)) return false;
        return objectAt(dest) == null;
    }

    @Override
    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition()))
            return false;
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal i : animals){
            if(i.isAt(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal i : animals){
            if(i.isAt(position)){
                return i;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(LOWER_BOUND, UPPER_BOUND);
    }
}
