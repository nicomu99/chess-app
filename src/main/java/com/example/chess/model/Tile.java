package com.example.chess.model;

public class Tile {

    private final Coordinates coordinates;
    private boolean hasPiece;

    public Tile(Coordinates coordinates, boolean hasPiece) {
        this.coordinates = coordinates;
        this.hasPiece = hasPiece;
    }
}
