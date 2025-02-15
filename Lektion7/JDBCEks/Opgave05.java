import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Opgave05 {

	public static void main(String[] args) {

		try {

			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Lektion3;user=sa;password=CARDONDB;";

			Connection minConnection;
			minConnection = DriverManager.getConnection(url);

			//Få antal medarbejder
			Statement statemet = minConnection.createStatement();
			ResultSet res = statemet.executeQuery("SELECT COUNT(*) FROM MEDARBEJDER");
			res.next();
			int count = res.getInt(1);
			System.out.println("Antal medarbejder er: \t" + count++);

//			Opret ny medarbejder

			//Kan også løses ved at have IDENTITY på tabelen, så undgår man skulle til at finde count
			String query = "INSERT INTO MEDARBEJDER VALUES (" + count + ", ?, ?, '11223344')";
			PreparedStatement pre = minConnection.prepareStatement(query);
			pre.clearParameters();

			Scanner scanner = new Scanner(System.in);
			System.out.println("Indtast navn: ");
			String navn = scanner.next();
			System.out.println("Indtast stilling: ");
			String stilling = scanner.next();

			pre.setString(1, navn);
			pre.setString(2, stilling);

			pre.executeQuery();

			if (res != null)
				res.close();
			if (minConnection != null)
				minConnection.close();
			if (pre != null)
				pre.close();
			if (statemet != null)
				statemet.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
