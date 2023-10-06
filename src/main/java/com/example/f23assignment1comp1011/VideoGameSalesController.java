/**
 * Full Name: Samarpreet Singh
 * Student #: 200510621
 * CRN: 11346 (Monday, 9am class)
 * Assignment 1 - COMP 1011
 */
package com.example.f23assignment1comp1011;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

    public class VideoGameSalesController implements Initializable {

        @FXML
        private AnchorPane anchorPane;

        @FXML
        private BarChart<?, ?> barChart;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            DBUtility.getVideoGameSalesFromDB(barChart); // Everything inside the initialize method is executed when the program is run. This means that the call to
            // getVideoGameSalesFromDB will be made and the barChart will get populated right after the program is run.
        }
    }