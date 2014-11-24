package gui.graphics;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Drawing extends Application
{
    private GraphicsContext gc;
    private double x, y;
    private double linewidth;
    private Color color;
    
    public void start(Stage primaryStage)
    {
        Canvas canvas = new Canvas(800, 600);
        linewidth = 1;
        color = Color.BLACK;
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(color);
        gc.setLineWidth(linewidth);
        canvas.setOnMousePressed
        (
            e -> mousePressed(e.getX(), e.getY())
        );
        canvas.setOnMouseDragged
        (
            e -> mouseDragged(e.getX(), e.getY())
        );

        BorderPane root = new BorderPane();
        root.centerProperty().set(canvas);
        
        HBox hb = new HBox();
        
        ComboBox<String> size = new ComboBox<>();
        size.setEditable(true);
        for(double s = 1; s <= 12; s+=1.0)
            size.getItems().add(String.valueOf(s));
        
        size.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // TODO Auto-generated method stub
                try
                {
                    linewidth = Double.parseDouble(newValue);
                    gc.setLineWidth(linewidth);
                }
                catch(Exception e){
                    System.err.println("Illegale Nummer");
                }
            }
        });
        hb.getChildren().add(size);
        
        ComboBox <String> colors = new ComboBox<>();
        colors.setEditable(true);
        colors.getItems().add("RED");
        colors.getItems().add("BLUE");
        colors.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // TODO Auto-generated method stub
                try
                {
                    gc.setStroke(Color.valueOf(newValue));
                    if(!colors.getItems().contains(newValue)){
                        colors.getItems().add(newValue);
                    }
                }
                catch(Exception e){
                    System.err.println("Illegale Farbe");
                }
            }
        });
        hb.getChildren().add(colors);
        
        Button loeschen = new Button("Löschen");
        loeschen.setOnAction(e -> {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });
        hb.getChildren().add(loeschen);
        
        root.topProperty().set(hb);
        
        primaryStage.setTitle("Freihandzeichnen");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void mousePressed(double newX, double newY)
    {
        x = newX;
        y = newY;
        mouseDragged(x, y);
    }

    private void mouseDragged(double newX, double newY)
    {
        gc.strokeLine(x, y, newX, newY);
        x = newX;
        y = newY;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
