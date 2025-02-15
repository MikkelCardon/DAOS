import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Opgave04 {
	
	public static void main(String[] args) {

		try {
			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Lektion3;user=sa;password=CARDONDB;";

			Connection minConnection;
			minConnection = DriverManager
					.getConnection(url);

			Statement stmt = minConnection.createStatement();
			ResultSet res = stmt.executeQuery("EXEC navnOgTelefon");

			while (res.next()) {
				System.out.println(res.getString(1) + "\t "+ res.getString(2));
			}


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
