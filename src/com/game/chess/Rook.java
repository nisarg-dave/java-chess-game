package com.game.chess;

import java.util.LinkedList;

public class Rook extends Piece {

    /**
     * Creates the Rook piece
     *
     * @param colour    the colour of the Rook
     * @param xPosition the X position of the Rook
     * @param yPosition the Y position of the Rook
     * @param pieces    the LinkedList that contains all the pieces
     */
    public Rook(PieceColour colour, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        // Passes parameters to parent's constructor
        super(colour, "Rook", xPosition, yPosition, pieces);
    }

    /**
     * Determines if the Rook can move to the new position or not
     *
     * @param newXPosition the new X position of the piece
     * @param newYPosition the new Y position of the piece
     * @param pieces       the LinkedList that contains all the pieces
     * @return true if it can move and false if it can't move
     */
    @Override
    public boolean movePiece(int newXPosition, int newYPosition, LinkedList<Piece> pieces) {
        Piece pieceInNewPosition = null;

        // Stopping the Rook from moving diagonally
        // Top Left
        if (this.getXPosition() > newXPosition && this.getYPosition() > newYPosition) {
            return false;
        }
        // Bottom Left
        if (this.getXPosition() > newXPosition && this.getYPosition() < newYPosition) {
            return false;
        }
        // Top Right
        if (this.getXPosition() < newXPosition && this.getYPosition() > newYPosition) {
            return false;
        }
        // Bottom Right
        if (this.getXPosition() < newXPosition && this.getYPosition() < newYPosition) {
            return false;
        }

        // Iterate through all pieces in the LinkedList
        for (Piece piece : pieces) {
            // Checks if there is a piece of the same colour in the way when trying to move in the bottom direction
            if (this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && this.getColour() == piece.getColour() && newYPosition > this.getYPosition()) {
                return false;
            }
            // Checks if there is a piece of the same colour in the way when trying to move in the top direction
            if (this.getYPosition() - 1 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && this.getColour() == piece.getColour() && newYPosition < this.getYPosition()) {
                return false;
            }
            // Checks if there is a piece of the same colour in the way when trying to move in the left direction
            if (this.getXPosition() - 1 == piece.getXPosition() && this.getYPosition() == piece.getYPosition() && this.getColour() == piece.getColour() && newXPosition < this.getXPosition()) {
                return false;
            }
            // Checks if there is a piece of the same colour in the way when trying to move in the right direction
            if (this.getXPosition() + 1 == piece.getXPosition() && this.getYPosition() == piece.getYPosition() && this.getColour() == piece.getColour() && newXPosition > this.getXPosition()) {
                return false;
            }
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

        if ((x + y) % 1 == 0) {
            // If there is a piece of the opposite colour in the new position, kill the piece
            if (pieceInNewPosition != null) {
                this.killPiece(pieceInNewPosition);
            }
            return true;
        }
        return false;
    }
}
