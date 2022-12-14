package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapBoundaryTest {
    @Test
    public void placeChangedPositionAndBoundariesTest(){
        MapBoundary calc = new MapBoundary();
        IWorldMap map = new GrassField(10);
        Animal a1 = new Animal(map, new Vector2d(2,3));
        map.place(a1);
        calc.place(a1);
        a1.addObserver(calc);
        assertEquals(new Vector2d(2,3), calc.lowerLeftBound());
        assertEquals(new Vector2d(2,3), calc.upperRightBound());
        Animal a2 = new Animal(map, new Vector2d(3,2));
        map.place(a2);
        calc.place(a2);
        a2.addObserver(calc);
        assertEquals(new Vector2d(2,2), calc.lowerLeftBound());
        assertEquals(new Vector2d(3,3), calc.upperRightBound());
        Animal a3 = new Animal(map, new Vector2d(-80,2));
        map.place(a3);
        calc.place(a3);
        a3.addObserver(calc);
        assertEquals(new Vector2d(-80,2), calc.lowerLeftBound());
        assertEquals(new Vector2d(3,3), calc.upperRightBound());
        a3.move(MoveDirection.RIGHT);
        a3.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(-79,2), calc.lowerLeftBound());
        assertEquals(new Vector2d(3,3), calc.upperRightBound());
    }
}
