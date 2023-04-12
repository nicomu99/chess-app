package com.example.chess.model;

public class ModelHandler {

    private Faction whiteFaction;
    private Faction blackFaction;

    private Board board;

    public ModelHandler() {
        this.whiteFaction = new Faction(true, FactionColor.WHITE);
        this.blackFaction = new Faction(false, FactionColor.BLACK);
    }

    public Board getBoard() {
        return this.board;
    }

    public void initializeGame() {
        this.board = BoardBuilder.buildBoard();
        System.out.print(this.board.toString());
    }
}
