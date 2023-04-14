package com.example.chess.model.moves;

public enum MoveDirection {
    LEFT_UPPER(-1, -1),
    LEFT_LOWER(-1, 1),
    RIGHT_UPPER(1, -1),
    RIGHT_LOWER(1, 1),
    LEFT(-1, 0),
    RIGHT(0, -1),
    UPPER(0, -1),
    LOWER(0, 1);

    public final int xDirection;
    public final int yDirection;

    MoveDirection(int xDirection, int yDirection) {
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }
}
