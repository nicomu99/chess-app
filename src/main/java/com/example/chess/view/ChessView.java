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
            ChessController controller = new ChessController();
            controller.setMain(this);

            GridPane pane = new GridPane();
            int count = 0;
            for(int i = 0; i < BoardUtils.RANK_COUNT; i++) {
                count++;
                for(int j = 0; j < BoardUtils.FILE_COUNT; j++) {
                    Rectangle r = new Rectangle(100, 100, 100, 100);
                    r.setOnMouseClicked(event -> r.setFill(Color.BLACK));
                    if(count % 2 == 0) {
                        r.setFill(Color.GREEN);
                    } else {
                        r.setFill(Color.WHITE);
                    }
                    pane.add(r, j, i);
                    count++;
                }
            }

            Scene scene = new Scene(pane);
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