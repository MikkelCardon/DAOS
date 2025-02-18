

import java.sql.*;
import java.util.Scanner;

public class Opgave06 {

	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);

			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Lektion3;user=sa;password=CARDONDB;";
			Connection minConnection;
			minConnection = DriverManager.getConnection(url);


			String sql = "INSERT INTO Tidsregistrering (starttid, sluttid, beskrivelseAfArbejde, datoRegistering, medarbejderNr, opgaveNr)\n" +
					"VALUES (?,?,?,?,?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			System.out.println("StartTid");
			prestmt.setTime(1, Time.valueOf(scanner.next()));
			System.out.println("slutTid");
			prestmt.setTime(2, Time.valueOf(scanner.next()));
			System.out.println("beskrivelse");
			prestmt.setString(3, scanner.next());
			System.out.println("datoRegistrering");
			prestmt.setDate(4, Date.valueOf(scanner.next()));
			System.out.println("medarbejderId");
			prestmt.setInt(5, scanner.nextInt());
			System.out.println("opgave nr");
			prestmt.setInt(6, scanner.nextInt());

			
			prestmt.executeUpdate();
			System.out.println("Oprettet tidsregisrering");

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
