package com.game.chess;

public abstract class Piece {

    private int xPosition;
    private int yPosition;
    private boolean killed = false;
    private PieceColor color;

    public Piece(PieceColor color){
        this.color = color;
    }

    public boolean isKilled() {
        return this.killed;
    }

    public PieceColor getColor() {
        return this.color;
    }

    public void setKilled(){
        this.killed = true;
    }

    public abstract void movePiece(int xPosition, int yPosition);

}
