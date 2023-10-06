/**
 * Full Name: Samarpreet Singh
 * Student #: 200510621
 * CRN: 11346 (Monday, 9am class)
 * Assignment 1 - COMP 1011
 */
package com.example.f23assignment1comp1011;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("video-game-sales-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Video Game Sales by Platform!");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/icon.png"))); // icon taken from: https://www.flaticon.com/free-icon/sales_2040672
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToBarChart(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("video-game-sales-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Video Game Sales by Platform!");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/icon.png"))); // icon taken from: https://www.flaticon.com/free-icon/sales_2040672
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToTableView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("video-game-sales-table-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Table View for Video Game Sales by Platform!");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/icon.png"))); // icon taken from: https://www.flaticon.com/free-icon/sales_2040672
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}