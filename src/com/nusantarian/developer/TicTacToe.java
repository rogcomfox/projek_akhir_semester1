package com.nusantarian.developer;

import java.util.Scanner;

class TicTacToe {
    private char [][] board;
    private char currentPlayer;

    TicTacToe(){
        board = new char[3][3];
        currentPlayer = 'x';
        boardset();
    }

    char getCurrentPlayer() {
        return currentPlayer;
    }

    void boardset() {
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }
    }

    void boardInterface(){
        System.out.println("-----------");
        for (int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-----------");
        }
    }

    boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                    break;
                }
            }
        }

        return isFull;
    }

    boolean isWinner() {
        return (!checkRows() && !checkColumns() && !checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) || (checkRowCol(board[0][2], board[1][1], board[2][0])));
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    void changePlayer() {
        if (currentPlayer == 'x') {
            currentPlayer = 'o';
        }
        else {
            currentPlayer = 'x';
        }
    }

    boolean placeMark(int row, int col) {
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayer;
                    return true;
                }
            }
        }

        return false;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        TicTacToe tc = new TicTacToe();
        tc.boardset();
        do {
            System.out.println("Progress Permainan");
            tc.boardInterface();
            int row, col;
            do {
                System.out.println("Player " + tc.getCurrentPlayer() + ", Masukkan Pilihan Kolom dan Baris");
                System.out.print("Kolom : ");
                row = in.nextInt()-1;
                System.out.print("Baris : ");
                col = in.nextInt()-1;
            }while (!tc.placeMark(row, col));
            tc.changePlayer();
        } while(tc.isWinner() && !tc.isBoardFull());

        if (tc.isBoardFull() && tc.isWinner()) {
            System.out.println("Hasil Seri");
        } else {
            System.out.println("Progress Permainan");
            tc.boardInterface();
            tc.changePlayer();
            System.out.println(Character.toUpperCase(tc.getCurrentPlayer()) + " adalah Juara!");
        }
    }
}
