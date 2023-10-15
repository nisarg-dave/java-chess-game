package com.game.chess;

import java.util.LinkedList;

public class King extends Piece {
    public King(PieceColour colour, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        super(colour, "King", xPosition, yPosition, pieces);
    }

    @Override
    public boolean movePiece(int newXPosition, int newYPosition, LinkedList<Piece> pieces) {
        Piece pieceInNewPosition = null;

        for (Piece piece : pieces) {
            if (piece.getXPosition() == newXPosition && piece.getYPosition() == newYPosition) {
                pieceInNewPosition = piece;
            }
        }

        if (pieceInNewPosition != null) {
            // If end spot has piece of same colour
            if (pieceInNewPosition.getColour() == this.getColour()) {
                return false;
            }
        }

        int x = Math.abs(newXPosition - this.getXPosition());
        int y = Math.abs(newYPosition - this.getYPosition());

        // Stopping King from moving more than one jumps
        if (x > 1 || y > 1) {
            return false;
        }

        if ((x + y == 1) || (x - y) == 0) {
            // If there is a piece of the opposite colour, set it to killed
            if (pieceInNewPosition != null) {
                this.killPiece(pieceInNewPosition);
            }
            return true;
        }
        return false;
    }
}
