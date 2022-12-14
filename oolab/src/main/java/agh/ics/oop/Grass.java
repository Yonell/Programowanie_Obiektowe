package agh.ics.oop;

public class Grass extends AbstractMapElement {

    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String getImagePath() {
        return "src/main/resources/grass.png";
    }

    @Override
    public String getMapLabel() {
        return "Trawa";
    }
}
