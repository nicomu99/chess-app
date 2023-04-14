package com.example.chess.model.moves;

import java.util.ArrayList;

public enum MoveDirection {
    LEFT_UPPER(-1, -1),
    LEFT_LOWER(-1, 1),
    RIGHT_UPPER(1, -1),
    RIGHT_LOWER(1, 1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    UPPER(0, -1),
    LOWER(0, 1);

    public final int xDirection;
    public final int yDirection;

    MoveDirection(int xDirection, int yDirection) {
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public static ArrayList<MoveDirection> getDiagonalDirections() {
        ArrayList<MoveDirection> directions = new ArrayList<>();
        directions.add(LEFT_LOWER);
        directions.add(LEFT_UPPER);
        directions.add(RIGHT_LOWER);
        directions.add(RIGHT_UPPER);

        return directions;
    }

    public static ArrayList<MoveDirection> getStraightMoveDirections() {
        ArrayList<MoveDirection> directions = new ArrayList<>();
        directions.add(LEFT);
        directions.add(UPPER);
        directions.add(LOWER);
        directions.add(RIGHT);

        return directions;
    }
}
