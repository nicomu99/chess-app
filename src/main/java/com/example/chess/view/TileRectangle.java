package com.example.chess.view;

import javafx.scene.shape.Rectangle;

public class TileRectangle extends Rectangle {

    private final int xCoordinate;
    private final int yCoordinate;

    public TileRectangle(int x, int y, int width, int height, int xCoordinate, int yCoordinate) {
        super(x, y, width, height);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString() {
        return "X: " + this.xCoordinate + ", Y: " + this.yCoordinate;
    }
}
