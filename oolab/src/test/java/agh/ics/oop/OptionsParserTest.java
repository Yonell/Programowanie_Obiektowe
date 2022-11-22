package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    public void parserTest(){
        String[] args = new String[]{"f", "b", "l", "r", "dsgsvcz", "", "forward", "backward", "left", "right"};
        MoveDirection[] directions = parse(args);
        MoveDirection[] expected = new MoveDirection[]{MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.RIGHT};
        assertArrayEquals(expected, directions);
    }
}