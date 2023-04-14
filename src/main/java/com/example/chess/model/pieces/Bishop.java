package com.example.chess.model.pieces;

import com.example.chess.model.*;
import com.example.chess.model.moves.Move;
import com.example.chess.model.moves.MoveCalculator;
import com.example.chess.model.moves.MoveDirection;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Coordinates coordinates, FactionColor color) {
        super(coordinates, color, EPiece.BISHOP);
    }

    @Override
    public ArrayList<Move> calculateLegalMoves(Board board) {

        ArrayList<Move> moves = new ArrayList<>(MoveCalculator.checkDirection(this, board, MoveDirection.LEFT_UPPER));
        moves.addAll(MoveCalculator.checkDirection(this, board, MoveDirection.LEFT_LOWER));
        moves.addAll(MoveCalculator.checkDirection(this, board, MoveDirection.RIGHT_UPPER));
        moves.addAll(MoveCalculator.checkDirection(this, board, MoveDirection.RIGHT_LOWER));

        return moves;
    }



    @Override
    public void executeMove(Move move) {

    }
}
