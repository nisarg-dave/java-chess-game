package com.game.chess;

import java.util.LinkedList;

public class Pawn extends Piece {

    /**
     * Check to see if the Pawn has jumped two squares in its first move
     */
    private boolean hasDoubleJumped = false;

    /**
     * Creates the Pawn
     *
     * @param colour    the colour of the Pawn
     * @param xPosition the X position of the Pawn
     * @param yPosition the Y position of the Pawn
     * @param pieces    the LinkedList that contains all the pieces
     */
    public Pawn(PieceColour colour, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        // Passes parameters to parent's constructor
        super(colour, "Pawn", xPosition, yPosition, pieces);
    }

    /**
     * Determines if the Pawn can move to the new position or not
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

            // Checks if there is a piece of the same colour in the way when trying to double jump
            if ((this.getColour() == PieceColour.BLACK && this.getYPosition() + 2 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && !hasDoubleJumped && this.getColour() == piece.getColour()) || (this.getColour() == PieceColour.WHITE && this.getYPosition() - 2 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && !hasDoubleJumped && this.getColour() == piece.getColour())) {
                System.out.println(piece.getColour() + " " + piece.getName());
                return false;
            }
            // Checks if there is a piece of the same colour in the way when trying to single Jump
            if ((this.getColour() == PieceColour.BLACK && this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && this.getColour() == piece.getColour()) || (this.getColour() == PieceColour.WHITE && this.getYPosition() - 1 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && this.getColour() == piece.getColour())) {
                return false;
            }
            // Checks if there is a piece of the same colour in the way when trying to move in the top left diagonal direction
            if (this.getColour() == PieceColour.WHITE && this.getXPosition() - 1 == piece.getXPosition() && this.getYPosition() - 1 == piece.getYPosition() && this.getXPosition() > newXPosition && this.getYPosition() > newYPosition && this.getColour() == piece.getColour()) {
                return false;
            }
            // Checks if there is a piece of the same colour in the way when trying to move in the top right diagonal direction
            if (this.getColour() == PieceColour.WHITE && this.getXPosition() + 1 == piece.getXPosition() && this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() < newXPosition && this.getYPosition() > newYPosition && this.getColour() == piece.getColour()) {
                return false;
            }
            // Checks if there is a piece of the same colour in the way when trying to move in the bottom left diagonal direction
            if (this.getColour() == PieceColour.BLACK && this.getXPosition() - 1 == piece.getXPosition() && this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() > newXPosition && this.getYPosition() < newYPosition && this.getColour() == piece.getColour()) {
                return false;
            }
            // Checks if there is a piece of the same colour in the way when trying to move in the bottom right diagonal direction
            if (this.getColour() == PieceColour.BLACK && this.getXPosition() + 1 == piece.getXPosition() && this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() < newXPosition && this.getYPosition() < newYPosition && this.getColour() == piece.getColour()) {
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

        // If the King hasn't double jumped
        if (!hasDoubleJumped) {
            if (x + y == 2) {
                // If there is a piece of the opposite colour in the new position, kill the piece
                if (pieceInNewPosition != null) {
                    this.killPiece(pieceInNewPosition);
                }
                hasDoubleJumped = true;
                return true;
            }
        } else {
            if (x + y == 1) {
                // If there is a piece of the opposite colour in the new position, kill the piece
                if (pieceInNewPosition != null) {
                    this.killPiece(pieceInNewPosition);
                }
                hasDoubleJumped = true;
                return true;
            }
        }
        return false;

    }
}
