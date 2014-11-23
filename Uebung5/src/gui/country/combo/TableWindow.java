package gui.country.combo;

import java.util.Random;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TableWindow extends Application {
    

    private ObservableList<CountryPropertyWrapper> countryComp;

    @FXML
    private TableView<CountryPropertyWrapper> tableCountry;

    @FXML
    private TableColumn<CountryPropertyWrapper, String> countryCol;

    @FXML
    private TableColumn<CountryPropertyWrapper, Number> arearCol;

    @FXML
    private TableColumn<CountryPropertyWrapper, String> capitalCol;

    @FXML
    private TableColumn<CountryPropertyWrapper, Number> populationCol;

    @FXML
    private TableColumn<CountryPropertyWrapper, Number> popPerkmCol;

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
    private SimpleDoubleProperty persion;

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader toload = new FXMLLoader(getClass().getResource("TableWindow.fxml"));
        toload.setController(this);
        persion = new SimpleDoubleProperty(1000000);
        Random r = new Random();
        try {
            GridPane root = (GridPane) toload.load();

            Scene scene = new Scene(root);

            tableCountry.getItems().add(new CountryPropertyWrapper("Miep", "capital", r.nextInt(10000000), r.nextInt(100000000)));
            tableCountry.getItems().add(new CountryPropertyWrapper("Miep1", "capital", r.nextInt(10000000), r.nextInt(100000000)));
            tableCountry.getItems().add(new CountryPropertyWrapper("Miep2", "capital", r.nextInt(10000000), r.nextInt(100000000)));
            tableCountry.getItems().add(new CountryPropertyWrapper("Miep3", "capital", r.nextInt(10000000), r.nextInt(100000000)));
            tableCountry.getItems().add(new CountryPropertyWrapper("Miep4", "capital", r.nextInt(10000000), r.nextInt(100000000)));

            countryCol.setCellValueFactory(item -> item.getValue().getName());
            arearCol.setCellValueFactory(item -> item.getValue().getArea().divide(persion));
            capitalCol.setCellValueFactory(item -> item.getValue().getCapital());
            populationCol.setCellValueFactory(item -> item.getValue().getPeople().divide(persion));
            popPerkmCol.setCellValueFactory(item -> new SimpleDoubleProperty(item.getValue().getPeople().get()).divide(item.getValue().getArea()));

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void setPresion() {
        if(persion.get() == 1)
            persion.set(1000000);
        else
            persion.set(1);
    }

    @FXML
    private void addCountry() {
        tableCountry.getItems().add(new CountryPropertyWrapper(countryTF.getText(), capitalTF.getText(), Long.parseLong(populationTF.getText()), Long.parseLong(arearTF.getText())));
        countryTF.clear();
        capitalTF.clear();
        populationTF.clear();
        arearTF.clear();
    }

    @FXML
    private void deleteCountry() {

        if (tableCountry.getItems().size() == 0) {
            return;
        }

        int index = tableCountry.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            return;
        }
        tableCountry.getItems().remove(index);
        tableCountry.getSelectionModel().select(index);

        if (tableCountry.getItems().size() == 0) {
            tableCountry.getSelectionModel().select(null);
        }

    }

}
