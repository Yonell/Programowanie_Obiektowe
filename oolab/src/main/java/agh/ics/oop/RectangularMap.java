package agh.ics.oop;

public class RectangularMap implements IWorldMap{

    private static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    private static Vector2d UPPER_BOUND;

    RectangularMap(int width, int height){
        UPPER_BOUND = new Vector2d(width, height)
    }

    public boolean canMoveTo(Vector2d dest){
        if(!(LOWER_BOUND.follows(dest))) return false;
        if(!(UPPER_BOUND.precedes(dest))) return false;
        if(isOccupied(dest)) return false;
        if(objectAt(dest) != null) return false;
        return true;
    }



}
