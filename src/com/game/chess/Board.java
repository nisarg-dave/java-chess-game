package com.game.chess;

public class Board {
    Spot[][] squares;

    public Board(){
        squares = new Spot[8][8];
        squares[0][0] = new Spot(0,0, new Rook(PieceColor.BLACK));
        squares[0][1] = new Spot(0,0, new Horse(PieceColor.BLACK));
        squares[0][2] = new Spot(0,0, new Bishop(PieceColor.BLACK));
        squares[0][3] = new Spot(0,0, new King(PieceColor.BLACK));
        squares[0][4] = new Spot(0,0, new Queen(PieceColor.BLACK));
        squares[0][5] = new Spot(0,0, new Bishop(PieceColor.BLACK));
        squares[0][6] = new Spot(0,0, new Horse(PieceColor.BLACK));
        squares[0][7] = new Spot(0,0, new Rook(PieceColor.BLACK));

        squares[7][0] = new Spot(0,0, new Rook(PieceColor.WHITE));
        squares[7][1] = new Spot(0,0, new Horse(PieceColor.WHITE));
        squares[7][2] = new Spot(0,0, new Bishop(PieceColor.WHITE));
        squares[7][3] = new Spot(0,0, new King(PieceColor.WHITE));
        squares[7][4] = new Spot(0,0, new Queen(PieceColor.WHITE));
        squares[7][5] = new Spot(0,0, new Bishop(PieceColor.WHITE));
        squares[7][6] = new Spot(0,0, new Horse(PieceColor.WHITE));
        squares[7][7] = new Spot(0,0, new Rook(PieceColor.WHITE));

        for(int i = 0; i < squares.length; i++){
            squares[1][i] = new Spot(0,0, new Pawn(PieceColor.BLACK));
            squares[6][i] = new Spot(0,0, new Pawn(PieceColor.WHITE));
        }
    }

}
