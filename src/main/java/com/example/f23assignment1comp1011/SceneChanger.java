package com.example.f23assignment1comp1011;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    /**
     * Switches between scenes depending on the event triggered, view file name passed, and sets the Scene title depending on the argument passed.
     * @param event -> triggered event
     * @param fxmlFileName -> view file name to switch to
     * @param sceneTitle -> new title of the scene
     * @throws IOException -> throwable IOException when using .load();
     */
    public static void changeScenes(ActionEvent event, String fxmlFileName, String sceneTitle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        // getting the stage from the action event
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setTitle(sceneTitle);

        stage.setScene(scene);
        stage.show();
    }
}
