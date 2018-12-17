package com.company;


public class Board {

    Mark gameBoard[][] = new Mark[3][3];
    public int row;
    public int col;

    public void createGameBoard() {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = Mark.EMPTY;
            }
        }
    }

    public void printGameBoard() {

        System.out.println("-------------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j].getMark() + " | ");
            }
            System.out.println("\n-------------------");
        }
    }

    protected void setMarkOnGameBoard(int x, int y, Player currentPlayer) {

        gameBoard[x][y] = currentPlayer.getPlayerMark();
        isGameBoardFull();
        printGameBoard();



    }

    protected boolean isGameBoardFull() {
        for (int i = 0; i < gameBoard.length; i++)
            for (int j = 0; j < gameBoard[i].length; j++)
                if (gameBoard[i][j].equals(Mark.EMPTY))
                    return false;
        return true;
    }

    private boolean checkForVictory(Mark col1, Mark col2, Mark col3) {
        return (!col1.equals(Mark.EMPTY) && (col2.equals(col1)) && (col3.equals(col2)));
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkForVictory(gameBoard[i][0], gameBoard[i][1], gameBoard[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColums() {
        for (int i = 0; i < 3; i++) {
            if (checkForVictory(gameBoard[0][i], gameBoard[1][i], gameBoard[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal() {
        if ((checkForVictory(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]))
                || (checkForVictory(gameBoard[0][2], gameBoard[1][1], gameBoard[2][0]))) {
            return true;
        }
        return false;
    }

}


