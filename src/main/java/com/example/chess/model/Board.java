package com.example.chess.model;

import com.example.chess.model.pieces.Piece;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

    private final HashMap<Coordinates, Tile> tiles;
    private HashMap<Coordinates, Piece> pieces;

    public Board() {
        this.tiles = new HashMap<>();
        this.pieces = new HashMap<>();
    }

    public void addTile(Tile tile) {
        this.tiles.put(tile.getCoordinates(), tile);
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
