package com.example.chess.view;

import com.example.chess.ChessController;
import com.example.chess.model.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChessView extends Application {

    private TilePane tilePane;

    @Override
    public void start(Stage stage) {

        try {

            // Create the controller
            ChessController controller = new ChessController();
            controller.setChessView(this);

            // Create the view of the standard grid map
            tilePane = new TilePane(controller);
            Scene scene = new Scene(tilePane);
            controller.redrawTilePane();

            stage.setTitle("Chess");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void updateView(Board board) {
        tilePane.updateView(board);
    }

    public static void main(String[] args) {
        launch();
    }

}