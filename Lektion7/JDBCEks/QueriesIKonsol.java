import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class QueriesIKonsol {

    public static void main(String[] args) {

        try {

            String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=Lektion3;user=sa;password=CARDONDB;";

            Connection minConnection;
            minConnection = DriverManager.getConnection(url);
            Scanner scanner = new Scanner(System.in);

            String query = "SELECT name AS tabelNavne FROM sys.tables";
            Statement statemet = minConnection.createStatement();
            ResultSet res = null;
            while(!query.equals("close")){
                res = statemet.executeQuery(query);

                if (!res.isBeforeFirst()){
                    System.out.println("No data found");
                    break;
                }
                ResultSetMetaData metaData = res.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(metaData.getColumnName(i) + "\t");
                }
                System.out.println("______________");
    
                while(res.next()){
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(res.getString(i) + "\t");
                    }
                    System.out.println("");
                }

                System.out.println("Ny query: ");
                query = scanner.nextLine();
            }


            if (res != null)
                res.close();
            if (minConnection != null)
                minConnection.close();
            if (statemet != null)
                statemet.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}
