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

    @Override
    public Long insert(User user) {
        return null;
    }
}
