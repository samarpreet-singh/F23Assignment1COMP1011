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

    public class VideoGameSalesController implements Initializable {

        private static boolean barChartLoaded = false;
        private static boolean tableViewLoaded = false;

        @FXML
        private AnchorPane anchorPane;

        @FXML
        private BarChart<?, ?> barChart;

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
        void switchToTableView(ActionEvent event) throws IOException {
            Main.switchToTableView(event);
        }

        @FXML
        void switchToBarChartView(ActionEvent event) throws IOException {
            Main.switchToBarChart(event);
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            if (!barChartLoaded) {
                DBUtility.getBarChartDataFromDB(barChart); // Everything inside the initialize method is executed when the program is run. This means that the call to
                // getVideoGameSalesFromDB will be made and the barChart will get populated right after the program is run.
                barChartLoaded = true;
            }
            if (!tableViewLoaded) {
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
                        globalSalesCol); // Everything inside the initialize method is executed when the program is run. This means that the call to
                // getVideoGameSalesFromDB will be made and the barChart will get populated right after the program is run.
                tableViewLoaded = true;
            }
        }

        // Static method to set the dataLoaded flag
        public static void setBarChartLoaded(boolean value) {
            barChartLoaded = value;
        }

        public static void setTableViewLoaded(boolean value) {
            tableViewLoaded = value;
        }
    }