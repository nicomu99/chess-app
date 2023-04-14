package com.example.chess.model.pieces;

import com.example.chess.model.*;
import com.example.chess.model.moves.AttackMove;
import com.example.chess.model.moves.Move;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Coordinates coordinates, FactionColor color) {
        super(coordinates, color, EPiece.BISHOP);
    }

    @Override
    public ArrayList<Move> calculateLegalMoves(Board board) {

        ArrayList<Move> moves = new ArrayList<>(checkDirection(board, MoveDirection.LEFT_UPPER));
        moves.addAll(checkDirection(board, MoveDirection.LEFT_LOWER));
        moves.addAll(checkDirection(board, MoveDirection.RIGHT_UPPER));
        moves.addAll(checkDirection(board, MoveDirection.RIGHT_LOWER));

        return moves;
    }

    private ArrayList<Move> checkDirection(Board board, MoveDirection direction) {

        ArrayList<Move> moves = new ArrayList<>();

        boolean endReached = false;
        for(int i = 1; i < BoardUtils.RANK_COUNT; i++) {

            Coordinates nextDirection = this.coordinates.addCoordinates(direction.xDirection *i, direction.yDirection * i);
            if(nextDirection.isValidCoordinate() && !endReached) {
                if(board.getPieces().containsKey(nextDirection)) {
                    if (board.getPieces().get(nextDirection).color != this.color) {
                        moves.add(new AttackMove());
                    }
                    endReached = true;
                } else {
                    moves.add(new Move());
                }
            }
        }
        return moves;
    }

    @Override
    public void executeMove(Move move) {

    }

    public enum MoveDirection {
        LEFT_UPPER(-1, -1), LEFT_LOWER(-1, 1), RIGHT_UPPER(1, -1), RIGHT_LOWER(1, 1);

        public final int xDirection;
        public final int yDirection;

        MoveDirection(int xDirection, int yDirection) {
            this.xDirection = xDirection;
            this.yDirection = yDirection;
        }
    }
}
