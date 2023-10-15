package com.game.chess;

import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        try {
            Board board = new Board();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
