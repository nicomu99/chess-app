package com.example.chess;

import com.example.chess.model.ModelHandler;
import com.example.chess.view.ChessView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ChessController implements EventHandler<MouseEvent> {

    private ChessView chessView;
    private final ModelHandler modelHandler;

    public ChessController() {
        this.chessView = new ChessView();
        this.modelHandler = new ModelHandler();
        this.modelHandler.initializeGame();
    }

    public void setMain(ChessView view) {
        this.chessView = view;
    }

    public void redrawTilePane() {
        this.chessView.updateView(this.modelHandler.getBoard());
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println(event.getSource().toString());
    }
}