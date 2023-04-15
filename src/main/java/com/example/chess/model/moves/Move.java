package com.example.chess.model.moves;

import com.example.chess.model.Coordinates;

public class Move {

    private final Coordinates source;
    private final Coordinates destination;

    public Move(Coordinates source, Coordinates destination) {
        this.source = source;
        this.destination = destination;
    }

    public Coordinates getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "source: " + source.toString() + ", destination: " + destination.toString();
    }
}
