package com.game.chess;

public class Queen extends Piece {

    public Queen(PieceColor color) {
        super(color);
    }

    @Override
    public boolean canMovePiece(Spot start, Spot end) {
        return true;
    }
}
