package com.example.chess.model.pieces;

import com.example.chess.model.Coordinates;
import com.example.chess.model.FactionColor;
import com.example.chess.model.Move;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(Coordinates coordinates, FactionColor color) {
        super(coordinates, color, EPiece.QUEEN);
    }

    @Override
    public ArrayList<Move> calculateLegalMoves() {
        return null;
    }

    @Override
    public void executeMove(Move move) {

    }
}
