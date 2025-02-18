import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Opgave01 {

	public static void main(String[] args) {

		try {
			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Lektion3;user=sa;password=CARDONDB;";
			Connection minConnection = DriverManager.getConnection(url);

			//ToDO: Change query
			String query = "SELECT * FROM Opgaver";
			Statement stmt = minConnection.createStatement();


			ResultSet res = stmt.executeQuery(query);

			ResultSetMetaData metaData = res.getMetaData();
			int columnCount = metaData.getColumnCount();
			//OPGAVE 06 -- NEXT
			while (res.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(res.getString(i) + "\t");
				}
				System.out.println();
			}


			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();

		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			if (e.getErrorCode() == 547) System.out.println("FEJL: Klub har foreign key til hold");

		}

		catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
