/**
 * Full Name: Samarpreet Singh
 * Student #: 200510621
 * CRN: 11346 (Monday, 9am class)
 * Assignment 1 - COMP 1011
 */

package com.example.f23assignment1comp1011;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String dbUser = "Samarpreet200510621";
    private static String password = "Uqn4RpKssK";

    /**
     * This is our connectURL which zeroes in on the specific database we want to connect to.
     *
     * DATABASE INFORMATION FROM CSTECH ->
     * Your ftp username is Samarpreet200510621
     * Your password is Uqn4RpKssK
     * Your mysql username is Samarpreet200510621
     * The database name is Samarpreet200510621
     * The hostname for this server for FTPS/MySQL is: 172.31.22.43 (requires VPN access).
     * The URL to your Lamp Stack website is: 15.222.122.223/~Samarpreet200510621
     * The FQDN to server is: lamp.computerstudi.es
     * Notice: ALL USER NAMES AND PASSWORDS ARE CASE SENSITIVE!
     *
     * MYSQL MAVEN DEPENDENCY IS CRUCIAL FOR CONNECTION -> https://mvnrepository.com/artifact/mysql/mysql-connector-java
     * DB CONNECTION ALSO REQUIRES VPN CONNECTION TO THE SERVER!!!
     *
     * jdbc:mysql -> The database driver
     * 172.31.22.43 -> IP Address of the AWS server from CSTECH
     * 3306 -> Port Number of the MySQL Server
     * Samarpreet200510621 -> database name from CSTECH
     */
    public static String connectURL = "jdbc:mysql://172.31.22.43:3306/Samarpreet200510621";

    /**
     * This method is going to get the video game sales data from the database we have, then add that data to the bar chart.
     */
    public static XYChart.Series getBarChartDataFromDB()
    {
        XYChart.Series chartData = new XYChart.Series(); // Creating a new XYChart.Series object for working with the chart data

        String sql = "SELECT platform, SUM(global_sales) AS total_global_sales FROM video_game_sales GROUP BY platform ORDER BY total_global_sales DESC LIMIT 21";

        try( // round brackets mean that all of these objects inside here will close automatically and will not stay alive in memory, which is important for a DB connection, and from a security perspective too.
             Connection conn = DriverManager.getConnection(connectURL, dbUser, password);
             Statement statement = conn.createStatement(); // No need to use PreparedStatement as user is not inputting anything.
             ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            chartData.setName("Total Global Sales by Platform"); // Setting the Heading of the chart

            // looping over the returned result set until all required data has been added to the bar chart
            while (resultSet.next())
            {
                chartData.getData().add(new XYChart.Data<>(resultSet.getString("platform"), resultSet.getDouble("total_global_sales")));
            } // a new XYChart.Data object is created during each iteration which gets the "platform" and "total_global_sales" columns from the resultSet and
            // that is then passed to the add method for adding all of that data to the chartData object.
            //chartData is later returned and the return is an argument in the controller classes for actually populating the barChart FXML field.
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return chartData;
    }

    /**
     * This method is going to get the video game sales data from the database we have, then add that data to a TABLE VIEW.
     */
    public static ObservableList<VideoGameSales> getTableViewDataFromDB()
    {
        ObservableList<VideoGameSales> salesList = FXCollections.observableArrayList(); // created an ObservableList which will be used to bulk-inject data into the TableView
        // I found online that observable lists are better for working with JavaFX apps since they are more tightly bound to the UI and will update it if the contents of the
        // list change. Hence, I am using Observable List here instead of ArrayList.

        String sql = "SELECT * FROM video_game_sales ORDER BY global_sales DESC"; // creating our select statement to populate the table

        try(
             Connection conn = DriverManager.getConnection(connectURL, dbUser, password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            // looping over the returned result set until all required data has been added to salesList
            while (resultSet.next())
            { // using salesList.add to add a VideoGameSales object to it in each iteration that uses the resultSet results as arguments, which are linked to setters in the constructor. This way, all data being parsed through is also being validated at the same time! :)
                salesList.add(new VideoGameSales(resultSet.getInt("id"), resultSet.getString("game_name"), resultSet.getString("platform"), resultSet.getInt("year_of_release"), resultSet.getString("genre"),
                        resultSet.getString("publisher"),
                        resultSet.getDouble("na_sales"),
                        resultSet.getDouble("eu_sales"),
                        resultSet.getDouble("jp_sales"),
                        resultSet.getDouble("other_sales"),
                        resultSet.getDouble("global_sales")));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return salesList;
    }
}
