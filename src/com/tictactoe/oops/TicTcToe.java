package com.tictactoe.oops;

public class TicTcToe extends Game {

    //Creating a default constructor
    public TicTcToe() {
        System.out.println("Welcome to Tic Tac Toe Game !!!");
    }

    public static void main(String[] args) {

        //Initialize the object
        TicTcToe obj = new TicTcToe();

        //Starting the game.
        startGame();

        //For playing again
        anotherGame();

    }
}
