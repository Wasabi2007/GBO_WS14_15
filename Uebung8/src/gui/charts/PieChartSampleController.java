package gui.charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class PieChartSampleController {
	@FXML
	private PieChart chart;
	@FXML
	private GridPane sliderGrid;
	@FXML
	private TableView<PieChart.Data> obstTable;
	
	@FXML
	private TableColumn<PieChart.Data,String> obstColum;
	
	@FXML
	private TableColumn<PieChart.Data,Number> ammountColum;	
	
	public void init(){
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList 
				( 
				new PieChart.Data("Grapefruit", 13), 
				new PieChart.Data("Oranges", 25), 
				new PieChart.Data("Plums", 10), 
				new PieChart.Data("Pears", 22), 
				new PieChart.Data("Apples", 30) 
				);
		
		chart.setData(data);
		obstTable.setItems(data);
		
		obstColum.setCellValueFactory(e -> e.getValue().nameProperty());
		ammountColum.setCellValueFactory(e -> e.getValue().pieValueProperty());
		
		for(int itemIndex = 0; itemIndex < data.size(); itemIndex++ ){
			Slider slider = new Slider(0,100,data.get(itemIndex).getPieValue());
			slider.orientationProperty().set(Orientation.VERTICAL);
			slider.valueProperty().bindBidirectional(data.get(itemIndex).pieValueProperty());
			
			Label name = new Label(data.get(itemIndex).getName());
			
			sliderGrid.add(slider, itemIndex, 0);
			sliderGrid.add(name, itemIndex, 1);
		}
	}
	
}
