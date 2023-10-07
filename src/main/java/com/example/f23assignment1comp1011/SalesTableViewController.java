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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SalesTableViewController implements Initializable {

    @FXML
    private TableView<VideoGameSales> videoGameSalesTable;

    @FXML
    private TableColumn<VideoGameSales, Double> euSalesCol;

    @FXML
    private TableColumn<VideoGameSales, String> gameNameCol;

    @FXML
    private TableColumn<VideoGameSales, String> genreCol;

    @FXML
    private TableColumn<VideoGameSales, Double> globalSalesCol;

    @FXML
    private TableColumn<VideoGameSales, Integer> idCol;

    @FXML
    private TableColumn<VideoGameSales, Double> jpSalesCol;

    @FXML
    private TableColumn<VideoGameSales, Double> naSalesCol;

    @FXML
    private TableColumn<VideoGameSales, Double> otherSalesCol;

    @FXML
    private TableColumn<VideoGameSales, String> platformCol;

    @FXML
    private TableColumn<VideoGameSales, String> publisherCol;

    @FXML
    private TableColumn<VideoGameSales, Integer> releaseYearCol;

    @FXML
    void switchToBarChartView(ActionEvent event) throws IOException {
        Main.switchToBarChart(event); // switch to bar chart button trigger to call the method from Main when the button is pressed
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBUtility.getTableViewDataFromDB(videoGameSalesTable,
                idCol,
                gameNameCol,
                platformCol,
                releaseYearCol,
                genreCol,
                publisherCol,
                naSalesCol,
                euSalesCol,
                jpSalesCol,
                otherSalesCol,
                globalSalesCol); // passing all arguments into the method
    }
}