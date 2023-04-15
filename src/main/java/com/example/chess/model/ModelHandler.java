package com.example.chess.model;

import com.example.chess.model.moves.Move;
import com.example.chess.model.pieces.Piece;

import java.util.ArrayList;

public class ModelHandler {

    private final Faction whiteFaction;
    private final Faction blackFaction;
    private Board board;
    private boolean moveFinished;
    private FactionColor nextMoveFaction;

    public ModelHandler() {
        whiteFaction = new Faction(true, FactionColor.WHITE);
        blackFaction = new Faction(false, FactionColor.BLACK);
        moveFinished = false;
        nextMoveFaction = FactionColor.WHITE;
    }

    public Board getBoard() {
        return board;
    }

    public void initializeGame() {
        board = BoardBuilder.buildBoard();
    }

    public Board handleMove(Coordinates coordinates) {
        if(moveFinished) {
            //TODO

            if(nextMoveFaction == FactionColor.WHITE) {
                nextMoveFaction = FactionColor.BLACK;
            } else {
                nextMoveFaction = FactionColor.WHITE;
            }
            moveFinished = false;
        } else {
            if(board.getPieces().containsKey(coordinates)) {
                Piece piece = board.getPiece(coordinates);
                if(piece.getColor() == nextMoveFaction) {
                    ArrayList<Move> moves = piece.calculateLegalMoves(board);
                    board.setLegalMoves(moves);
                }
                moveFinished = true;
            } else {
                board.setLegalMoves(new ArrayList<>());
            }
        }

        return board;
    }
}
