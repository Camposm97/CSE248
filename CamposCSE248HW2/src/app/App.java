package app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
	private Parent root;
	@Override
	public void init() {
		root = new BorderPane();
	}
	
	@Override
	public void start(Stage stage) {
		stage.setScene(new Scene(root));
		stage.show();
	}
}
