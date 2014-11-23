package gui.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Nikolaus extends Application
{
    public void start(Stage primaryStage)
    {
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawLines(gc);

        BorderPane root = new BorderPane();
        root.getChildren().add(canvas);
        primaryStage.setTitle("Haus vom Nikolaus");
        primaryStage.setScene(new Scene(root, 330, 300));
        primaryStage.show();
    }

    private void drawLines(GraphicsContext gc)
    {
        gc.setStroke(Color.RED);
        gc.setLineWidth(3);
        gc.strokeLine(30, 200, 200, 200);
        gc.strokeLine(200, 200, 200, 100);
        gc.strokeLine(200, 100, 150, 50);
        gc.strokeLine(150, 50, 100, 100);
        gc.strokeLine(100, 100, 100, 200);
        gc.strokeLine(100, 200, 200, 100);
        gc.strokeLine(200, 100, 100, 100);
        gc.strokeLine(100, 100, 200, 200);
        gc.strokeLine(200, 200, 270, 200);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
