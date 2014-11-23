package gui.graphics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MouseListeners extends Application
{
    public void start(Stage primaryStage)
    {
        Canvas canvas = new Canvas(800, 600);
        canvas.setOnMousePressed
        (
            e -> log("mouse pressed", e)
        );
        canvas.setOnMouseReleased
        (
            e -> log("mouse released", e)
        );
        canvas.setOnMouseClicked
        (
            e -> log("mouse clicked", e)
        );
        canvas.setOnMouseMoved
        (
            e -> log("mouse moved", e)
        );
        canvas.setOnMouseDragged
        (
        e -> log("mouse dragged", e)
        );
        canvas.setOnMouseEntered
        (
            e -> log("mouse entered", e)
        );
        canvas.setOnMouseExited
        (
            e -> log("mouse exited", e)
        );

        primaryStage.setTitle("Logging von Mausereignissen");
        Group root = new Group();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
    
    private void log(String action, MouseEvent e)
    {
        System.out.println(action + " at [" + 
                           e.getX() + ", " + 
                           e.getY() + "]");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
