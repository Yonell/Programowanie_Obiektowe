package agh.ics.oop;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Stream;


public class App extends Application {
    private AbstractWorldMap map;

    public void start(Stage primaryStage){
        List<String> args = getParameters().getRaw();
        MoveDirection[] directions = OptionsParser.parse(args.toArray(new String[0]));
        map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 400, 400);

        primaryStage.setScene(scene);
        grid.setGridLinesVisible(true);

        addMapToOutput(grid);
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));

        primaryStage.show();
    }

    private void addMapToOutput(GridPane grid) {
        grid.add(new Label("y/x"),0,0);
        for(int x = 0; x<=map.upperRightBound().x()-map.lowerLeftBound().x(); x++){
            grid.add(new Label(Integer.toString(x + map.lowerLeftBound().x())),x+1, 0);
        }
        for(int y = 0; y<=map.upperRightBound().y()-map.lowerLeftBound().y(); y++){
            grid.add(new Label(Integer.toString(map.upperRightBound().y() - y )),0, y+1);
        }
        for(int x = map.lowerLeftBound().x(); x<=map.upperRightBound().x(); x++){
            for(int y = map.upperRightBound().y(); y>=map.lowerLeftBound().y(); y--){
                if(map.objectAt(new Vector2d(x,y)) == null) {
                    grid.add(new Label(" "),
                            x - map.lowerLeftBound().x() + 1, map.upperRightBound().y() - y + 1);
                }else{
                    grid.add(new Label(map.objectAt(new Vector2d(x, y)).toString()),
                            x - map.lowerLeftBound().x() + 1, map.upperRightBound().y() - y + 1);
                }
            }
        }
    }


}