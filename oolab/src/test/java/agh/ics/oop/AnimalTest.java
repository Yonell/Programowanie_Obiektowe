package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    public void orientationChangeTest(){
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        assertEquals("Zachód", animal.getOrientation().toString());
        animal.move(MoveDirection.LEFT);
        assertEquals("Południe", animal.getOrientation().toString());
        animal.move(MoveDirection.LEFT);
        assertEquals("Wschód", animal.getOrientation().toString());
        animal.move(MoveDirection.LEFT);
        assertEquals("Północ", animal.getOrientation().toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("Wschód", animal.getOrientation().toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("Południe", animal.getOrientation().toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("Zachód", animal.getOrientation().toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("Północ", animal.getOrientation().toString());
    }

    @Test
    public void positionChangeTest(){
        Animal animal = new Animal();
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
        Animal animal = new Animal();
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