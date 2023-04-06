package com.example.chess.model.pieces;

import com.example.chess.model.Coordinates;
import com.example.chess.model.Move;

import java.util.ArrayList;

public abstract class Piece {

    private Coordinates coordinates;

    public Piece(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public abstract ArrayList<Move> calculateLegalMoves();

    public abstract void executeMove(Move move);
}
