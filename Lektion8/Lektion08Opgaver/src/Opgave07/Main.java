package Opgave07;

import java.sql.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		try {
			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Lektion3;user=sa;password=CARDONDB;";
			Connection minConnection = DriverManager.getConnection(url);
			String query = "SELECT * FROM Opgaver";
			Statement stmt = minConnection.createStatement();

			ResultSet res = stmt.executeQuery("SELECT * FROM medarbejder");
			ArrayList<Medarbejder> medarbejderArrayList = new ArrayList<>();
			//OPGAVE 06 -- NEXT
			while (res.next()) {
				Medarbejder medarbejder = new Medarbejder(
						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4)
				);
				medarbejderArrayList.add(medarbejder);
			}
			System.out.println(medarbejderArrayList);

			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();

		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}

		catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
