package LoginGUI;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String username = "mdoliche";
    private static final String password = "mdoliche";
    private static final String dbUrl = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";

    public static Connection connectToDB()
    {
        Connection connection;

        System.out.println("---- Podlaczanie bazy danych Oracle do aplikacji Salon Samochodowy");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(ClassNotFoundException e){
            System.out.println("Nie masz zainstalowanego Oracle JDBC Driver");
            e.printStackTrace();
            return null;
        }

        try{
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e){
            System.out.println("Zle dane w polaczeniu do bazy danych");
            e.printStackTrace();
            return null;
        }

        if(connection != null){
            System.out.println("Nawiazano polaczenie do bazy danych");
            return connection;
        } else {
            System.out.println("Polacznie do bazy danych nie powiodlo sie.");
            return null;
        }
    }

}
