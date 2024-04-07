package game;

import board.QueenBoard;

public class NQueenGame {
    QueenBoard nq;

    public NQueenGame(QueenBoard nq) {
        this.nq = nq;
    }

    public void play() {
        if (nq.size < 4) {
            System.out.println("No Configuration Available");
            return;
        }

        nqueen_helper(nq.board, 0);
    }

    private void nqueen_helper(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            System.out.println("###################################");
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafeQueen(board, row, col)) {
                board[row][col] = 'Q';
                nqueen_helper(board, row + 1);
                board[row][col] = '-';
            }
        }

    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isSafeQueen(char[][] board, int row, int col) {
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; j < board.length && i >= 0; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        return true;

    }
}
