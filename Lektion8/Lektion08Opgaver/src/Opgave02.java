

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave02 {

	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);

			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Lektion3;user=sa;password=CARDONDB;";
			Connection minConnection;
			minConnection = DriverManager.getConnection(url);


			String sql = "INSERT INTO opgave VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			System.out.println("OpgaveNr");
			prestmt.setInt(1, Integer.parseInt(scanner.nextLine()));

			System.out.println("Beskrivelse");
			prestmt.setString(2, scanner.nextLine());

			System.out.println("Prioritet");
			prestmt.setInt(3, Integer.parseInt(scanner.nextLine()));

			System.out.println("Forventet deadline");
			prestmt.setDate(4, Date.valueOf(scanner.nextLine()));

			System.out.println("deadline");
			prestmt.setDate(5, Date.valueOf(scanner.nextLine()));

			System.out.println("Status");
			prestmt.setString(6, scanner.nextLine());

			System.out.println("Projekt nr");
			prestmt.setInt(7, Integer.parseInt(scanner.nextLine()));

			System.out.println("OpgaveType ID");
			prestmt.setInt(8, Integer.parseInt(scanner.nextLine()));

			prestmt.executeUpdate();
			System.out.println("Oprettet Opgave");

			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();

		}
		catch (SQLException e){
			if (e.getErrorCode() == 547){
				if (e.getMessage().contains("checkPrioritet")){
					System.out.println("Fejl i input af Prioritet");
				} else if (e.getMessage().contains("checkStatus")) {
					System.out.println("Fejl i input af status på opgave");
				}
			}
			else{
				System.out.println(e.getMessage());
				System.out.println(e.getErrorCode());
			}
		}

		catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
