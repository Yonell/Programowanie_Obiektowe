package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){

        int counter = 0;
        MoveDirection[] potential = new MoveDirection[args.length];

        for(String arg : args){
            switch (arg){
                case "f", "forward" -> {
                    potential[counter] = MoveDirection.FORWARD;
                    counter+=1;
                }
                case "b", "backward" -> {
                    potential[counter] = MoveDirection.BACKWARD;
                    counter+=1;
                }
                case "l", "left" -> {
                    potential[counter] = MoveDirection.LEFT;
                    counter+=1;
                }
                case "r", "right" -> {
                    potential[counter] = MoveDirection.RIGHT;
                    counter+=1;
                }
                default -> {break;}
            }
        }

        return Arrays.copyOfRange(potential, 0, counter);
    }
}
