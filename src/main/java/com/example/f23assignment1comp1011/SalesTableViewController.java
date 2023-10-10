/**
 * Full Name: Samarpreet Singh
 * Student #: 200510621
 * CRN: 11346 (Monday, 9am class)
 * Assignment 1 - COMP 1011
 */
package com.example.f23assignment1comp1011;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
        SceneChanger.changeScenes(event, "video-game-sales-view.fxml", "Video Game Sales by Platform!"); // switch to bar chart button trigger to call the method from SceneChanger when the button is pressed
    }

    private ObservableList<VideoGameSales> allSales;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allSales = DBUtility.getTableViewDataFromDB(); //assigning the returned salesList to allSales

        // PropertyValueFactory invokes the Getters for each of the passed instance variable strings from VideoGameSales,
        // it does so for each VideoGameSales object that is created in the allSales object
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

        videoGameSalesTable.setItems(allSales); // I found online that setItems will be setting the items in the TableView to the created allSales list (essentially overwriting previously existing items in the TableView)
        // whereas .getItems.addall() will only append the new items after the already existing ones. In my case here, using setItems() seems better
        // since it will overwrite any pre-existing data


        //This comment is for my reference and understanding about what is going on under the hood here -
        /*
        Question: How does it access all the created objects inside allSales to use the getter functions for all of them through
        setCellValueFactory(new PropertyValueFactory<>)??

        The PropertyValueFactory and TableView work together to handle this. Breaking down how this happens:
        Populating the TableView:
        After setting the CellValueFactory using idCol.setCellValueFactory(new PropertyValueFactory<>("id")), the TableView is aware of how to extract the id property from
        each item in its items list.

        Items List:
        The items list of the TableView is typically set using tableView.setItems(allSales), where allSales is an ObservableList of VideoGameSales objects. This list
        contains the data you want to display in the TableView.

        Binding Data:
        When you set the items list, the TableView internally binds to this list. It knows that each item in the list is a VideoGameSales object.

        Accessing Properties:
        When populating a specific column (e.g., idCol), the TableView uses the provided CellValueFactory (in this case, PropertyValueFactory<>("id")) to access the id
        property of each VideoGameSales object in the items list.

        Automatic Invocation:
        For each item in the list, the TableView will automatically invoke the appropriate getter method (e.g., getId() in this case) via reflection due to the
        PropertyValueFactory. This happens when rendering the TableView.

        Displaying Data:
        The retrieved id values are then displayed in the id column of the TableView.

        In summary, the TableView iterates through the VideoGameSales objects in the items list, uses the specified CellValueFactory to invoke the getId() method (due to the
        naming convention and reflection), and displays the returned values in the id column. This process is automated and handled by the TableView based on the provided
        CellValueFactory.
         */
    }
}