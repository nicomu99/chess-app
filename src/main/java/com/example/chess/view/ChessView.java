package com.example.chess.view;

import com.example.chess.ChessController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessView extends Application {

    private Stage stage;
    private Parent root;

    @Override
    public void start(Stage stage) throws Exception {

        try {
            this.stage = stage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/chess/hello-view.fxml"));
            this.root = loader.load();

            ChessController controller = loader.getController();
            controller.setMain(this);

            Scene scene = new Scene(this.root, 500, 240);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }

}