package com.game.chess;

public class Pawn extends Piece {

    public Pawn(PieceColor color) {
        super(color);
    }

    @Override
    public boolean canMovePiece(Spot start, Spot end) {
        return true;
    }
}
