package com.example.f23assignment1comp1011;

import javafx.concurrent.Task;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    // Have to add in your own user and password here
    private static String dbUser = "Samarpreet200510621";
    private static String password = "Uqn4RpKssK";

    /**
     * jdbc:mysql -> The database driver
     * 127.0.0.1 -> IP Address of the MySQL Server
     * 3306 -> Port Number of the MySQL Server
     * F23COMP1011Monday -> database name
     */
    public static String connectURL = "jdbc:mysql://172.31.22.43:3306/Samarpreet200510621";

    /**
     * This method will return a list of users from the database
     */
    public static ArrayList<VideoGameSales> getUsersFromDB()
    {
        ArrayList<VideoGameSales> videoGameSales = new ArrayList<>();

        // Using a try with resources block to access the database and automatically close the conn, statement
        // and result set. Similar to addUsersToDB above.
        String sql = "SELECT * FROM video_game_sales"; // no need to use PreparedStatement here since user is not inputting anything to the database.

        try( // round brackets means all of these objects inside here will close automatically and wont stay live in memory, which is important for a DB connection
             Connection conn = DriverManager.getConnection(connectURL, dbUser, password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            // loop over the results returned of users from db and create new user objects
            while (resultSet.next())
            {
                VideoGameSales newVideoGameSales = new VideoGameSales(resultSet.getString("game_name"),
                        resultSet.getString("platform"),
                        resultSet.getString("year_of_release"),
                        resultSet.getString("genre"),
                        resultSet.getString("publisher"),
                        resultSet.getDouble("na_sales"),
                        resultSet.getDouble("eu_sales"),
                        resultSet.getDouble("jp_sales"),
                        resultSet.getDouble("other_sales"),
                        resultSet.getDouble("global_sales"));
                videoGameSales.add(newVideoGameSales);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return videoGameSales;
    }
}
