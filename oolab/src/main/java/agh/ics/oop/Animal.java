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
        if((this.position.x() == 0 && direction == MoveDirection.LEFT) || (this.position.x() == 4 && direction == MoveDirection.RIGHT) || (this.position.y() == 0 && direction == MoveDirection.BACKWARD) || (this.position.y() == 4 && direction == MoveDirection.FORWARD))
            return;
        switch (direction){
            case FORWARD -> this.position = this.position.add(new Vector2d(0,1));
            case BACKWARD -> this.position = this.position.add(new Vector2d(0,-1));
            case LEFT -> this.position = this.position.add(new Vector2d(-1,0));
            case RIGHT -> this.position = this.position.add(new Vector2d(1,0));
        }
        orientation = switch (direction){
            case LEFT -> WEST;
            case RIGHT -> EAST;
            case FORWARD -> NORTH;
            case BACKWARD -> SOUTH;
        };
    }
}
