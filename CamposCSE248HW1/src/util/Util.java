package util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import model.NameFactory;
import model.StudentBag;
import model.StudentFactory;

public class Util {
	public static final String FIRST_NAMES_SRC = "First_Names.txt";
	public static final String LAST_NAMES_SRC = "Last_Names.txt";
	
	public static StudentBag emitStudentBag(int size) {
		StudentFactory fac = new StudentFactory();
		StudentBag bag = new StudentBag(size);
		for (int i = 0; i < (size / 2); i++) {
			bag.insert(fac.emitStudent());
		}
		return bag;
	}
	
	public static String emitTextInputDialog(String headerText) {
		TextInputDialog alert = new TextInputDialog();
		alert.setHeaderText(headerText);
		Optional<String> result = alert.showAndWait();
		if (result.isPresent())
			return result.get();
		return null;
	}
	
	public static void emitInfoAlert(String headerText, String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
	
	public static void emitErrorAlert(String headerText, String contentText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
}
