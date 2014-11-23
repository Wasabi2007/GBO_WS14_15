package gui.properties;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderProgress extends Application {
    @FXML
    private Slider slider;

    @FXML
    private ProgressBar progesbar;

    @FXML
    private ProgressIndicator progressind;

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader fxml = new FXMLLoader();
            // System.out.println(getClass().getResource("SliderListener.fxml"));
            fxml.setLocation(getClass().getResource("BindingSliderProgress.fxml"));
            fxml.setController(this);

            GridPane root = (GridPane) fxml.load();

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();
            progesbar.progressProperty().bind(slider.valueProperty().divide(slider.getMax()));
            progressind.progressProperty().bind(slider.valueProperty().divide(slider.getMax()));

        } catch (Exception e) {
            e.printStackTrace();
            // System.err.println(e.fillInStackTrace());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
