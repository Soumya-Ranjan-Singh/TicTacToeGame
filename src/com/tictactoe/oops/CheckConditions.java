package com.tictactoe.oops;

public class CheckConditions extends Board {
    
    //Check for winning, tie or change turn
    public static void checkGame(char player, char computer)
    {
        if (gameChecker(player))
        {
            System.out.println("Player going to win");
        }
        else if (gameChecker(computer))
        {
            System.out.println("Computer going to win");
        }
        else
            System.out.println("It may be a tie.");
    }

    public static boolean gameChecker(char ch)  //secondary method of above
    {
        if
        (( board[1] == ch && board[2] == ch && board[3] == ' '
                || board[2] == ch && board[3] == ch && board[1] == ' '
                || board[1] == ch && board[3] == ch && board[2] == ' ')
                || (board[4] == ch && board[5] == ch && board[6] == ' '
                || board[5] == ch && board[6] == ch && board[4] == ' '
                || board[4] == ch && board[6] == ch && board[5] == ' ')
                || (board[7] == ch && board[8] == ch && board[9] == ' '
                || board[8] == ch && board[9] == ch && board[7] == ' '
                || board[7] == ch && board[9] == ch && board[8] == ' ')
                || (board[1] == ch && board[5] == ch && board[9] == ' '
                || board[5] == ch && board[9] == ch && board[1] == ' '
                || board[1] == ch && board[9] == ch && board[5] == ' ')
                || (board[3] == ch && board[5] == ch && board[7] == ' '
                || board[5] == ch && board[7] == ch && board[3] == ' '
                || board[3] == ch && board[7] == ch && board[5] == ' ')
                || (board[1] == ch && board[4] == ch && board[7] == ' '
                || board[4] == ch && board[7] == ch && board[1] == ' '
                || board[1] == ch && board[7] == ch && board[4] == ' ')
                || (board[2] == ch && board[5] == ch && board[8] == ' '
                || board[5] == ch && board[8] == ch && board[2] == ' '
                || board[2] == ch && board[8] == ch && board[5] == ' ')
                || (board[3] == ch && board[6] == ch && board[9] == ' '
                || board[6] == ch && board[9] == ch && board[3] == ' '
                || board[3] == ch && board[9] == ch && board[6] == ' '))
            return true;
        return false;
    }

    //Winning condition
    public static boolean checkWinner(char player, char computer)
    {
        if (winChecker(player))
        {
            System.out.println("Wait we got winner\nWinner is Player");
            return true;
        }
        else if (winChecker(computer))
        {
            System.out.println("Wait we got winner\nWinner is Computer");
            return true;
        }
        return false;
    }

    public static boolean winChecker(char ch)   //secondary method of above
    {
        if ((board[1] == ch && board[2] == ch && board[3] == ch) ||
                (board[4] == ch && board[5] == ch && board[6] == ch) ||
                (board[7] == ch && board[8] == ch && board[9] == ch) ||
                (board[1] == ch && board[5] == ch && board[9] == ch) ||
                (board[3] == ch && board[5] == ch && board[7] == ch) ||
                (board[1] == ch && board[4] == ch && board[7] == ch) ||
                (board[2] == ch && board[5] == ch && board[8] == ch) ||
                (board[3] == ch && board[6] == ch && board[9] == ch))
            return true;
        return false;
    }

    //Checking for tie condition
    public static boolean checkTie()
    {
        for (char inBoard : board)
        {
            if (inBoard == ' ')
                return true;
        }
        return false;
    }

    //Check to block opponent
    public static int blockUser(char input)
    {
        char ch = input;
        int blockPosition = 0;
        if (ch == input)
        {
            if ((board[1] == ch && board[2] == ch && board[3] == ' ') || (board[5] == ch && board[7] == ch && board[3] == ' ') || (board[6] == ch && board[9] == ch && board[3] == ' '))
            {
                blockPosition = 3;
                return blockPosition;
            }
            else if ((board[2] == ch && board[3] == ch && board[1] == ' ') || (board[5] == ch && board[9] == ch && board[1] == ' ') || (board[4] == ch && board[7] == ch && board[1] == ' '))
            {
                blockPosition = 1;
                return blockPosition;
            }
            else if ((board[1] == ch && board[3] == ch && board[2] == ' ') || (board[5] == ch && board[8] == ch && board[2] == ' '))
            {
                blockPosition = 2;
                return blockPosition;
            }
            else if ((board[4] == ch && board[5] == ch && board[6] == ' ') || (board[3] == ch && board[9] == ch && board[6] == ' '))
            {
                blockPosition = 6;
                return blockPosition;
            }
            else if ((board[5] == ch && board[6] == ch && board[4] == ' ') || (board[1] == ch && board[7] == ch && board[4] == ' '))
            {
                blockPosition = 4;
                return blockPosition;
            }
            else if ((board[4] == ch && board[6] == ch && board[5] == ' ') || (board[1] == ch && board[9] == ch && board[5] == ' ')
                    || (board[3] == ch && board[7] == ch && board[5] == ' ') || (board[2] == ch && board[8] == ch && board[5] == ' '))
            {
                blockPosition = 5;
                return blockPosition;
            }
            else if ((board[7] == ch && board[8] == ch && board[9] == ' ') || (board[1] == ch && board[5] == ch && board[9] == ' ') || (board[3] == ch && board[6] == ch && board[9] == ' '))
            {
                blockPosition = 9;
                return blockPosition;
            }
            else if ((board[8] == ch && board[9] == ch && board[7] == ' ') || (board[3] == ch && board[5] == ch && board[7] == ' ') || (board[1] == ch && board[4] == ch && board[7] == ' '))
            {
                blockPosition = 7;
                return blockPosition;
            }
            else if ((board[7] == ch && board[9] == ch && board[8] == ' ') || (board[2] == ch && board[5] == ch && board[8] == ' '))
            {
                blockPosition = 8;
                return blockPosition;
            }
        }
        return blockPosition;
    }
}
