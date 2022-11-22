package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void canMoveToTest(){
        IWorldMap map = new GrassField(10);
        assertTrue(map.canMoveTo(new Vector2d(3,2)));
        assertTrue(map.canMoveTo(new Vector2d(2,3)));
        assertTrue(map.canMoveTo(new Vector2d(-1,0)));
        assertTrue(map.canMoveTo(new Vector2d(0,-1)));
        assertTrue(map.canMoveTo(new Vector2d(1,1)));
        map.place(new Animal(map, new Vector2d(1, 1)));
        assertFalse(map.canMoveTo(new Vector2d(1,1)));
    }

    @Test
    public void placesAndIsOccupiedTest(){
        IWorldMap map = new GrassField(3);
        assertFalse(map.isOccupied(new Vector2d(1,1)));
        map.place(new Animal(map, new Vector2d(1, 1)));
        assertTrue(map.isOccupied(new Vector2d(1,1)));
    }

    @Test
    public void ObjectAtTest(){
        IWorldMap map = new GrassField(3);
        Animal animal = new Animal(map, new Vector2d(2,2));
        map.place(animal);
        assertEquals(animal, map.objectAt(new Vector2d(2,2)));
    }
}
