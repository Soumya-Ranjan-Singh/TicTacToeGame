package com.tictactoe.oops;

import java.util.Random;
import java.util.Scanner;

public class Game extends Computer {

    private static char player, computer;
    private static int toss;//For tossing between player and computer
    private static boolean computerFlag = false, playerFlag = false;
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    //Asking user to play again.
    public static void anotherGame() {
        System.out.println("\nWant to play again???\nPress Y for continue N to stop.");
        char playAgain = scan.next().charAt(0);
        while (true)
        {
            if (playAgain == 'y' || playAgain == 'Y')
            {
                startGame();
                anotherGame();
                break;
            }
            else if (playAgain == 'n' || playAgain == 'N')
            {
                break;
            }
            else
            {
                System.out.println("Wrong choice.\nProvide the valid choice");
                break;
            }
        }
    }

    //Starts the game
    public static void startGame() {
        initialize();//Initialize the board
        showBoard();//Showing the board
        chooseOption();//Check for player option
        toss();//Toss to check that who is going to play first
        while (checkTie())//1st run of game
        {
            System.out.println();
            turn();
            if (checkWinner(player,computer))
            {
                break;
            }
            else if (!checkTie())
            {
                System.out.println("Board is full");
                System.out.println("It is a tie");
            }
        }
        System.out.println("\nThe game is over.");
        computerFlag = false;
        playerFlag = false;
    }

    //Doing a toss for playing first
    public static void toss()
    {
        toss = random.nextInt(2);
        switch (toss)
        {
            case 0 :
                System.out.println("Flipping Tail.\nComputer starts first.");
                computerMove(random,player,computer);//Computer move
                computerFlag = true;
                break;
            case 1 :
                System.out.println("Flipping Head.\nPlayer starts first.");
                playerMove(scan,player,computer);//Player move
                playerFlag = true;
                break;
        }
    }

    //Allow player to choose X or O
    public static void chooseOption() {
        System.out.println("Please Select Your Choice Letter : \nProvide 'X' or 'O'");
        player = check();
        System.out.println("Player choosing option : "+player);
    }
    public static char check()  //Sub method of chooseOption
    {
        char choice = scan.next().charAt(0);
        if (choice == 'X' || choice == 'x')
        {
            player = 'X';
            computer = 'O';
        }
        else if (choice == 'O' || choice == 'o')
        {
            player = 'O';
            computer = 'X';
        }
        else
        {
            System.out.println("Invalid option.\nProvide the valid one");
            check();
        }
        return player;
    }

    //Check for turn
    public static void turn()
    {
        CheckConditions.checkGame(player,computer);
        System.out.println("Turn Changed");
        if (computerFlag == true)
        {
            System.out.println("Now Player's Turn");
            playerMove(scan, player, computer);
            computerFlag = false;
            playerFlag = true;
        }
        else if (playerFlag == true)
        {
            System.out.println("Now Computer's Turn");
            computerMove(random, player, computer);//Here it's how computer starts to play like me.
            playerFlag = false;
            computerFlag = true;
        }
    }

}
