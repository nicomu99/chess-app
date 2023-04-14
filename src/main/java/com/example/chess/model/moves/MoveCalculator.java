package com.example.chess.model.moves;

import com.example.chess.model.Board;
import com.example.chess.model.BoardUtils;
import com.example.chess.model.Coordinates;
import com.example.chess.model.FactionColor;
import com.example.chess.model.pieces.Pawn;
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

    public static ArrayList<Move> checkPawnMoves(Pawn pawn, Board board) {
        ArrayList<Move> moves = new ArrayList<>();

        MoveDirection direction = pawn.getColor() == FactionColor.WHITE ? MoveDirection.UPPER : MoveDirection.LOWER;
        Coordinates oneDistanceMove = pawn.getCoordinates().addCoordinates(direction.xDirection, direction.yDirection);
        Coordinates twoDistanceMove = pawn.getCoordinates().addCoordinates(direction.xDirection, direction.yDirection * 2);
        if(!board.getPieces().containsKey(oneDistanceMove)) {
            moves.add(new Move());

            if(!pawn.hasMoved()) {
                if(!board.getPieces().containsKey(twoDistanceMove)) {
                    moves.add(new Move());
                }
            }
        }

        MoveDirection leftAttackDirection = pawn.getColor() == FactionColor.WHITE ? MoveDirection.LEFT_UPPER : MoveDirection.LEFT_LOWER;
        Coordinates leftAttackMove = pawn.getCoordinates().addCoordinates(leftAttackDirection.xDirection, leftAttackDirection.yDirection);
        if(board.getPieces().containsKey(leftAttackMove)) {
            if(board.getPieces().get(leftAttackMove).getColor() != pawn.getColor()) {
                moves.add(new AttackMove());
            }
        }

        MoveDirection rightAttackDirection = pawn.getColor() == FactionColor.WHITE ? MoveDirection.RIGHT_UPPER : MoveDirection.RIGHT_LOWER;
        Coordinates rightAttackMove = pawn.getCoordinates().addCoordinates(rightAttackDirection.xDirection, rightAttackDirection.yDirection);
        if(board.getPieces().containsKey(rightAttackMove)) {
            if(board.getPieces().get(rightAttackMove).getColor() != pawn.getColor()) {
                moves.add(new AttackMove());
            }
        }

        // TODO: EnPassant
        if(board.isEnPassantPossible()) {
            if(board.getEnPassantTaker() == pawn.getColor()) {
                if(board.getEnPassantTarget() == rightAttackMove) {
                    moves.add(new AttackMove());
                } else if(board.getEnPassantTarget() == leftAttackMove) {
                    moves.add(new AttackMove());
                }
            }
        }

        return moves;
    }
}
