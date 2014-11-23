package gui.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Bezier extends Application
{
    private static final int DIAMETER = 10;
    private static final int RADIUS = DIAMETER/2;
    
    private Canvas canvas;

    public void start(Stage primaryStage)
    {
        canvas = new Canvas(600, 600);
        drawShapes();

        BorderPane root = new BorderPane();
        root.getChildren().add(canvas);
        primaryStage.setTitle("Bezier-Kurve");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
    
    private void drawShapes()
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.setFill(Color.RED);
        gc.fillOval(100-RADIUS, 100-RADIUS, DIAMETER, DIAMETER);
        gc.fillOval(200-RADIUS, 70-RADIUS, DIAMETER, DIAMETER);
        gc.fillOval(200-RADIUS, 200-RADIUS, DIAMETER, DIAMETER);
        gc.fillOval(125-RADIUS, 200-RADIUS, DIAMETER, DIAMETER);
        
        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.moveTo(100, 100);
        gc.bezierCurveTo(200, 70, 200, 200, 
                         125, 200);
        //gc.closePath();
        gc.stroke();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
