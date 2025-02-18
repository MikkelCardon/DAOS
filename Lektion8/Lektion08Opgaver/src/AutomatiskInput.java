

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AutomatiskInput {

	public static void main(String[] args) {

		try {
			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Lektion3;user=sa;password=CARDONDB;";
			Connection minConnection;
			minConnection = DriverManager.getConnection(url);

			/* PREPARED STATEMENT */
			String sql = "INSERT INTO opgave VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			autoGetInput.setInput(minConnection, prestmt, "opgave");

			prestmt.executeUpdate();


			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();

		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			if (e.getErrorCode() == 547){
				System.out.println("CONSTRAINT");
			}
		}

		catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}



}
