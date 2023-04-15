package com.example.chess.model;

import com.example.chess.model.moves.Move;
import com.example.chess.model.pieces.Piece;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

    private final HashMap<Coordinates, Tile> tiles;
    private HashMap<Coordinates, Piece> pieces;
    private ArrayList<Move> legalMoves;
    private Coordinates enPassantTarget;
    private boolean enPassantPossible;
    private FactionColor enPassantTaker;

    public Board() {
        tiles = new HashMap<>();
        pieces = new HashMap<>();
        legalMoves = new ArrayList<>();
        enPassantTarget = new Coordinates(-1, -1);
        enPassantPossible = false;
        enPassantTaker = null;
    }

    public HashMap<Coordinates, Piece> getPieces() {
        return pieces;
    }

    public Piece getPiece(Coordinates coordinates) {
        return pieces.get(coordinates);
    }

    public boolean isEnPassantPossible() {
        return enPassantPossible;
    }

    public Coordinates getEnPassantTarget() {
        return enPassantTarget;
    }

    public FactionColor getEnPassantTaker() {
        return enPassantTaker;
    }

    public ArrayList<Move> getLegalMoves() {
        return legalMoves;
    }

    public void setLegalMoves(ArrayList<Move> legalMoves) {
        this.legalMoves = legalMoves;
    }

    public void addTile(Tile tile) {
        tiles.put(tile.getCoordinates(), tile);
    }

    public void addPiece(Piece piece) {
        Coordinates pieceCoordinates = piece.getCoordinates();

        tiles.get(pieceCoordinates).setHasPiece(true);
        pieces.put(pieceCoordinates, piece);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < BoardUtils.FILE_COUNT; i++) {
            for(int j = 0; j < BoardUtils.RANK_COUNT; j++) {
                Coordinates nextTileKey = new Coordinates(j, i);

                if(tiles.get(nextTileKey).hasPiece()) {
                    stringBuilder.append(pieces.get(nextTileKey).toString());
                } else {
                    stringBuilder.append("-");
                }
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
