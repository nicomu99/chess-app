package com.example.chess.model.moves;

import com.example.chess.model.Board;
import com.example.chess.model.BoardUtils;
import com.example.chess.model.Coordinates;
import com.example.chess.model.pieces.Piece;

import java.util.ArrayList;

public class MoveCalculator {
    public static ArrayList<Move> checkDirectionLineMoves(Piece piece, Board board, MoveDirection direction) {

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

    public static ArrayList<Move> checkKnightMoves(Piece piece, Board board, MoveDirection direction) {

        Coordinates nextDirection = piece.getCoordinates().addCoordinates(direction.xDirection * 2, direction.yDirection);
        ArrayList<Move> moves = new ArrayList<>(getMoves(piece, board, new ArrayList<>(), nextDirection));

        nextDirection = piece.getCoordinates().addCoordinates(direction.xDirection, direction.yDirection * 2);
        moves.addAll(getMoves(piece, board, moves, nextDirection));
        return moves;
    }

    public static ArrayList<Move> checkKingMoves(Piece piece, Board board, MoveDirection direction) {
        ArrayList<Move> moves = new ArrayList<>();

        Coordinates nextDirection = piece.getCoordinates().addCoordinates(direction.xDirection, direction.yDirection);
        return getMoves(piece, board, moves, nextDirection);
    }

    private static ArrayList<Move> getMoves(Piece piece, Board board, ArrayList<Move> moves, Coordinates nextDirection) {
        if(nextDirection.isValidCoordinate()) {
            if(board.getPieces().containsKey(nextDirection)) {
                if (board.getPieces().get(nextDirection).getColor() != piece.getColor()) {
                    moves.add(new AttackMove());
                }
            } else {
                moves.add(new Move());
            }
        }
        return moves;
    }
}
