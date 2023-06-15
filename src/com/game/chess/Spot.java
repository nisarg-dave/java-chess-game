package com.game.chess;

public class Spot {
    private int xPosition;
    private int yPosition;
    private Piece piece;

    public Spot(int xPosition, int yPosition, Piece piece){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.piece = piece;
    }

    public Spot(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getXPosition(){
        return this.xPosition;
    }

    public int getYPosition(){
        return this.yPosition;
    }

    public Piece getPiece() { return this.piece; }

    public void setPiece(Piece piece){
        this.piece = piece;
    }
}
