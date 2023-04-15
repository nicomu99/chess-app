package com.example.chess.view;

import com.example.chess.model.Coordinates;
import javafx.scene.shape.Rectangle;

public class TileRectangle extends Rectangle {

    private final Coordinates coordinates;

    public TileRectangle(int x, int y, int width, int height, int xCoordinate, int yCoordinate) {
        super(x, y, width, height);
        this.coordinates = new Coordinates(xCoordinate, yCoordinate);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
