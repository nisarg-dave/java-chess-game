package com.game.chess;

public class Pawn extends Piece {

    public Pawn(PieceColour colour) {
        super(colour);
    }

    @Override
    public void movePiece(Spot start, Spot end) {
        // If end spot has piece of same colour
        if (end.getPiece().getColour() == this.getColour()) {
            return;
        }

        int x = Math.abs(start.getXPosition() - end.getXPosition());
        int y = Math.abs(start.getYPosition() - end.getYPosition());

        if (x + y == 1 || x + y == 2) {
            // If there is a piece of the opposite colour, set it to killed
            if (end.getPiece() != null) {
                end.getPiece().setKilled();
            }
            end.setPiece(this);
        }
    }
}
