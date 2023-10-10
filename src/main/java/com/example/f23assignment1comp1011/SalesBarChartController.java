/**
 * Full Name: Samarpreet Singh
 * Student #: 200510621
 * CRN: 11346 (Monday, 9am class)
 * Assignment 1 - COMP 1011
 */
package com.example.f23assignment1comp1011;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SalesBarChartController implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    void switchToTableView(ActionEvent event) throws IOException { // switch to table view button trigger to call the method from SceneChanger when the button is pressed
        SceneChanger.changeScenes(event, "video-game-sales-table-view.fxml", "Table View for Video Game Sales!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.getData().add(DBUtility.getBarChartDataFromDB()); // chartData (with all data added from the while loop in getBarChartDataFromDB) is
        // added to the barChart This populates the bar chart when the application is run!
        barChart.getYAxis().setLabel("Total Global Sales (in Million(s))"); // Setting the YAxis label for the barchart
    }
}