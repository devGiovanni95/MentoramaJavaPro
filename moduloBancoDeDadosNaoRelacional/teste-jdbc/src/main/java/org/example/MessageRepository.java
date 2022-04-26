package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageRepository {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "1995";

    public void insertMessage(final Message message){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "insert into messages values(?,?)";
             connection =  DriverManager.getConnection( URL, USERNAME, PASSWORD);
             preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, message.getId());
            preparedStatement.setString(2, message.getMessage());
            preparedStatement.execute();
            System.out.println("Conectado com sucesso");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }
}
