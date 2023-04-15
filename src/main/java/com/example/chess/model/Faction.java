package com.example.chess.model;

public class Faction {

    private boolean hasNextMove;
    private final FactionColor factionColor;

    public Faction(boolean hasNextMove, FactionColor factionColor) {
        this.hasNextMove = hasNextMove;
        this.factionColor = factionColor;
    }

    public boolean hasNextMove() {
        return hasNextMove;
    }

    public void setHasNextMove(boolean hasNextMove) {
        this.hasNextMove = hasNextMove;
    }

    public void executeNextMove() { }
}
