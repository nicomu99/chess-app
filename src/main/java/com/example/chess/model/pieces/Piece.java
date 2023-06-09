package com.example.chess.model.pieces;

import com.example.chess.model.Board;
import com.example.chess.model.Coordinates;
import com.example.chess.model.FactionColor;
import com.example.chess.model.moves.Move;

import java.util.ArrayList;

public abstract class Piece {

    protected Coordinates coordinates;
    protected final FactionColor color;
    private final EPiece pieceLabel;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Piece(Coordinates coordinates, FactionColor color, EPiece pieceLabel) {
        this.coordinates = coordinates;
        this.color = color;
        this.pieceLabel = pieceLabel;
    }

    public FactionColor getColor() {
        return this.color;
    }

    public EPiece getPieceLabel() {
        return this.pieceLabel;
    }

    public abstract ArrayList<Move> calculateLegalMoves(Board board);

    public abstract void executeMove(Move move);

    @Override
    public String toString() {
        return pieceLabel.toString();
    }
}
