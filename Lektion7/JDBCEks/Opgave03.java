import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Opgave03 {

    public static void main(String[] args) {

        try {
            System.out.println("Find telefon nummer ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Indtast navn: ");
            String navn = inLine.readLine();


            String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Lektion3;user=sa;password=CARDONDB;";
            Connection minConnection;
            minConnection = DriverManager.getConnection(url);
            //Lav query med parameter erstatet med '?'
            String sql = "SELECT navn, mobil FROM Medarbejder " +
                    "WHERE navn LIKE ? + '%'";// preparedStatement

            //Giv query
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1, navn);

            //Giv preparedStatement.
            //executeQuery retunerer et ResultSet
            ResultSet res = prestmt.executeQuery();

            while (res.next()) {
                System.out.println(res.getString(1) + "\t "+ res.getString(2));
            }

            if (prestmt != null)
                prestmt.close();
            if (minConnection != null)
                minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }

}
