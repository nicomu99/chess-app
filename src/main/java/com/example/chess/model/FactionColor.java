package com.example.chess.model;

public enum FactionColor {
    WHITE("white"), BLACK("black");

    private final String label;

    FactionColor(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
