package com.example.chess.model.pieces;

public enum EPiece {
    BISHOP("B"), PAWN("P"), ROOK("R"), KNIGHT("N"), QUEEN("Q"), KING("K");

    private final String label;

    EPiece(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
