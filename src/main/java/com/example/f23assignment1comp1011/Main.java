package com.example.f23assignment1comp1011;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("video-game-sales-view.fxml")); //fxml loader is special class, purpose is to connect the fxml layout file
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Video Game Sales by Platform!");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/icon.png"))); // icon taken from: https://www.flaticon.com/free-icon/sales_2040672
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}