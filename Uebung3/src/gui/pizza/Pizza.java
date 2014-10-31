package gui.pizza;

import java.util.Vector;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Pizza extends Application {
	@FXML
	private FlowPane ingridientContainer;

	@FXML
	private HBox pizzaSizesContainer;

	@FXML
	private TextArea textOut;

	private Configuration currentConfig;
	private Vector<Control> prizeElements;

	public Pizza() {
		super();
		currentConfig = new Configuration();
		prizeElements = new Vector<>();

	}

	@Override
	public void init() throws Exception {
		super.init();
		// initFields();
	};

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
					"Window.fxml"));
			fxmlLoader.setController(this);
			GridPane root = fxmlLoader.load();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pizza");
			primaryStage.show();
			initFields();
			// initFields((FlowPane)scene.lookup("#ingridientContainer"),(HBox)scene.lookup("#pizzaSizesContainer"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initFields(/*
							 * FlowPane ingridientContainer,HBox
							 * pizzaSizesContainer
							 */) {

		// generate ingridiense
		int tolock = currentConfig.getNumberOfDefaultToppings();
		for (int countTopping = 0; countTopping < currentConfig
				.getToppingNames().length; countTopping++) {

			int prize = currentConfig.getToppingPrices()[countTopping];
			String ingr = currentConfig.getToppingNames()[countTopping];

			CheckBox toping = new CheckBox(ingr);
			toping.setUserData(new Integer(prize));
			if (tolock > countTopping) {
				toping.setSelected(true);
				toping.setDisable(true);

			}
			ingridientContainer.getChildren().add(toping);
			prizeElements.addElement(toping);
		}

		// gernerate sizes
		ToggleGroup grp = new ToggleGroup();
		for (int countSizes = 0; countSizes < currentConfig.getSizeNames().length; countSizes++) {

			int prize = currentConfig.getSizePrices()[countSizes];
			String sizename = currentConfig.getSizeNames()[countSizes];

			RadioButton size = new RadioButton(sizename);
			size.setUserData(new Integer(prize));
			size.setToggleGroup(grp);
			size.setSelected(true);
			pizzaSizesContainer.getChildren().add(size);
			prizeElements.addElement(size);
		}
		// System.out.println(prizeElements.size());
	}

	private PizzaInfo getherPizzaInfo() {
		PizzaInfo pi = new PizzaInfo("", "", 0);
		// System.out.println(prizeElements.size());
		for (Control c : prizeElements) {
			// System.out.println(c.getUserData());
			if (c instanceof CheckBox) {
				CheckBox cb = (CheckBox) c;
				if (cb.isSelected()) {
					pi.prize += ((Integer) cb.getUserData()).intValue();
					pi.zutaten += cb.getText() + ", ";
				}
			} else if (c instanceof RadioButton) {
				RadioButton rb = (RadioButton) c;
				if (rb.isSelected()) {
					pi.prize += ((Integer) rb.getUserData()).intValue();
					pi.size = rb.getText();
				}
			}
		}
		return pi;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@FXML
	private void orderPizza() {
		StringBuilder sb = new StringBuilder();
		PizzaInfo pi = getherPizzaInfo();
		sb.append("Sie haben eine Pizza bestellt.\n");
		sb.append("Zutaten: ");
		sb.append(pi.zutaten.substring(0, pi.zutaten.length() - 2));
		sb.append("\n");
		sb.append("Die Größe ist: ");
		sb.append(pi.size);
		sb.append("\n");
		sb.append("Der Preis beträgt: ");
		sb.append(pi.prize / 100);
		sb.append(".");
		sb.append(pi.prize % 100);
		sb.append(" €");
		sb.append("\n");
		sb.append("Vielen Dank");
		textOut.setText(sb.toString());
	}
}
