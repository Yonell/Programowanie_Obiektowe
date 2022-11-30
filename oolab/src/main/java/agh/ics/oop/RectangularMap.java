package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{

    private static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    private static Vector2d upper_bound; /* upper bound inclusive */

    public RectangularMap(int width, int height){
        upper_bound = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d dest){
        return !(objectAt(dest) instanceof Animal) && LOWER_BOUND.precedes(dest) && upper_bound.follows(dest);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public Vector2d lowerLeftBound(){
        return LOWER_BOUND;
    }
    public Vector2d upperRightBound(){
        return upper_bound;
    }
}
