package com.game.chess;

public class King extends Piece {
    public King(PieceColor color) {
        super(color);
    }

    @Override
    public boolean canMovePiece(Spot start, Spot end) {
        if (end.getPiece().getColor() == this.getColor()) {
            return false;
        }
        int x = Math.abs(start.getXPosition() - end.getXPosition());
        int y = Math.abs(start.getYPosition() - end.getYPosition());

        return x + y == 1;

    }
}
