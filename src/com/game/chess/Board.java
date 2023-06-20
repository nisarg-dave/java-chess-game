package com.game.chess;

public class Board {
    Spot[][] squares;

    public Board() {
        squares = new Spot[8][8];
        squares[0][0] = new Spot(0, 0, new Rook(PieceColour.BLACK));
        squares[0][1] = new Spot(0, 0, new Horse(PieceColour.BLACK));
        squares[0][2] = new Spot(0, 0, new Bishop(PieceColour.BLACK));
        squares[0][3] = new Spot(0, 0, new King(PieceColour.BLACK));
        squares[0][4] = new Spot(0, 0, new Queen(PieceColour.BLACK));
        squares[0][5] = new Spot(0, 0, new Bishop(PieceColour.BLACK));
        squares[0][6] = new Spot(0, 0, new Horse(PieceColour.BLACK));
        squares[0][7] = new Spot(0, 0, new Rook(PieceColour.BLACK));

        squares[7][0] = new Spot(0, 0, new Rook(PieceColour.WHITE));
        squares[7][1] = new Spot(0, 0, new Horse(PieceColour.WHITE));
        squares[7][2] = new Spot(0, 0, new Bishop(PieceColour.WHITE));
        squares[7][3] = new Spot(0, 0, new King(PieceColour.WHITE));
        squares[7][4] = new Spot(0, 0, new Queen(PieceColour.WHITE));
        squares[7][5] = new Spot(0, 0, new Bishop(PieceColour.WHITE));
        squares[7][6] = new Spot(0, 0, new Horse(PieceColour.WHITE));
        squares[7][7] = new Spot(0, 0, new Rook(PieceColour.WHITE));

        for (int i = 0; i < squares.length; i++) {
            squares[1][i] = new Spot(0, 0, new Pawn(PieceColour.BLACK));
            squares[6][i] = new Spot(0, 0, new Pawn(PieceColour.WHITE));
        }
    }

}
