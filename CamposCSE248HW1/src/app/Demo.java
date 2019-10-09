package app;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.StudentBag;

public class Demo extends Application {
	private static final int MAX_SIZE = 4000;
	private StudentBag studentBag;
	private BorderPane root;
	
	@Override
	public void init() {
		studentBag = new StudentBag(MAX_SIZE);
		root = new BorderPane();
	}
	
	@Override
	public void start(Stage stage) {
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
