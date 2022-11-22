package com.tictactoe.oops;

import java.util.Random;

public class Computer extends Player {

    private static int computerLocation;

    //To make the computer move
    public static void computerMove(Random random, char player, char computer)
    {
        int position = blockUser(player);
        if (position == 0)
        {
            computerLocation = random.nextInt(8)+1;//Random gives 0 to 8 so +1 give you 1 to 9 position.
        }
        else if (position != 0)
        {
            System.out.println("Computer block the position : "+position);
            computerLocation = position;
        }
        if (computerLocation > 0 && computerLocation < 10)
        {
            if (board[computerLocation] == ' ')
            {
                board[computerLocation] = computer;
                showBoard();
            }
            else if (board[computerLocation] != ' ')
            {
                computerMove(random, player, computer);
            }
        }
    }
}
