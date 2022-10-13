package agh.ics.oop;
import java.util.Arrays;

public class World {
    private static void run(Direction[] args){
        System.out.println();
        for(Direction argument : args)
        {
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzie w prawo";
                default -> "Nieznana komenda";
            };
            System.out.println(message);
        }
        System.out.println();
    }

    private static Direction[] switch_to_enum(String[] args){
        int len = 0;
        Direction[] args_enum = new Direction[args.length];
        for(int i=0; i<args.length; i+=1){
            switch (args[i]){
                case "f" -> {
                    args_enum[len] = Direction.FORWARD;
                    len += 1;
                }
                case "b" -> {
                    args_enum[len] = Direction.BACKWARD;
                    len += 1;
                }
                case "l" -> {
                    args_enum[len] = Direction.LEFT;
                    len += 1;
                }
                case "r" -> {
                    args_enum[len] = Direction.RIGHT;
                    len += 1;
                }
                default -> {break;}
            }
        }
        Direction[] args_enum_copy = Arrays.copyOfRange(args_enum, 0, len);
        return args_enum_copy;
    }

    private static void yield_the_arguments_to_the_console(String[] args){
        for(int i=0; i<args.length-1; i+=1){
            System.out.print(args[i]);
            System.out.print(", ");
        }
        System.out.print(args[args.length-1]);
    }

    public static void main(String[] args) {
        System.out.println("system wystartował");
        System.out.println();
        if(args.length == 0) {
            System.out.println("Zwierzak nie ma co robic, koncze dzialanie programu");
            System.exit(0);
        }
        yield_the_arguments_to_the_console(args);
        Direction[] args_enum = switch_to_enum(args);
        run(args_enum);

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(MapDirection.SOUTH.toUnitVector());

        System.out.println("system zakończył działanie");
    }
}
