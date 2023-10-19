package com.game.chess;

import java.util.LinkedList;

public abstract class Piece {

    /**
     * The piece colour which is either black or white
     */
    private PieceColour colour;
    /**
     * The name of the piece
     */
    private String name;
    /**
     * The X position of the piece
     */
    private int xPosition;
    /**
     * The Y position of the piece
     */
    private int yPosition;
    /**
     * A LinkedList that holds all the pieces
     */
    private LinkedList<Piece> pieces;

    /**
     * Creates a new piece
     *
     * @param colour    the piece colour
     * @param name      the piece name
     * @param xPosition the piece's X Position
     * @param yPosition the piece's Y Position
     * @param pieces    the LinkedList of pieces
     */
    public Piece(PieceColour colour, String name, int xPosition, int yPosition, LinkedList<Piece> pieces) {
        this.colour = colour;
        this.name = name;
        this.pieces = pieces;
        // Adds the piece to the LinkedList of pieces
        this.pieces.add(this);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    /**
     * Gets the colour of the piece
     *
     * @return the piece colour
     */
    public PieceColour getColour() {
        return this.colour;
    }

    /**
     * Gets the name of the piece
     *
     * @return the name of the piece
     */
    public String getName() {
        return this.name;
    }

    /**
     * Determines if the piece can move or not
     *
     * @param newXPosition the new X position of the piece
     * @param newYPosition the new Y position of the piece
     * @param pieces       the LinkedList that contains all the pieces
     * @return true if the piece can move and false if it can't
     */
    public abstract boolean movePiece(int newXPosition, int newYPosition, LinkedList<Piece> pieces);

    /**
     * Removes the piece that is being killed by another piece from the LinkedList
     *
     * @param piece the piece that is killed
     */
    public void killPiece(Piece piece) {
        this.pieces.remove(piece);
    }

    /**
     * Returns the LinkedList that contains all the piece
     *
     * @return the pieces LinkedList
     */
    public LinkedList<Piece> getPieces() {
        return this.pieces;
    }

    /**
     * Gets the X position of the piece
     *
     * @return the X position
     */
    public int getXPosition() {
        return xPosition;
    }

    /**
     * Gets the Y position of the piece
     *
     * @return the Y Position
     */
    public int getYPosition() {
        return yPosition;
    }

    /**
     * Sets the X position of the piece
     *
     * @param xPosition the new X position
     */
    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * Sets the Y position of the piece
     *
     * @param yPosition the new Y Position
     */
    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
