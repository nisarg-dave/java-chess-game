package com.game.chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Board {
    // Static means the variable belongs to the class itself rather than to any specific instance of the class. This means that there is only one copy of the variable in memory, regardless of how many instances of the class are created
    private static LinkedList<Piece> pieces = new LinkedList<>();
    private static Piece selectedPiece = null;

    public Board() throws IOException {
        BufferedImage chessPiecesImage = ImageIO.read(new File("/Users/nisarg/Developer/chess-game/src/images/ChessPieces.png"));
        Image[] img = new Image[12];
        int ind = 0;
        // Goes across first row of image at 0 height and 200 wide and chops into smaller images and then repeats for 200 height.
        for (int y = 0; y < 400; y += 200) {
            for (int x = 0; x < 1200; x += 200) {
                img[ind] = chessPiecesImage.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }

        // Instantiate each piece and passing same instance of linkedlist to each has a reference to the same list
        Bishop wBishop1 = new Bishop(PieceColour.WHITE, 2, 7, pieces);
        Bishop wBishop2 = new Bishop(PieceColour.WHITE, 5, 7, pieces);
        Knight wKnight1 = new Knight(PieceColour.WHITE, 1, 7, pieces);
        Knight wKnight2 = new Knight(PieceColour.WHITE, 6, 7, pieces);
        King wKing = new King(PieceColour.WHITE, 4, 7, pieces);
        Queen wQueen = new Queen(PieceColour.WHITE, 3, 7, pieces);
        Rook wRook1 = new Rook(PieceColour.WHITE, 0, 7, pieces);
        Rook wRook2 = new Rook(PieceColour.WHITE, 7, 7, pieces);
        Pawn wPawn1 = new Pawn(PieceColour.WHITE, 0, 6, pieces);
        Pawn wPawn2 = new Pawn(PieceColour.WHITE, 1, 6, pieces);
        Pawn wPawn3 = new Pawn(PieceColour.WHITE, 2, 6, pieces);
        Pawn wPawn4 = new Pawn(PieceColour.WHITE, 3, 6, pieces);
        Pawn wPawn5 = new Pawn(PieceColour.WHITE, 4, 6, pieces);
        Pawn wPawn6 = new Pawn(PieceColour.WHITE, 5, 6, pieces);
        Pawn wPawn7 = new Pawn(PieceColour.WHITE, 6, 6, pieces);
        Pawn wPawn8 = new Pawn(PieceColour.WHITE, 7, 6, pieces);


        Bishop bBishop1 = new Bishop(PieceColour.BLACK, 2, 0, pieces);
        Bishop bBishop2 = new Bishop(PieceColour.BLACK, 5, 0, pieces);
        Knight bKnight1 = new Knight(PieceColour.BLACK, 1, 0, pieces);
        Knight bKnight2 = new Knight(PieceColour.BLACK, 6, 0, pieces);
        King bKing = new King(PieceColour.BLACK, 4, 0, pieces);
        Queen bQueen = new Queen(PieceColour.BLACK, 3, 0, pieces);
        Rook bRook1 = new Rook(PieceColour.BLACK, 0, 0, pieces);
        Rook bRook2 = new Rook(PieceColour.BLACK, 7, 0, pieces);
        Pawn bPawn1 = new Pawn(PieceColour.BLACK, 0, 1, pieces);
        Pawn bPawn2 = new Pawn(PieceColour.BLACK, 1, 1, pieces);
        Pawn bPawn3 = new Pawn(PieceColour.BLACK, 2, 1, pieces);
        Pawn bPawn4 = new Pawn(PieceColour.BLACK, 3, 1, pieces);
        Pawn bPawn5 = new Pawn(PieceColour.BLACK, 4, 1, pieces);
        Pawn bPawn6 = new Pawn(PieceColour.BLACK, 5, 1, pieces);
        Pawn bPawn7 = new Pawn(PieceColour.BLACK, 6, 1, pieces);
        Pawn bPawn8 = new Pawn(PieceColour.BLACK, 7, 1, pieces);


        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 515, 540);
        JPanel jPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white = true;
                // Vertical Squares
                for (int y = 0; y < 8; y++) {
                    // Horizontal Squares
                    for (int x = 0; x < 8; x++) {
                        if (white) {
                            g.setColor(new Color(227, 193, 111));
                        } else {
                            g.setColor(new Color(184, 139, 74));
                        }
                        // 64 width and 64 height and x and y are the coordinates
                        g.fillRect(x * 64, y * 64, 64, 64);
                        // Alternate the colour
                        white = !white;
                    }
                    // Alternate the colour
                    white = !white;
                }
                for (Piece p : wKing.getPieces()) {
                    int indx = 0;
                    if (p.getName().equalsIgnoreCase("king")) {
                        indx = 0;
                    }
                    if (p.getName().equalsIgnoreCase("queen")) {
                        indx = 1;
                    }
                    if (p.getName().equalsIgnoreCase("bishop")) {
                        indx = 2;
                    }
                    if (p.getName().equalsIgnoreCase("knight")) {
                        indx = 3;
                    }
                    if (p.getName().equalsIgnoreCase("rook")) {
                        indx = 4;
                    }
                    if (p.getName().equalsIgnoreCase("pawn")) {
                        indx = 5;
                    }
                    if (p.getColour() != PieceColour.WHITE) {
                        indx += 6;
                    }
                    g.drawImage(img[indx], p.getXPosition() * 64, p.getYPosition() * 64, this);
                }
            }
        };
        frame.add(jPanel);
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Printing name of piece based on position of mouse
                System.out.println(getPiece(e.getX(), e.getY()).getColour().name().toLowerCase() + " " + getPiece(e.getX(), e.getY()).getName());
                selectedPiece = getPiece(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedPiece != null) {
                    boolean canMove = selectedPiece.movePiece(e.getX() / 64, e.getY() / 64, pieces);
                    if (canMove) {
                        selectedPiece.setXPosition(e.getX() / 64);
                        selectedPiece.setYPosition(e.getY() / 64);
                    }
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Piece getPiece(int x, int y) {
        int xp = x / 64;
        int yp = y / 64;

        for (Piece p : pieces) {
            if (p.getXPosition() == xp && p.getYPosition() == yp) {
                return p;
            }
        }
        return null;

    }
}
