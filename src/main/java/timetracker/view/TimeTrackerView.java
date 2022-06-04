package timetracker.view;

import timetracker.model.activity.Activity;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TimeTrackerView extends Application{
	
	public TimeTrackerView(Stage stage, TimeTrackerViewable ttViewable) {
		this.stage = stage;
		this.ttViewable = ttViewable;
	}
	
	private Stage stage;
	private TimeTrackerViewable ttViewable;


	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("TimeTracker");
		
		
		Scene activityScene = getActivityScene();
		Scene chartScene = getChartScene();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private Scene getActivityScene() {
		StackPane activityLayout = new StackPane();
	 	Scene activityScene = new Scene(activityLayout, 800, 600);
	 	return activityScene;
	}
	
	private Scene getChartScene() {
		 Scene scene = new Scene(new Group());
	        stage.setTitle("Time divided on activities");
	        stage.setWidth(500);
	        stage.setHeight(500);
	 
	        ObservableList<PieChart.Data> pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data("Grapefruit", 13),
	                new PieChart.Data("Oranges", 25),
	                new PieChart.Data("Plums", 10),
	                new PieChart.Data("Pears", 22),
	                new PieChart.Data("Apples", 30));
	        final PieChart chart = new PieChart(pieChartData);
	        chart.setTitle("Imported Fruits");

	        ((Group) scene.getRoot()).getChildren().add(chart);
	        stage.setScene(scene);
	        stage.show();
	    }
}
