package com.example.chess.model;

import com.example.chess.model.pieces.*;

public class BoardBuilder {

    /**
     * This function generates the board. It also adds the pieces to the board.
     *
     * @return {@link Board} Returns a new instance of the board.
     */
    public static Board buildBoard() {

        Board board = new Board();

        for(int i = 0; i < BoardUtils.RANK_COUNT; i++) {
            for(int j = 0; j < BoardUtils.FILE_COUNT; j++) {
                Coordinates coordinatesOfNextTile = new Coordinates(i, j);

                board.addTile(new Tile(coordinatesOfNextTile));
            }
        }

        // Add pieces
        for(int i = 0; i < BoardUtils.RANK_COUNT; i++) {
            Piece whitePawn = new Pawn(new Coordinates(i, 1), FactionColor.WHITE);
            Piece blackPawn = new Pawn(new Coordinates(i, 6), FactionColor.BLACK);

            board.addPiece(whitePawn);
            board.addPiece(blackPawn);
        }

        // Add kings
        Piece whiteKing = new King(new Coordinates(4, 0), FactionColor.WHITE);
        Piece blackKing = new King(new Coordinates(4, 7), FactionColor.BLACK);
        board.addPiece(whiteKing);
        board.addPiece(blackKing);

        // Add queens
        Piece whiteQueen = new Queen(new Coordinates(3, 0), FactionColor.WHITE);
        Piece blackQueen = new Queen(new Coordinates(3, 7), FactionColor.BLACK);
        board.addPiece(whiteQueen);
        board.addPiece(blackQueen);

        // Add rooks
        Piece whiteLeftRook = new Rook(new Coordinates(0, 0), FactionColor.WHITE);
        Piece whiteRightRook = new Rook(new Coordinates(7, 0), FactionColor.WHITE);
        Piece blackLeftRook = new Rook(new Coordinates(0, 7), FactionColor.BLACK);
        Piece blackRightRook = new Rook(new Coordinates(7, 7), FactionColor.BLACK);
        board.addPiece(whiteLeftRook);
        board.addPiece(whiteRightRook);
        board.addPiece(blackLeftRook);
        board.addPiece(blackRightRook);

        // Add knights
        Piece whiteLeftKnight = new Knight(new Coordinates(1, 0), FactionColor.WHITE);
        Piece whiteRightKnight = new Knight(new Coordinates(6, 0), FactionColor.WHITE);
        Piece blackLeftKnight = new Knight(new Coordinates(1, 7), FactionColor.BLACK);
        Piece blackRightKnight = new Knight(new Coordinates(6, 7), FactionColor.BLACK);
        board.addPiece(whiteLeftKnight);
        board.addPiece(whiteRightKnight);
        board.addPiece(blackLeftKnight);
        board.addPiece(blackRightKnight);

        // Add bishops
        Piece whiteDarkTiledBishop = new Bishop(new Coordinates(2, 0), FactionColor.WHITE);
        Piece whiteLightTiledBishop = new Bishop(new Coordinates(5, 0), FactionColor.WHITE);
        Piece blackLightTiledBishop = new Bishop(new Coordinates(2, 7), FactionColor.BLACK);
        Piece blackDarkTiledBishop = new Bishop(new Coordinates(5, 7), FactionColor.BLACK);
        board.addPiece(whiteDarkTiledBishop);
        board.addPiece(whiteLightTiledBishop);
        board.addPiece(blackLightTiledBishop);
        board.addPiece(blackDarkTiledBishop);

        return board;
    }
}
