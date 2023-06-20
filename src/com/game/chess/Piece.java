package com.game.chess;

public abstract class Piece {

    private boolean killed = false;
    private PieceColour colour;

    public Piece(PieceColour colour) {
        this.colour = colour;
    }

    public boolean isKilled() {
        return this.killed;
    }

    public PieceColour getColour() {
        return this.colour;
    }

    public void setKilled() {
        this.killed = true;
    }

    public abstract void movePiece(Spot start, Spot end);

}
