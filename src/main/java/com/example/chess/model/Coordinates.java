package com.example.chess.model;

import java.util.Objects;

public class Coordinates {

    private final int xCoordinate;
    private final int yCoordinate;

    public Coordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return this.xCoordinate;
    }

    public int getyCoordinate() {
        return this.yCoordinate;
    }

    @Override
    public String toString() {
        return "X: " + xCoordinate + ", Y: " + yCoordinate ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return xCoordinate == that.xCoordinate && yCoordinate == that.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }

    public Coordinates addCoordinates(int xAddition, int yAddition) {
        return new Coordinates(this.xCoordinate + xAddition, this.yCoordinate + yAddition);
    }

    public boolean isValidCoordinate() {
        return this.xCoordinate >= 0 && this.yCoordinate >= 0 && this.xCoordinate < BoardUtils.RANK_COUNT && this.yCoordinate < BoardUtils.FILE_COUNT;
    }
}
