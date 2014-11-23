package gui.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SomePaths extends Application
{
    public void start(Stage primaryStage)
    {
        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawPaths(gc);

        BorderPane root = new BorderPane();
        root.getChildren().add(canvas);
        primaryStage.setTitle("Einige Pfade");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void drawPaths(GraphicsContext gc)
    {
        gc.beginPath();
        gc.moveTo(50, 50);
        gc.lineTo(100, 50);
        gc.lineTo(100, 100);
        gc.setStroke(Color.RED);
        gc.setLineWidth(3);
        gc.stroke();
        
        gc.beginPath();
        gc.moveTo(100, 100);
        gc.lineTo(150, 100);
        gc.lineTo(150, 150);
        gc.closePath();
        gc.setStroke(Color.GREEN);
        gc.closePath();
        gc.setLineWidth(7);
        gc.stroke();

        gc.beginPath();
        gc.arc(100, 200, 50, 50, 0, 180);
        gc.lineTo(50, 300);
        gc.setFill(Color.BLUE);
        gc.fill();
        
        gc.beginPath();
        gc.arc(220, 200, 50, 50, 0, 180);
        gc.lineTo(170, 300);
        gc.quadraticCurveTo(220, 450, 270, 300);
        gc.setStroke(Color.BLUE);
        gc.stroke();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
