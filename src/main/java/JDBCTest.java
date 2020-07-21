import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    private static List<String> getEmployeeFirstNames() {

            List<String> firstNames = new ArrayList<>();

        try {

            //CREATING DRIVER AND CONNECTION OBJECTS
            DriverManager.registerDriver(new Driver());

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

            //CREATING A STATEMENT OBJECT
            Statement statement = conn.createStatement();

            String query = "SELECT first_name FROM employees.employees LIMIT 10";

            ResultSet rs = statement.executeQuery(query);


            while(rs.next()){
                firstNames.add(rs.getString(1));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return firstNames;

    }


    private static List<String> getEmployeeFirstNames(int limit) {

        List<String> firstNames = new ArrayList<>();

        try {

            //CREATING DRIVER AND CONNECTION OBJECTS
            DriverManager.registerDriver(new Driver());

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/employees?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

            //CREATING A STATEMENT OBJECT
            Statement statement = conn.createStatement();

            String query = "SELECT first_name FROM employees.employees LIMIT " + limit;

            ResultSet rs = statement.executeQuery(query);


            while (rs.next()) {
                firstNames.add(rs.getString(1));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return firstNames;

    }


    public static void main(String[] args) {
        System.out.println(getEmployeeFirstNames());
        System.out.println(getEmployeeFirstNames(12));


        try {

            //CREATING DRIVER AND CONNECTION OBJECTS
            DriverManager.registerDriver(new Driver());

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

            //CREATING A STATEMENT OBJECT
            Statement statement = conn.createStatement();

            Album updateAlbum = new Album(
                4,
                "Magic Sword",
                "Volume 1",
                 2016,
                 15.0,
                 "Synthwave"
            );

//            String updateQuery = String.format("UPDATE albums SET artist = '%s', name = '%s', releaseDate = '%d', sales = '%f', genre = '%s' WHERE id = '%d',",
//                    updateAlbum.getArtist(),
//                    updateAlbum.getName(),
//                    updateAlbum.getReleaseDate(),
//                    updateAlbum.getSales(),
//                    updateAlbum.getGenre(),
//                    updateAlbum.getId()
//            );

            String updateQuery = String.format("UPDATE albums SET artist = '%s', name = '%s', release_date = %d, sales = %f, genre = '%s' WHERE id = %d",
                    updateAlbum.getArtist(),
                    updateAlbum.getName(),
                    updateAlbum.getReleaseDate(),
                    updateAlbum.getSales(),
                    updateAlbum.getGenre(),
                    updateAlbum.getId()
            );

            statement.executeUpdate(updateQuery);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    }
