package com.tictactoe.oops;

import java.util.Scanner;

public class Player extends CheckConditions {

    private static int playerLocation;

    //To make the player move
    public static void playerMove(Scanner scan, char player, char computer)
    {
        checkFreeSpace();
        int position = blockUser(computer);
        essentialPosition();
        if (position == 0)
        {
            System.out.println("No position to be blocked.\nTry to win");
        }
        else if (position != 0)
        {
            System.out.println("Block you opponent on position : "+position);
            System.out.println("If you don't want to block try to win");
        }
        System.out.println("Enter the position between (1-9) you want to make your move :");
        playerLocation = scan.nextInt();
        if (playerLocation > 0 && playerLocation < 10)
        {
            if (board[playerLocation] == ' ')
            {
                board[playerLocation] = player;
                showBoard();
            }
            else if (board[playerLocation] != ' ')
            {
                System.err.println("Ah-hh! Position is already chosen. Enter a valid position");
                showBoard();
                playerMove(scan, player, computer);
                showBoard();
            }
        }
        else
        {
            System.err.println("Invalid choice. Provide a valid position between (1-9)");
            playerMove(scan, player, computer);
        }
    }
}
