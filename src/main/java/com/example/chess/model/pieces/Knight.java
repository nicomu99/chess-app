package com.example.chess.model.pieces;

import com.example.chess.model.Board;
import com.example.chess.model.Coordinates;
import com.example.chess.model.FactionColor;
import com.example.chess.model.moves.Move;
import com.example.chess.model.moves.MoveCalculator;
import com.example.chess.model.moves.MoveDirection;

import java.util.ArrayList;

public class Knight extends Piece {

    private final ArrayList<MoveDirection> legalMoveDirections;

    public Knight(Coordinates coordinates, FactionColor color) {
        super(coordinates, color, EPiece.KNIGHT);
        legalMoveDirections = new ArrayList<>();
        legalMoveDirections.addAll(MoveDirection.getDiagonalDirections());
    }

    @Override
    public ArrayList<Move> calculateLegalMoves(Board board) {
        ArrayList<Move> moves = new ArrayList<>();

        for(MoveDirection direction: legalMoveDirections) {
            moves.addAll(MoveCalculator.checkKnightMoves(this, board, direction));
        }

        return moves;
    }

    @Override
    public void executeMove(Move move) {

    }
}
