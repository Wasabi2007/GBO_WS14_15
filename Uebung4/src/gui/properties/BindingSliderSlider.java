package gui.properties;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderSlider extends Application {

    @FXML
    private Slider slider1;

    @FXML
    private Slider slider2;

    @FXML
    private Slider slider3;

    @FXML
    private Slider sliderSum;

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader fxml = new FXMLLoader();
            // System.out.println(getClass().getResource("SliderListener.fxml"));
            fxml.setLocation(getClass().getResource("BindingSliderSlider.fxml"));
            fxml.setController(this);

            GridPane root = (GridPane) fxml.load();

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();

            sliderSum.valueProperty().bind(slider1.valueProperty().add(slider2.valueProperty()).add(slider3.valueProperty()));

        } catch (Exception e) {
            e.printStackTrace();
            // System.err.println(e.fillInStackTrace());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
