package com.example.chess;

import com.example.chess.model.ModelHandler;
import com.example.chess.view.ChessView;
import com.example.chess.view.TilePane;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ChessController {
    @FXML
    private Label welcomeText;

    private TilePane tilePane;

    private ChessView chessView;
    private ModelHandler modelHandler;

    public ChessController() {
        this.chessView = new ChessView();
        this.modelHandler = new ModelHandler();
        modelHandler.initializeGame();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void setMain(ChessView view) {
        this.chessView = view;
    }

    public void setTilePane(TilePane pane) {
        this.tilePane = pane;
    }

    public void redrawTilePane() {
        this.tilePane.updateView(this.modelHandler.getBoard());
    }
}