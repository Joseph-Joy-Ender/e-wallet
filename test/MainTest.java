import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainTest {


    @Test
    public void testThatDatabaseCanConnect() {
        String url = "jdbc:mysql://localhost:3306/e-wallet_db?createDatabaseIfNotExist=true";
        String username = "root";
        String password = "Password";

        try (Connection connection = DriverManager.getConnection(url, username, password)){
           
            assertNotNull(connection);

        }catch (SQLException exception){
            System.err.println("Error: " + exception.getMessage());

        }
    }
}