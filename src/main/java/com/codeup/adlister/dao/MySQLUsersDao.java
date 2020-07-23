package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users{

    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByUsername(String username) {
        User requestedUser = new User();

        String sqlQuery = "SELECT * FROM users WHERE username LIKE ?";
        String userInputWithWildcards = "%" + username + "%";

        try {
            PreparedStatement prepStmt = connection.prepareStatement(sqlQuery);
            prepStmt.setString(1, userInputWithWildcards);
            ResultSet rs = prepStmt.executeQuery();

            rs.next();
            requestedUser.setId(rs.getLong("id"));
            requestedUser.setUsername(rs.getString("username"));
            requestedUser.setEmail(rs.getString("email"));
            requestedUser.setPassword(rs.getString("password"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requestedUser;
    }

    //Create an Insert SQL query with placeholders
    //Create a connection using a prepared statement
    //Insert values into placeholders of prepared statement
    //Return generated keys after statement execute to be able to return the ID of new user

    @Override
    public Long insert(User user) {

        Long returnedUserId = null;
        String insertSqlQuery = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

        try {
            PreparedStatement prepStmt = connection.prepareStatement(insertSqlQuery, Statement.RETURN_GENERATED_KEYS);
            prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getEmail());
            prepStmt.setString(3, user.getPassword());

            prepStmt.executeUpdate();
            ResultSet rs = prepStmt.getGeneratedKeys();
            rs.next();
            returnedUserId = rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedUserId;
    }

    public static void main(String[] args) {
//        Users myUser = new MySQLUsersDao(new Config());
//        System.out.println(myUser.findByUsername("justin"));

//        User newUser = new User();
//        newUser.setUsername("Cayenne Pepper");
//        newUser.setEmail("CayPep@email.com");
//        newUser.setPassword("reallyStrongPassword");

//        System.out.println(myUser.insert(newUser));

    }
}
