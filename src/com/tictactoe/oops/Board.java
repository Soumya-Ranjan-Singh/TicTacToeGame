package com.tictactoe.oops;

public class Board {

    static char[] board = new char[10];

    //Initialization of game
    public static void initialize()
    {
        for (int i = 1; i < 10; i++)
        {
            board[i] = ' ';
        }
    }

    //To see board
    public static void showBoard()
    {
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    //To check free space
    public static void checkFreeSpace()
    {
        boolean isSpaceAvailable = false;
        int numOfFreeSpaces = 0;
        for(int index=1; index<board.length; index++)
        {
            if((board[index] == ' '))
            {
                isSpaceAvailable = true;
                numOfFreeSpaces++;
            }
        }
        if(isSpaceAvailable == false)
        {
            System.err.println("Board is full! You can't make another move");
        }
        else
        {
            System.out.println("Free space is available! you have "+numOfFreeSpaces+ " moves left");
        }
    }

    //Check for essential position
    public static void essentialPosition() {
        boolean corner = false;
        for (int i = 1; i < board.length; i++)
        {
            if ( i == 1 && board[i] == ' ')
            {
                System.out.println("Corner position 1 is available");
                corner = true;
            }
            else if (i == 3 && board[i] == ' ')
            {
                System.out.println("Corner position 3 is available");
                corner = true;
            }
            else if (i == 7 && board[i] == ' ')
            {
                System.out.println("Corner position 7 is available");
                corner = true;
            }
            else if (i == 9 && board[i] == ' ')
            {
                System.out.println("Corner position 9 is available");
                corner = true;
            }
        }
        if (!corner)
        {
            System.out.println("No more corner position is available");
            checkSubsequentPosition();//Checking for subsequent position
        }
    }

    //Check Subsequent Position
    public static void checkSubsequentPosition() {
        if (board[5] == ' ')
        {
            System.out.println("Mid position 5 is available");
        }
        else {
            for (int i = 2; i < board.length; i=i+2)// i started from 2 because available sides are 2 & 8 for vertical
            // and 4 & 6 are horizontal sides.
            {
                if (i == 2 && board[i] == ' ')
                {
                    System.out.println("Side position 2 is available");
                }
                else if (i == 4 && board[i] == ' ')
                {
                    System.out.println("Side position 4 is available");
                }
                else if (i == 6 && board[i] == ' ')
                {
                    System.out.println("Side position 6 is available");
                }
                else if (i == 8 && board[i] == ' ')
                {
                    System.out.println("Side position 8 is available");
                }
            }
        }
    }

}
