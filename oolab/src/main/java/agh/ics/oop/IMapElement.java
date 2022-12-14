package agh.ics.oop;

import agh.ics.oop.Vector2d;

import java.util.Objects;

public interface IMapElement {

    public Vector2d getPosition() ;

    public boolean isAt(Vector2d pos);
    public String getImagePath();

    public String getMapLabel();
}
