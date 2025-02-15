import java.sql.*;
import java.util.Scanner;

public class Opgave07 {
	
	public static void main(String[] args) {

		try {
			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Lektion3;user=sa;password=CARDONDB;";

			Connection minConnection;
			minConnection = DriverManager
					.getConnection(url);

			Statement stmt = minConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet res = stmt.executeQuery("SELECT * FROM Medarbejder");

			ResultSetMetaData metaData = res.getMetaData();
			int columnCount = metaData.getColumnCount();
			//OPGAVE 06 -- NEXT
			while (res.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(res.getString(i) + "\t");
				}
				System.out.println();
			}

			//OPGAVE 06 ABSOULUTE
			//Positivt tal giver index fra front, negativt tal giver index fra enden
			Scanner scanner = new Scanner(System.in);
			int index = scanner.nextInt();
			if(res.absolute(index)){
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(res.getString(i) + "\t");
				}
				System.out.println();
			}
			//RESTEN AF opgaverne er en gentagelse.
			// NEXT, PREVIOUS, FIRST, LAST og ABSOLUTE er de der giver mening at bruge


			if (res != null)
				res.close();
			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}
}
