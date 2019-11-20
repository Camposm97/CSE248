package p10_SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {	
	private static final String CONNECT_TO_DB = "jdbc:sqlite:StudentDB.sqlite";
	private static final String DROP_TABLE_STUDENT = "drop table if exists Student";
	private static final String CREATE_TABLE_STUDENT = ""
			+ "CREATE TABLE Student ("
			+ "id INT AUTO_INCREMENT,"
			+ "firstName VARCHAR(32), "
			+ "lastName VARCHAR(32), "
			+ "gpa DECIMAL (1.1), "
			+ "PRIMARY KEY (id)"
			+ ");";
	private static final String INSERT_STUDENT = "INSERT INTO Student (firstName, lastName, gpa) Values ";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection(CONNECT_TO_DB);
		Statement statement = conn.createStatement();
		statement.executeUpdate(DROP_TABLE_STUDENT); // Start From Scratch if table exists
		statement.executeUpdate(CREATE_TABLE_STUDENT);
		statement.executeUpdate(INSERT_STUDENT + "('Adam', 'Smith', 3.9)");
		statement.executeUpdate(INSERT_STUDENT + "('Bill', 'Smith', 3.2)");
		statement.executeUpdate(INSERT_STUDENT + "('Michael', 'Campos', 4.0)");
		ResultSet rs = statement.executeQuery("SELECT * FROM Student");
		while(rs.next()) {
			int id = rs.getInt("id");
			
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			double gpa = rs.getDouble("gpa");
			System.out.printf("%-10d%-32s%-32s%1.1f%n", id, firstName, lastName, gpa);
		}
		conn.close();
	}
}
