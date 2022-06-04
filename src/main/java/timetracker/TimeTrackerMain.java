package timetracker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import timetracker.model.TimeTrackerModel;
import timetracker.view.TimeTrackerView;

public class TimeTrackerMain extends Application implements EventHandler<ActionEvent> {

	Button button;
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		/*TimeTrackerModel ttModel = new TimeTrackerModel();
		TimeTrackerView ttView = new TimeTrackerView(primaryStage, ttModel);
		ttView.start(primaryStage);
		*/
		
		primaryStage.setTitle("Learning JavaFX");
		button = new Button("Clicky");
		button.setOnAction(this);
		
		StackPane pane = new StackPane();
		pane.getChildren().add(button);
		
		Scene scene = new Scene(pane, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource().equals(button))
			System.out.println("Button Press!!!");
	}

}
