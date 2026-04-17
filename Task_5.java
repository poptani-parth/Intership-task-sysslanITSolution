// Develop a two-player console Tic-Tac-Toe game.

import java.util.Scanner;

public class Task_5 {
    static char[][] board = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOver = false;

        System.out.println("Welcome to Tic-Tac-Toe game!");

        while (!gameOver) {
            printBoard();

            System.out.println("Player 1: "+currentPlayer + " turn");
            System.out.print("Enter row (0-2) : ");
            int row = sc.nextInt();
            System.out.print("Enter column (0-2) : ");
            int col = sc.nextInt();

            if (row < 0 || col < 0 || row > 2 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid row or column");
                continue;
            }
            board[row][col] = currentPlayer;

            if (checkWin()){
                printBoard();
                System.out.println("Player "+ currentPlayer+" wins >>> Congratulations!");
                gameOver = true;
            }
            else if (boardFull()) {
                printBoard();
                System.out.println("Board is full");
                gameOver = true;
            }
            else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }

        }
        sc.close();

    }
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" | "+ board[i][0]+ " | " + board[i][1]+ " | " + board[i][2] + " | ");
            if (i<2) System.out.println("---------------");
        }
    }
    public static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&  board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board [0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }
    public static boolean boardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
