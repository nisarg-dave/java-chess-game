package com.game.chess;

import java.util.LinkedList;

public class Queen extends Piece {

    public Queen(PieceColour colour, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        super(colour, "Queen", xPosition, yPosition, pieces);
    }

    @Override
    public boolean movePiece(int newXPosition, int newYPosition, LinkedList<Piece> pieces) {
        // If end spot has piece of same colour
//        if (end.getPiece().getColour() == this.getColour()) {
//            return;
//        }
//
//        int x = Math.abs(start.getXPosition() - end.getXPosition());
//        int y = Math.abs(start.getYPosition() - end.getYPosition());
//
//        if (x - y == 0 || (x + y) % 1 == 0) {
//            // If there is a piece of the opposite colour, set it to killed
//            if (end.getPiece() != null) {
//                end.getPiece().killPiece();
//            }
//            end.setPiece(this);
//        }
        return false;
    }
}
