package com.example.chess.model.pieces;

import com.example.chess.model.Board;
import com.example.chess.model.Coordinates;
import com.example.chess.model.FactionColor;
import com.example.chess.model.moves.Move;
import com.example.chess.model.moves.MoveCalculator;
import com.example.chess.model.moves.MoveDirection;

import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean hasMoved;

    public Pawn(Coordinates coordinates, FactionColor color) {
        super(coordinates, color, EPiece.PAWN);
        hasMoved = false;
    }

    @Override
    public ArrayList<Move> calculateLegalMoves(Board board) {
        return new ArrayList<>(MoveCalculator.checkPawnMoves(this, board));
    }

    @Override
    public void executeMove(Move move) {
        hasMoved = true;
    }

    public boolean hasMoved() {
        return hasMoved;
    }
}
