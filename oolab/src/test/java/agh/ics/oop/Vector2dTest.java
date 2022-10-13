package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTest() {
        Vector2d vector1 = new Vector2d(1,0);
        Vector2d vector2 = new Vector2d(1,0);
        Vector2d vector3 = new Vector2d(0,0);
        assertTrue(vector1.equals(vector2));
        assertFalse(vector1.equals(vector3));
    }

    @Test
    public void toStringTest(){
        assertEquals(new Vector2d(1,2).toString(), "(1,2)");
    }

    @Test
    public void precedesTest() {
        assertTrue(new Vector2d(-1, -2).precedes(new Vector2d(0, 0)));
        assertFalse(new Vector2d(11, 12).precedes(new Vector2d(4, 4)));
        assertFalse(new Vector2d(5, 5).precedes(new Vector2d(6, 4)));
        assertFalse(new Vector2d(5, 5).precedes(new Vector2d(4, 6)));
    }

    @Test
    public void followsTest(){
        assertTrue(new Vector2d(11,12).follows(new Vector2d(3,4)));
        assertFalse(new Vector2d(-1,-2).follows(new Vector2d(0,0)));
        assertFalse(new Vector2d(5,5).follows(new Vector2d(6,4)));
        assertFalse(new Vector2d(5,5).follows(new Vector2d(4,6)));
    }

    @Test
    public void lowerLeftTest(){
        assertEquals(new Vector2d(4, 6).lowerLeft(new Vector2d(5,4)), new Vector2d(4,4));
    }

    @Test
    public void upperRightTest(){
        assertEquals(new Vector2d(4, 6).upperRight(new Vector2d(5,4)), new Vector2d(5,6));
    }

    @Test
    public void addTest(){
        assertEquals(new Vector2d(4, 6).add(new Vector2d(5, 4)), new Vector2d(9, 10));
    }

    @Test
    public void subtractTest(){
        assertEquals(new Vector2d(4, 6).subtract(new Vector2d(5, 4)), new Vector2d(-1, 2));
    }

    @Test
    public void oppositeTest(){
        assertEquals(new Vector2d(3, 4).opposite(), new Vector2d(-3, -4));
    }
}
