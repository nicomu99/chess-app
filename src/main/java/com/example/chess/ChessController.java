package com.example.chess;

import com.example.chess.model.ModelHandler;
import com.example.chess.view.ChessView;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ChessController {
    @FXML
    private Label welcomeText;

    private ChessView chessView;
    private ModelHandler modelHandler;

    @FXML
    void initialize() {
        this.modelHandler = new ModelHandler();
        modelHandler.initializeGame();
    }

    public ChessController() {
        this.chessView = new ChessView();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void setMain(ChessView view) {
        this.chessView = view;
    }


}