package com.example.chess;

import com.example.chess.model.ModelHandler;
import com.example.chess.view.ChessView;
import com.example.chess.view.TileRectangle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ChessController implements EventHandler<MouseEvent> {

    private ChessView chessView;
    private final ModelHandler modelHandler;

    public ChessController() {
        modelHandler = new ModelHandler();
        modelHandler.initializeGame();
    }

    public void setChessView(ChessView view) {
        chessView = view;
    }

    public void redrawTilePane() {
        this.chessView.updateView(modelHandler.getBoard());
    }

    @Override
    public void handle(MouseEvent event) {
        TileRectangle rectangle = (TileRectangle) event.getSource();
        chessView.updateView(modelHandler.handleMove(rectangle.getCoordinates()));
    }
}