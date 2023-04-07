package com.example.chess.model.pieces;

import com.example.chess.model.Coordinates;
import com.example.chess.model.FactionColor;
import com.example.chess.model.Move;

import java.util.ArrayList;

public abstract class Piece {

    private Coordinates coordinates;
    private final FactionColor color;
    private final EPiece pieceLabel;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Piece(Coordinates coordinates, FactionColor color, EPiece pieceLabel) {
        this.coordinates = coordinates;
        this.color = color;
        this.pieceLabel = pieceLabel;
    }

    public abstract ArrayList<Move> calculateLegalMoves();

    public abstract void executeMove(Move move);

    @Override
    public String toString() {
        return pieceLabel.toString();
    }
}
