package gui.charts;

import gui.people.Dialog;

import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LineChartSampleController {

	@FXML
	private LineChart<Number, Number> chart;

	@FXML
	private TableView<XYChart.Data<Number, Number>> kontoTable;
	
	@FXML
	private TableColumn<XYChart.Data<Number, Number>,Number> weekColum;
	
	@FXML
	private TableColumn<XYChart.Data<Number, Number>,Number> balanceColum;	
	
	@FXML
	private TextField weekTextfield;
	
	@FXML
	private TextField balanceTextfield;
	
	private int testDataAmount = 15;
	private ObservableList<XYChart.Data<Number, Number>> data;
	
	public void init(){
		
		Random r = new Random();
		
		data = FXCollections.observableArrayList();
		
		for(int valueIndex = 0, weekCount = -r.nextInt(10); valueIndex < testDataAmount; valueIndex++,weekCount+=r.nextInt(9)+1){
			data.add(new Data<Number, Number>(weekCount, r.nextInt(50)));
		}
		
		Series<Number, Number> Konto = new Series<>();
		Konto.setName("Konto 1337");
		Konto.setData(data);
		
		chart.getData().add(Konto);
		
		kontoTable.setItems(data);
		
		weekColum.setCellValueFactory(e -> e.getValue().XValueProperty());
		balanceColum.setCellValueFactory(e -> e.getValue().YValueProperty());
	}
	
	@FXML
	private void addChange(){
		try{
			int week = Integer.parseInt(weekTextfield.getText());
			int balance = Integer.parseInt(balanceTextfield.getText());
			
			FilteredList<XYChart.Data<Number, Number>> list = data.filtered(e -> e.getXValue().equals(week));
			
			if(list.size() > 0){
				list.get(0).setYValue(balance);
			}else{
				data.add(new Data<Number, Number>(week, balance));
			}
			
			data.sort((e1, e2) -> Integer.compare(
		            (Integer)e1.getXValue(), (Integer)e2.getXValue()));
			
		}catch(NumberFormatException e){
			Dialog.showButtonDialog("ERROR", "Es müssen nummern in den Feldern Stehen", "OK");
		}
	}
	
	@FXML
	private void delete(){
		SelectionModel<XYChart.Data<Number, Number>> selection = kontoTable.getSelectionModel();
		XYChart.Data<Number, Number> selected = selection.getSelectedItem();
		if(selected != null){
			data.remove(selected);
		}
		else{
			Dialog.showButtonDialog("ERROR", "Es muss ein Kontostand ausgewählt sein zum Löschen.", "OK");
		}
	}
}
