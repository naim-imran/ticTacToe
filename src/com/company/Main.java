package com.company;

import java.util.Scanner;

public class Main {
    public static String player1;
    public static String player2;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter the name of player 1 : ");
        player1 = scanner.next();
        System.out.println(player1 + ", your symbol is \" # \"");
        System.out.println();
        System.out.print("Enter the name of player 2 : ");
        player2 = scanner.next();
        System.out.println(player2 + ", your symbol is \" X \"");
        System.out.println();

        char[][] board = {{'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}};
        System.out.println("This is the game board that has places 1 to 9. " +
                "\nEnter the number displayed on the board where you want to place your move.");

        printBoard(board);
        while (true) {
            play(player1, board);
            printBoard(board);
            if (isWinner(board)) {
                System.out.println(player1 + ", you have won");
                break;
            }
            if(isTie(board)) {
                System.out.println("game tie");
                break;
            }
            play(player2, board);
            printBoard(board);
            if (isWinner(board)) {
                System.out.println(player2 + ", you have won");
                break;
            }
            if(isTie(board)) {
                System.out.println("game tie");
                break;
            }
        }

    }

    private static void play(String player, char[][] board) {
        System.out.print(player + ", its your move: ");

        char symbol;
        if (player.equals(player1)) {
            symbol = '#';
        } else
            symbol = 'X';

        int placement;
        while (true) {
            placement = scanner.nextInt();
            if (!(placementValidation(board, placement))) {
                break;
            }
            System.out.println("This place is already taken");
            System.out.print("choose a valid place :");
        }

        switch (placement) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
        }
    }

    private static boolean placementValidation(char[][] board, int value) {

        switch (value) {
            case 1:
                return (board[0][0] == 'X' || board[0][0] == '#');
            case 2:
                return (board[0][1] == 'X' || board[0][1] == '#');
            case 3:
                return (board[0][2] == 'X' || board[0][2] == '#');
            case 4:
                return (board[1][0] == 'X' || board[1][0] == '#');
            case 5:
                return (board[1][1] == 'X' || board[1][1] == '#');
            case 6:
                return (board[1][2] == 'X' || board[1][2] == '#');
            case 7:
                return (board[2][0] == 'X' || board[2][0] == '#');
            case 8:
                return (board[2][1] == 'X' || board[2][1] == '#');
            case 9:
                return (board[2][2] == 'X' || board[2][2] == '#');
            default:
                return true;

        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("--+---+--");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("--+---+--");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println();
    }

    private static boolean isWinner(char[][] board) {
        return ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||
                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
                (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||
                (board[0][0] == '#' && board[0][1] == '#' && board[0][2] == '#') ||
                (board[1][0] == '#' && board[1][1] == '#' && board[1][2] == '#') ||
                (board[2][0] == '#' && board[2][1] == '#' && board[2][2] == '#') ||
                (board[0][0] == '#' && board[1][0] == '#' && board[2][0] == '#') ||
                (board[0][1] == '#' && board[1][1] == '#' && board[2][1] == '#') ||
                (board[0][2] == '#' && board[1][2] == '#' && board[2][2] == '#') ||
                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') ||
                (board[0][0] == '#' && board[1][1] == '#' && board[2][2] == '#') ||
                (board[0][2] == '#' && board[1][1] == '#' && board[2][0] == '#'));
    }

    private static boolean isTie(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!(board[i][j] == 'X' || board[i][j] == '#')) {
                    return false;
                }
            }
        }
        return true;
    }
}
