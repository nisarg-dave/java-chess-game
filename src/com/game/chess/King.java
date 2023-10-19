package com.game.chess;

import java.util.LinkedList;

public class King extends Piece {
    /**
     * Creates the King piece
     *
     * @param colour    the colour of the King
     * @param xPosition the X position of the King
     * @param yPosition the Y position of the King
     * @param pieces    the LinkedList that contains all the pieces
     */
    public King(PieceColour colour, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        // Passes parameters to parent's constructor
        super(colour, "King", xPosition, yPosition, pieces);
    }

    /**
     * Determines if the King can move the new position or not
     *
     * @param newXPosition the new X position of the piece
     * @param newYPosition the new Y position of the piece
     * @param pieces       the LinkedList that contains all the pieces
     * @return true if it can move and false if it can't move
     */
    @Override
    public boolean movePiece(int newXPosition, int newYPosition, LinkedList<Piece> pieces) {
        Piece pieceInNewPosition = null;

        // Iterate through all pieces in the LinkedList
        for (Piece piece : pieces) {
            // Checks if there is a piece in the new position
            if (piece.getXPosition() == newXPosition && piece.getYPosition() == newYPosition) {
                pieceInNewPosition = piece;
            }
        }

        if (pieceInNewPosition != null) {
            // If piece in the new position has the same colour
            if (pieceInNewPosition.getColour() == this.getColour()) {
                return false;
            }
        }

        // The absolute difference between new and current X and Y positions
        int x = Math.abs(newXPosition - this.getXPosition());
        int y = Math.abs(newYPosition - this.getYPosition());

        // Stopping King from moving more than one jumps
        if (x > 1 || y > 1) {
            return false;
        }

        if ((x + y == 1) || (x - y) == 0) {
            // If there is a piece of the opposite colour in the new position, kill the piece
            if (pieceInNewPosition != null) {
                this.killPiece(pieceInNewPosition);
            }
            return true;
        }
        return false;
    }
}
