package com.example.chess.model.pieces;

import com.example.chess.model.Board;
import com.example.chess.model.Coordinates;
import com.example.chess.model.FactionColor;
import com.example.chess.model.moves.Move;
import com.example.chess.model.moves.MoveCalculator;
import com.example.chess.model.moves.MoveDirection;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Coordinates coordinates, FactionColor color) {
        super(coordinates, color, EPiece.ROOK);
    }

    @Override
    public ArrayList<Move> calculateLegalMoves(Board board) {
        ArrayList<Move> moves = new ArrayList<>(MoveCalculator.checkDirection(this, board, MoveDirection.UPPER));
        moves.addAll(MoveCalculator.checkDirection(this, board, MoveDirection.LOWER));
        moves.addAll(MoveCalculator.checkDirection(this, board, MoveDirection.RIGHT));
        moves.addAll(MoveCalculator.checkDirection(this, board, MoveDirection.LEFT));

        return moves;
    }

    @Override
    public void executeMove(Move move) {

    }
}
