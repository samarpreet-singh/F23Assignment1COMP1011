package com.example.f23assignment1comp1011;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VideoGameSalesController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}