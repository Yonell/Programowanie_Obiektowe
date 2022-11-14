package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    public void orientationChangeTest(){
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        assertEquals("<", animal.getOrientation().toString());
        animal.move(MoveDirection.LEFT);
        assertEquals("v", animal.getOrientation().toString());
        animal.move(MoveDirection.LEFT);
        assertEquals(">", animal.getOrientation().toString());
        animal.move(MoveDirection.LEFT);
        assertEquals("^", animal.getOrientation().toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals(">", animal.getOrientation().toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("v", animal.getOrientation().toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("<", animal.getOrientation().toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("^", animal.getOrientation().toString());
    }

    @Test
    public void positionChangeTest(){
        RectangularMap map = new RectangularMap(4,4);
        Animal animal = new Animal(map, new Vector2d(2,2));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,3)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,2)));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(1,2)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,2)));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,1)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,2)));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3,2)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,2)));
    }

    @Test
    public void mapBoundsTest(){
        RectangularMap map = new RectangularMap(5,5);
        Animal animal = new Animal(map, new Vector2d(2,2));
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,4)));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(0,4)));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(0,0)));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4,0)));
    }
}