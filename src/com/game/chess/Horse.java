package com.game.chess;

public class Horse extends Piece {

    public Horse(PieceColor color) {
        super(color);
    }

    @Override
    public boolean canMovePiece(Spot start, Spot end) {
        return true;
    }
}
