package com.game.chess;

public class Bishop extends Piece {

    public Bishop(PieceColor color) {
        super(color);
    }

    @Override
    public boolean canMovePiece(Spot start, Spot end) {
        return true;
    }
}
