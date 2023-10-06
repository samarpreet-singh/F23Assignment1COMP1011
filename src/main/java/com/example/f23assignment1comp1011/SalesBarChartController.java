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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SalesBarChartController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    void switchToTableView(ActionEvent event) throws IOException {
        Main.switchToTableView(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DBUtility.getBarChartDataFromDB(barChart); // Everything inside the initialize method is executed when the program is run. This means that the call to
        // getVideoGameSalesFromDB will be made and the barChart will get populated right after the program is run.
    }
}