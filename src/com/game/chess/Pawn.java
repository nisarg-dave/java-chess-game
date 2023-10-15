package com.game.chess;

import java.util.LinkedList;

public class Pawn extends Piece {

    private boolean hasDoubleJumped = false;

    public Pawn(PieceColour colour, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        super(colour, "Pawn", xPosition, yPosition, pieces);
    }

    @Override
    public boolean movePiece(int newXPosition, int newYPosition, LinkedList<Piece> pieces) {
        Piece pieceInNewPosition = null;

        for (Piece piece : pieces) {
            // Checking for Pawn of same colour in positions above and returning false
            // Double Jump
            if ((this.getColour() == PieceColour.BLACK && this.getYPosition() + 2 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && !hasDoubleJumped && this.getColour() == piece.getColour()) || (this.getColour() == PieceColour.WHITE && this.getYPosition() - 2 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && !hasDoubleJumped && this.getColour() == piece.getColour())) {
                System.out.println(piece.getColour() + " " + piece.getName());
                return false;
            }
            // Single Jump
            if ((this.getColour() == PieceColour.BLACK && this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && this.getColour() == piece.getColour()) || (this.getColour() == PieceColour.WHITE && this.getYPosition() - 1 == piece.getYPosition() && this.getXPosition() == piece.getXPosition() && this.getColour() == piece.getColour())) {
                return false;
            }
            // Top Left
            if (this.getColour() == PieceColour.WHITE && this.getXPosition() - 1 == piece.getXPosition() && this.getYPosition() - 1 == piece.getYPosition() && this.getXPosition() > newXPosition && this.getYPosition() > newYPosition && this.getColour() == piece.getColour()) {
                return false;
            }
            // Top Right
            if (this.getColour() == PieceColour.WHITE && this.getXPosition() + 1 == piece.getXPosition() && this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() < newXPosition && this.getYPosition() > newYPosition && this.getColour() == piece.getColour()) {
                return false;
            }
            // Bottom Left
            if (this.getColour() == PieceColour.BLACK && this.getXPosition() - 1 == piece.getXPosition() && this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() > newXPosition && this.getYPosition() < newYPosition && this.getColour() == piece.getColour()) {
                return false;
            }
            if (this.getColour() == PieceColour.BLACK && this.getXPosition() + 1 == piece.getXPosition() && this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() < newXPosition && this.getYPosition() < newYPosition && this.getColour() == piece.getColour()) {
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

        if (!hasDoubleJumped) {
            if (x + y == 2) {
                // If there is a piece of the opposite colour, set it to killed
                if (pieceInNewPosition != null) {
                    this.killPiece(pieceInNewPosition);
                }
                hasDoubleJumped = true;
                return true;
            }
        } else {
            if (x + y == 1) {
                // If there is a piece of the opposite colour, set it to killed
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
