package com.example.chess.model;

import com.example.chess.model.pieces.Piece;

import java.util.ArrayList;

public class Faction {

    private boolean hasNextMove;
    private final FactionColor factionColor;

    public Faction(boolean hasNextMove, FactionColor factionColor) {
        this.hasNextMove = hasNextMove;
        this.factionColor = factionColor;
    }

    public void executeNextMove() { }
}
