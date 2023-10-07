package com.game.chess;

import java.util.LinkedList;

public class Knight extends Piece {

    public Knight(PieceColour colour, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        super(colour, "Knight", xPosition, yPosition, pieces);
    }

    @Override
    public void movePiece(Square start, Square end) {

        // If end spot has piece of same colour
        if (end.getPiece().getColour() == this.getColour()) {
            return;
        }

        int x = Math.abs(start.getXPosition() - end.getXPosition());
        int y = Math.abs(start.getYPosition() - end.getYPosition());

        if (x * y == 2) {
            // If there is a piece of the opposite colour, set it to killed
            if (end.getPiece() != null) {
                end.getPiece().killPiece();
            }
            end.setPiece(this);
        }
    }
}