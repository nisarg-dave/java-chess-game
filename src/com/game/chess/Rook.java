package com.game.chess;

public class Rook extends Piece {

    public Rook(PieceColor color) {
        super(color);
    }

    @Override
    public boolean canMovePiece(Spot start, Spot end) {
        return true;
    }
}
