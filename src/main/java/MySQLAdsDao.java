import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

    private Connection connection;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        //Array list to store ads into
        List<Ad> alldAdsList = new ArrayList<>();

        //Query that will get all ads from ads table in adlister_db
        String getAllQuery = "SELECT * FROM ads";

        try {
            //creating statement instance
            Statement statement = connection.createStatement();
            //executing statement and storing in result set
            ResultSet rs = statement.executeQuery(getAllQuery);

            //while rs.next is true (returns true until there are now more rows to go through) a new ad will be created
            while (rs.next()){
                alldAdsList.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                        )
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return alldAdsList;
    }

    @Override
    public Long insert(Ad ad) {

        long insertedAdId = 0;

        String insertQuery = String.format("INSERT INTO ads (user_id, title, description) VALUES ('%d','%s','%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription()
        );

        try {

            Statement statement = connection.createStatement();
            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsGenKeys = statement.getGeneratedKeys();

            if (rsGenKeys.next()) {
                insertedAdId = rsGenKeys.getLong(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return insertedAdId;
    }
}
