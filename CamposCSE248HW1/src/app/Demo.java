package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.StudentBag;
import util.Util;
import view.StudentPane;

public class Demo extends Application {
	private static final int MAX_SIZE = 4000;
	private StudentBag bag;
	private StudentPane root;
	
	@Override
	public void init() {
		bag = Util.emitStudentBag(MAX_SIZE);
		root = new StudentPane(bag);
	}
	
	@Override
	public void start(Stage stage) {
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
