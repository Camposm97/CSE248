package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Student;
import model.StudentBag;
import util.StringUtils;

public class StudentPane extends BorderPane {
	private StudentBag bag;
	private TextField tfFirstName, tfLastName, tfGPA, tfUsername, tfPassword;
	private Button btInsert, btFindById, btFindByLastName;
	private Button btDeleteById, btDeleteByLastName;
	
	public StudentPane(StudentBag bag) {
		this.bag = bag;
		initControls();
		displayControls();
	}
	
	private void initControls() {
		final int BTN_WIDTH = 160;
		tfFirstName = new TextField();
		tfLastName = new TextField();
		tfGPA = new TextField();
		tfUsername = new TextField();
		tfUsername.setEditable(false);
		tfPassword = new TextField();
		tfPassword.setEditable(false);
		btInsert = new Button("Insert");
		btInsert.setPrefWidth(BTN_WIDTH);
		btFindById = new Button("Find By ID");
		btFindById.setPrefWidth(BTN_WIDTH);
		btFindByLastName = new Button("Find By Last Name");
		btFindByLastName.setPrefWidth(BTN_WIDTH);
		btDeleteById = new Button("Delete By ID");
		btDeleteById.setPrefWidth(BTN_WIDTH);
		btDeleteByLastName = new Button("Delete By Last Name");
		btDeleteByLastName.setPrefWidth(BTN_WIDTH);
	}
	
	private GridPane loadStudentView() {
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.addRow(0, new Label("ID:"), new Label(String.valueOf(StringUtils.formatId(Student.currentID()))));
		gridPane.addRow(1, new Label("First Name:"), tfFirstName);
		gridPane.addRow(2, new Label("Last Name:"), tfLastName);
		gridPane.addRow(3, new Label("GPA:"), tfGPA);
		gridPane.addRow(4, new Label("Username:"), tfUsername);
		gridPane.addRow(5, new Label("Password:"), tfPassword);
		return gridPane;
	}
	
	private VBox loadBtns() {
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(btInsert, btFindById, btFindByLastName, btDeleteById, btDeleteByLastName);
		return vBox;
	}
	
	private void displayControls() {
		setCenter(loadStudentView());
		setRight(loadBtns());
	}
}
