package com.example.chess.model.pieces;

import com.example.chess.model.Coordinates;
import com.example.chess.model.Move;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public ArrayList<Move> calculateLegalMoves() {
        return null;
    }

    @Override
    public void executeMove(Move move) {

    }
}
