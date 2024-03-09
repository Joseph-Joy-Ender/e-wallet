package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/e-wallet_db?createDatabaseIfNotExist=true";
        String username = "root";
        String password = "Password";

        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setSender("Joy");
        transaction.setRecipient("Joseph");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            save(transaction, connection);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static Transaction save(Transaction transaction, Connection connection){
        String sql = "INSERT into transactions(id, sender, recipient) VALUES (?, ?, ?)";
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 1);
            statement.setString(2, transaction.getSender());
            statement.setString(3, transaction.getRecipient());
            statement.execute();
            return transaction;
        }catch (SQLException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
