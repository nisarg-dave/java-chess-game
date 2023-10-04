package com.game.chess;

import java.util.LinkedList;

public abstract class Piece {

    private PieceColour colour;

    private LinkedList<Piece> pieces = new LinkedList();

    public Piece(PieceColour colour) {
        this.colour = colour;
        this.pieces.add(this);
    }

    public PieceColour getColour() {
        return this.colour;
    }

    public void killPiece() {
        this.pieces.remove(this);
    }

    public LinkedList<Piece> getPieces() {
        return this.pieces;
    }

    public abstract void movePiece(Square start, Square end);

}
