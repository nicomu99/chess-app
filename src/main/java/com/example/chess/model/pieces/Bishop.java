package com.example.chess.model.pieces;

import com.example.chess.model.*;
import com.example.chess.model.moves.Move;
import com.example.chess.model.moves.MoveCalculator;
import com.example.chess.model.moves.MoveDirection;

import java.util.ArrayList;

public class Bishop extends Piece {

    private final ArrayList<MoveDirection> legalMoveDirections;

    public Bishop(Coordinates coordinates, FactionColor color) {
        super(coordinates, color, EPiece.BISHOP);
        legalMoveDirections = new ArrayList<>();
        legalMoveDirections.addAll(MoveDirection.getDiagonalDirections());
    }

    @Override
    public ArrayList<Move> calculateLegalMoves(Board board) {
        ArrayList<Move> moves = new ArrayList<>();

        for(MoveDirection direction: legalMoveDirections) {
            moves.addAll(MoveCalculator.checkDirectionLineMoves(this, board, direction));
        }

        return moves;
    }



    @Override
    public void executeMove(Move move) {

    }
}
