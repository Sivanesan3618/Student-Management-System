package Connection;

import java.sql.*;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db?user=root&password=siva");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
