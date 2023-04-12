package com.example.chess.view;

import com.example.chess.ChessController;
import com.example.chess.model.BoardUtils;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessView extends Application {

    @Override
    public void start(Stage stage) {

        try {

            // Create the controller
            ChessController controller = new ChessController();
            controller.setMain(this);

            // Create the view of the standard grid map
            TilePane pane = new TilePane();
            Scene scene = new Scene(pane);
            controller.setTilePane(pane);
            controller.redrawTilePane();

            stage.setTitle("Chess");
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