import java.sql.*;
import java.util.Scanner;

public class Opgave08 {
	
	public static void main(String[] args) {

		try {
			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Master;user=sa;password=CARDONDB;";

			Connection minConnection;
			minConnection = DriverManager.getConnection(url);

			String query = "INSERT INTO TESTTYPE VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pre = minConnection.prepareStatement(query);
			pre.clearParameters();
			Scanner scanner = new Scanner(System.in);

			System.out.println("Set CHAR(10)");
			pre.setString(1, scanner.nextLine());

			System.out.println("Set VARCHAR30");
			pre.setString(2, scanner.nextLine());

			System.out.println("Set INT");
			pre.setInt(3, scanner.nextInt());

			System.out.println("Set DECIMAL(8,2) KOMMATAL");
			pre.setDouble(4, scanner.nextDouble());

			System.out.println("Set DATE");
			String date = scanner.next();
			pre.setDate(5, Date.valueOf(date));

			System.out.println("Set BIT");
			pre.setString(6, scanner.next());

			pre.executeUpdate();

			System.out.println("New TESTTYPE inserted");


			if (pre != null)
				pre.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}
}
