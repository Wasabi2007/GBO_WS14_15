package gui.country.combo;

import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Window extends Application {

    @FXML
    private ComboBox<Country> countryComp;

    @FXML
    private Label country;

    @FXML
    private Label capital;

    @FXML
    private Label size;

    @FXML
    private Label populationPerKm;

    @FXML
    private Label population;

    @FXML
    private CheckBox presion;

    @FXML
    private TextField countryTF;

    @FXML
    private TextField capitalTF;

    @FXML
    private TextField populationTF;

    @FXML
    private TextField arearTF;

    private Country selected;

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader toload = new FXMLLoader(getClass().getResource("Window.fxml"));
        toload.setController(this);
        Random r = new Random();
        try {
            GridPane root = (GridPane) toload.load();

            Scene scene = new Scene(root);

            countryComp.getItems().add(new Country("Miep", "capital", r.nextInt(100000), r.nextInt(10000000)));
            countryComp.getItems().add(new Country("Miep1", "capital", r.nextInt(100000), r.nextInt(10000000)));
            countryComp.getItems().add(new Country("Miep2", "capital", r.nextInt(100000), r.nextInt(10000000)));
            countryComp.getItems().add(new Country("Miep3", "capital", r.nextInt(100000), r.nextInt(10000000)));
            countryComp.getItems().add(new Country("Miep4", "capital", r.nextInt(100000), r.nextInt(10000000)));
            countryComp.getSelectionModel().select(0);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void changeCountry() {
        selected = countryComp.getSelectionModel().getSelectedItem();
        if (selected != null) {
            country.setVisible(true);
            capital.setVisible(true);
            populationPerKm.setVisible(true);
            population.setVisible(true);
            size.setVisible(true);

            country.setText(selected.getName());
            capital.setText(selected.getCapital());
            populationPerKm.setText(String.valueOf(((double) selected.getArea() / selected.getPeople())));

            population.setText((presion.isSelected() ? String.valueOf(selected.getPeople()) : (selected.getPeople() / 1000000d) + " Mill."));
            size.setText((presion.isSelected() ? String.valueOf(selected.getArea()) : (selected.getArea() / 1000000d) + " Mill."));
        } else {
            country.setVisible(false);
            capital.setVisible(false);
            populationPerKm.setVisible(false);
            population.setVisible(false);
            size.setVisible(false);
        }

    }

    @FXML
    private void setPresion() {
        if (selected != null) {
            population.setText((presion.isSelected() ? String.valueOf(selected.getPeople()) : (selected.getPeople() / 1000000d) + " Mill."));
            size.setText((presion.isSelected() ? String.valueOf(selected.getArea()) : (selected.getArea() / 1000000d) + " Mill."));
        }
    }

    @FXML
    private void addCountry() {
        countryComp.getItems().add(new Country(countryTF.getText(), capitalTF.getText(), Long.parseLong(populationTF.getText()), Long.parseLong(arearTF.getText())));
        countryTF.clear();
        capitalTF.clear();
        populationTF.clear();
        arearTF.clear();
    }

    @FXML
    private void deleteCountry() {
        if (countryComp.getItems().size() == 0){
            return;
        }

        int index = countryComp.getSelectionModel().getSelectedIndex();
        countryComp.getItems().remove(index);
        countryComp.getSelectionModel().select(index);
        
        if (countryComp.getItems().size() == 0){
            countryComp.getSelectionModel().select(null);
        }
    }

}
