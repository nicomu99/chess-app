package com.example.chess.model.moves;

import com.example.chess.model.Board;
import com.example.chess.model.BoardUtils;
import com.example.chess.model.Coordinates;
import com.example.chess.model.pieces.Piece;

import java.util.ArrayList;

public class MoveCalculator {
    public static ArrayList<Move> checkDirection(Piece piece, Board board, MoveDirection direction) {

        ArrayList<Move> moves = new ArrayList<>();

        boolean endReached = false;
        for(int i = 1; i < BoardUtils.RANK_COUNT; i++) {

            Coordinates nextDirection = piece.getCoordinates().addCoordinates(direction.xDirection * i, direction.yDirection * i);
            if(nextDirection.isValidCoordinate() && !endReached) {
                if(board.getPieces().containsKey(nextDirection)) {
                    if (board.getPieces().get(nextDirection).getColor() != piece.getColor()) {
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
}
