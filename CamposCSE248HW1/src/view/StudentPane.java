package view;

import java.util.InputMismatchException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.MissingFieldException;
import model.Student;
import model.StudentBag;
import util.StringUtil;
import util.Util;

public class StudentPane extends BorderPane {
	private static final int BTN_WIDTH = 160;
	private StudentBag bag;
	private Label lblId;
	private TextField tfFirstName, tfLastName, tfGpa, tfUsername, tfPassword;
	private Button btInsert, btFindById, btFindByLastName;
	private Button btDeleteById, btDeleteByLastName, btAverageGpa;

	public StudentPane(StudentBag bag) {
		this.bag = bag;
		initControls();
		displayControls();
	}

	private void initControls() {
		initFields();
		initBtns();
	}

	private void initFields() {
		lblId = new Label(StringUtil.formatId(Student.currentID()));
		tfFirstName = new TextField();
		tfLastName = new TextField();
		tfGpa = new TextField();
		tfUsername = new TextField();
		tfUsername.setEditable(false);
		tfPassword = new TextField();
		tfPassword.setEditable(false);
	}

	private void initBtns() {
		btInsert = loadBtInsert();
		btFindById = loadBtFindById();
		btFindByLastName = loadBtFindByLastName();
		btDeleteById = loadBtDeleteById();
		btDeleteByLastName = loadBtDeleteByLastName();
		btAverageGpa = loadBtAverageGpa();
	}

	private Button loadBtInsert() {
		Button bt = new Button("Insert");
		bt.setPrefWidth(BTN_WIDTH);
		bt.setOnAction(e -> {
			Student s = createStudent();
			if (s != null) {
				bag.insert(s);
				lblId.setText(StringUtil.formatId(Student.currentID()));
				Util.emitInfoAlert("Successfully Added Student", StringUtil.formatStudent(s));
			}
		});
		return bt;
	}

	private Button loadBtFindById() {
		Button bt = new Button("Find By ID");
		bt.setPrefWidth(BTN_WIDTH);
		bt.setOnAction(e -> {
			String result = Util.emitTextInputDialog("Please enter an ID:");
			Student s = bag.findById(result);
			if (s != null)
				displayStudent(s);
			else
				Util.emitErrorAlert("Sorry, we couldn't find the Student", "ID Entered: " + result);
		});
		return bt;
	}

	private Button loadBtFindByLastName() {
		Button bt = new Button("Find By Last Name");
		bt.setPrefWidth(BTN_WIDTH);
		bt.setOnAction(e -> {
			String result = Util.emitTextInputDialog("Please Enter a Last Name:");
			Student s = bag.findByLastName(result);
			if (s != null)
				displayStudent(s);
			else
				Util.emitErrorAlert("Sorry we couldn't find the Student", "Last Name Entered: " + result);
		});
		return bt;
	}

	private Button loadBtDeleteById() {
		Button bt = new Button("Delete By ID");
		bt.setPrefWidth(BTN_WIDTH);
		bt.setOnAction(e -> {
			String result = Util.emitTextInputDialog("Please enter an ID:");
			Student s = bag.deleteById(result);
			if (s != null) {
				Util.emitInfoAlert("Successfully Deleted Student", StringUtil.formatStudent(s));
			}
		});
		return bt;
	}
	
	private Button loadBtDeleteByLastName() {
		Button bt = new Button("Delete By Last Name");
		bt.setPrefWidth(BTN_WIDTH);
		bt.setOnAction(e -> {
			String result = Util.emitTextInputDialog("Please enter a last name:");
			Student s = bag.deleteByLastName(result);
			if (s != null) {
				Util.emitInfoAlert("Successfully deleted Student", StringUtil.formatStudent(s));
			}
		});
		return bt;
	}
	
	private Button loadBtAverageGpa() {
		Button bt = new Button("Get Average GPA");
		bt.setPrefWidth(BTN_WIDTH);
		bt.setOnAction(e -> {
			Util.emitInfoAlert("Average GPA: " + bag.getAverageGpa(), "Number of Students: " + bag.size());
		});
		return bt;
	}
	
	private GridPane loadStudentView() {
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.addRow(0, new Label("ID:"), lblId);
		gridPane.addRow(1, new Label("First Name:"), tfFirstName);
		gridPane.addRow(2, new Label("Last Name:"), tfLastName);
		gridPane.addRow(3, new Label("GPA:"), tfGpa);
		gridPane.addRow(4, new Label("Username:"), tfUsername);
		gridPane.addRow(5, new Label("Password:"), tfPassword);
		return gridPane;
	}

	private VBox loadBtns() {
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(10));
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(btInsert, btFindById, btFindByLastName, btDeleteById, btDeleteByLastName, btAverageGpa);
		return vBox;
	}

	private void displayControls() {
		setCenter(loadStudentView());
		setRight(loadBtns());
	}

	private void displayStudent(Student s) {
		lblId.setText(s.getId());
		tfFirstName.setText(s.getFirstName());
		tfLastName.setText(s.getLastName());
		tfGpa.setText(s.getGpa() + "");
		tfUsername.setText(s.getUsername());
		tfPassword.setText(s.getPassword());
	}

	private Student createStudent() {
		Student s = null;
		try {
			String firstName = tfFirstName.getText();
			if (firstName.isEmpty())
				throw new MissingFieldException("The first name field must be filled out.");
			String lastName = tfLastName.getText();
			if (lastName.isEmpty())
				throw new MissingFieldException("There last name field must be filled out.");
			double gpa = Double.valueOf(tfGpa.getText());
			if (gpa < 0.0 || gpa > 4.0) {
				throw new InputMismatchException("Invaid GPA!  The GPA can only be between 0.0 and 4.0");
			}
			s = new Student(firstName, lastName, gpa);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Error: " + e.getClass().getSimpleName());
			alert.setContentText("Message: " + e.getMessage());
			alert.showAndWait();
		}
		return s;
	}
}
