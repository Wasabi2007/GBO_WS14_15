package gui.properties;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class SliderListener extends Application {

    @FXML
    private Slider sliderMain;

    @FXML
    private Label sliderInfo;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxml = new FXMLLoader();
            // System.out.println(getClass().getResource("SliderListener.fxml"));
            fxml.setLocation(getClass().getResource("SliderListener.fxml"));
            fxml.setController(this);

            VBox root = (VBox) fxml.load();

            Scene scene = new Scene(root, 400, 400);

            primaryStage.setScene(scene);
            primaryStage.show();
            sliderMain.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> sliderInfo.setText(String.valueOf((double) newValue - (double) oldValue)));
        } catch (Exception e) {
            e.printStackTrace();
            // System.err.println(e.fillInStackTrace());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
