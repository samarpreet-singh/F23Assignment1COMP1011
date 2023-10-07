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

public class DBUtility {
    private static String dbUser = "Samarpreet200510621";
    private static String password = "Uqn4RpKssK";

    /**
     * This is our connectURL which zeroes in on the specific database we want to connect to.
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
     *
     * @param barChart -> The barchart to which the retrieved data is to be added.
     */
    public static void getBarChartDataFromDB(BarChart<?, ?> barChart)
    {
        String sql = "SELECT platform, SUM(global_sales) AS total_global_sales FROM video_game_sales GROUP BY platform ORDER BY total_global_sales DESC LIMIT 8";

        try( // round brackets mean that all of these objects inside here will close automatically and will not stay alive in memory, which is important for a DB connection, and from a security perspective too.
             Connection conn = DriverManager.getConnection(connectURL, dbUser, password);
             Statement statement = conn.createStatement(); // No need to use PreparedStatement as user is not inputting anything.
             ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            XYChart.Series chartData = new XYChart.Series(); // Creating a new XYChart.Series object for working with the chart data

            chartData.setName("Total Global Sales by Platform");

            // looping over the returned result set until all required data has been added to the bar chart
            while (resultSet.next())
            {
                chartData.getData().add(new XYChart.Data(resultSet.getString("platform"), resultSet.getDouble("total_global_sales")));
            } // a new XYChart.Data object is created during each iteration which gets the "platform" and "total_global_sales" columns from the resultSet and
            // that is then passed to the add method for adding all of that data to the chartData object.

            barChart.getData().add(chartData); // chartData (with all data added as shown above) is then added finally to the barChart argument passed in from the
            // controller. This populates the bar chart when the application is run!

            barChart.getYAxis().setLabel("Sales (in Million(s))");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method is going to get the video game sales data from the database we have, then add that data to a TABLE VIEW.
     *
     * @param videoGameSalesTable -> the TableView where we want to populate
     * @param idCol -> The ID column in the table
     * @param gameNameCol -> The Game Name column in the table
     * @param platformCol -> The Platform column in the table
     * @param releaseYearCol -> The Release Year column in the table
     * @param genreCol -> The Genre column in the table
     * @param publisherCol -> The Publisher column in the table
     * @param naSalesCol -> The NA Sales column in the table
     * @param euSalesCol -> The EU Sales column in the table
     * @param jpSalesCol -> The JP Sales column in the table
     * @param otherSalesCol -> The Other Sales column in the table
     * @param globalSalesCol -> The Global Sales column in the table
     */
    public static void getTableViewDataFromDB(TableView<VideoGameSales> videoGameSalesTable,
                                              TableColumn<VideoGameSales, Integer> idCol,
                                              TableColumn<VideoGameSales, String> gameNameCol,
                                              TableColumn<VideoGameSales, String> platformCol,
                                              TableColumn<VideoGameSales, Integer> releaseYearCol,
                                              TableColumn<VideoGameSales, String> genreCol,
                                              TableColumn<VideoGameSales, String> publisherCol,
                                              TableColumn<VideoGameSales, Double> naSalesCol,
                                              TableColumn<VideoGameSales, Double> euSalesCol,
                                              TableColumn<VideoGameSales, Double> jpSalesCol,
                                              TableColumn<VideoGameSales, Double> otherSalesCol,
                                              TableColumn<VideoGameSales, Double> globalSalesCol)
    {
        String sql = "SELECT * FROM video_game_sales ORDER BY global_sales DESC"; // creating our select statement to populate the table
        ObservableList<VideoGameSales> salesList = FXCollections.observableArrayList(); // created an ObservableList which will be used to bulk-inject data into the TableView

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

            // PropertyValueFactory invokes the Getters for each of the passed instance variable strings from VideoGameSales, it does so for each VideoGameSales object that is created in the while loop above and used to render the TableView.
            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            gameNameCol.setCellValueFactory(new PropertyValueFactory<>("gameName"));
            platformCol.setCellValueFactory(new PropertyValueFactory<>("platform"));
            releaseYearCol.setCellValueFactory(new PropertyValueFactory<>("yearOfRelease"));
            genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));
            publisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));
            naSalesCol.setCellValueFactory(new PropertyValueFactory<>("naSales"));
            euSalesCol.setCellValueFactory(new PropertyValueFactory<>("euSales"));
            jpSalesCol.setCellValueFactory(new PropertyValueFactory<>("jpSales"));
            otherSalesCol.setCellValueFactory(new PropertyValueFactory<>("otherSales"));
            globalSalesCol.setCellValueFactory(new PropertyValueFactory<>("globalSales"));

            videoGameSalesTable.setItems(salesList); // setting the items in the TableView to the created salesList with all required data after using while loop

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
