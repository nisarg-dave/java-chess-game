package com.game.chess;

import java.util.LinkedList;

public class Pawn extends Piece {

    public Pawn(PieceColour colour, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        super(colour, "Pawn", xPosition, yPosition, pieces);
    }

    @Override
    public boolean movePiece(int newXPosition, int newYPosition, LinkedList<Piece> pieces) {
        Piece pieceInNewPosition = null;

        for (Piece piece : pieces) {
            // Checking for Pawn of same colour in positions above and returning false
            // Double Jump
            if (((this.getColour() == PieceColour.BLACK && this.getYPosition() + 2 == piece.getYPosition()) || (this.getColour() == PieceColour.WHITE && this.getYPosition() - 2 == piece.getYPosition())) && this.getXPosition() == piece.getXPosition() && this.getColour() == piece.getColour()) {
                return false;
            }
            // Single Jump
            if (((this.getColour() == PieceColour.BLACK && this.getYPosition() + 1 == piece.getYPosition()) || (this.getColour() == PieceColour.WHITE && this.getYPosition() - 1 == piece.getYPosition())) && this.getXPosition() == piece.getXPosition() && this.getColour() == piece.getColour()) {
                return false;
            }
//            // Top Left
            if ((this.getColour() == PieceColour.BLACK && this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() - 1 == piece.getXPosition()) || (this.getColour() == PieceColour.WHITE && this.getXPosition() - 1 == piece.getXPosition() && this.getYPosition() - 1 == piece.getYPosition())) {
                System.out.println("Top Left " + piece.getColour().name() + " " + piece.getName());
                return false;
            }
            // Top Right
            if ((this.getColour() == PieceColour.BLACK && this.getYPosition() + 1 == piece.getYPosition() && this.getXPosition() + 1 == piece.getXPosition()) || (this.getColour() == PieceColour.WHITE && this.getXPosition() + 1 == piece.getXPosition() && this.getYPosition() - 1 == piece.getYPosition())) {
                System.out.println("TOP RIGHT " + piece.getColour().name() + " " + piece.getName());
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

        if (x + y == 1 || x + y == 2) {
            // If there is a piece of the opposite colour, set it to killed
            if (pieceInNewPosition != null) {
                this.killPiece(pieceInNewPosition);
            }
            return true;
        }
        return false;
    }
}
