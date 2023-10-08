package com.game.chess;

import java.io.IOException;
import java.util.LinkedList;

public abstract class Piece {

    private PieceColour colour;
    private String name;
    private int xPosition;
    private int yPosition;
    private LinkedList<Piece> pieces;


    public Piece(PieceColour colour, String name, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        this.colour = colour;
        this.name = name;
        this.pieces = pieces;
        this.pieces.add(this);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public PieceColour getColour() {
        return this.colour;
    }

    public String getName() {
        return this.name;
    }

    public abstract boolean movePiece(int newXPosition, int newYPosition, LinkedList<Piece> pieces);

    public void killPiece(Piece piece) {
        this.pieces.remove(piece);
    }

    public LinkedList<Piece> getPieces() {
        return this.pieces;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
