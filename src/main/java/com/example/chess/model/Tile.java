package com.example.chess.model;

public class Tile {

    private final Coordinates coordinates;
    private boolean hasPiece;

    public Tile(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.hasPiece = false;
    }

    public boolean hasPiece() {
        return this.hasPiece;
    }

    public void setHasPiece(boolean hasPiece) {
        this.hasPiece = hasPiece;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

}
