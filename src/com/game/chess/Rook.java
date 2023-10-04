package com.game.chess;

public class Rook extends Piece {

    public Rook(PieceColour colour) {
        super(colour);
    }

    @Override
    public void movePiece(Square start, Square end) {
        // If end spot has piece of same colour
        if (end.getPiece().getColour() == this.getColour()) {
            return;
        }

        int x = Math.abs(start.getXPosition() - end.getXPosition());
        int y = Math.abs(start.getYPosition() - end.getYPosition());

        if ((x + y) % 1 == 0) {
            // If there is a piece of the opposite colour, set it to killed
            if (end.getPiece() != null) {
                end.getPiece().killPiece();
            }
            end.setPiece(this);
        }
    }
}
