package com.game.chess;

import java.util.LinkedList;

public class Rook extends Piece {

    public Rook(PieceColour colour, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        super(colour, "Rook", xPosition, yPosition, pieces);
    }

    @Override
    public boolean movePiece(int newXPosition, int newYPosition, LinkedList<Piece> pieces) {
        Piece pieceInNewPosition = null;

        // Stopping it from moving diagonally
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

        for (Piece piece : pieces) {
            // Moving Down
            if (this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && this.getColour() == piece.getColour() && newYPosition > this.getYPosition()) {
                return false;
            }
            // Moving Up
            if (this.getYPosition() - 1 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && this.getColour() == piece.getColour() && newYPosition < this.getYPosition()) {
                return false;
            }
            // Moving Left
            if (this.getXPosition() - 1 == piece.getXPosition() && this.getYPosition() == piece.getYPosition() && this.getColour() == piece.getColour() && newXPosition < this.getXPosition()) {
                return false;
            }
            // Moving Right
            if (this.getXPosition() + 1 == piece.getXPosition() && this.getYPosition() == piece.getYPosition() && this.getColour() == piece.getColour() && newXPosition > this.getXPosition()) {
                return false;
            }
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

        if ((x + y) % 1 == 0) {
            // If there is a piece of the opposite colour, set it to killed
            if (pieceInNewPosition != null) {
                this.killPiece(pieceInNewPosition);
            }
            return true;
        }
        return false;
    }
}
