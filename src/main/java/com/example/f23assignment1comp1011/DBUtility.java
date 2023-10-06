/**
 * Full Name: Samarpreet Singh
 * Student #: 200510621
 * CRN: 11346 (Monday, 9am class)
 * Assignment 1 - COMP 1011
 */

package com.example.f23assignment1comp1011;

import javafx.concurrent.Task;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    private static String dbUser = "Samarpreet200510621";
    private static String password = "Uqn4RpKssK";

    /**
     * This is our connectURL which zeroes in on the specific database we want to connect to.
     *
     * jdbc:mysql -> The database driver
     * 172.31.22.43 -> IP Address of the AWS server from CSTECH
     * 3306 -> Port Number of the MySQL Server
     * Samarpreet200510621 -> database name from CSTECH
     */
    public static String connectURL = "jdbc:mysql://172.31.22.43:3306/Samarpreet200510621";

    /**
     * This method is going to get the video game sales data from the database we have, then add that data to the bar chart.
     *
     * @param barChart -> The barchart to which the data is to be added.
     */
    public static void getVideoGameSalesFromDB(BarChart<?, ?> barChart)
    {
        String sql = "SELECT platform, SUM(global_sales) AS total_global_sales FROM video_game_sales GROUP BY platform ORDER BY total_global_sales DESC LIMIT 8";

        try( // round brackets mean that all of these objects inside here will close automatically and will not stay alive in memory, which is important for a DB connection, and from a security perspective too.
             Connection conn = DriverManager.getConnection(connectURL, dbUser, password);
             Statement statement = conn.createStatement(); // No need to use PreparedStatement as user is not inputting anything.
             ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            XYChart.Series chartData = new XYChart.Series(); // Creating a new XYChart.Series object for working with the chart data

            // looping over the returned result set until all required data has been added to the bar chart
            while (resultSet.next())
            {
                chartData.getData().add(new XYChart.Data(resultSet.getString("platform"), resultSet.getDouble("total_global_sales")));
            } // a new XYChart.Data object is created during each iteration which gets the "platform" and "total_global_sales" columns from the resultSet and
            // that is then passed to the add method for adding all of that data to the chartData object.

            barChart.getData().add(chartData); // chartData (with all data added as shown above) is then added finally to the barChart argument passed in from the
            // controller. This populates the bar chart when the application is run!

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
