package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Game {

    Scanner input = new Scanner(System.in);
    Player player1;
    Player player2;
    Player currentPlayer = null;
    Board board;


    public Game() {
        this.board = new Board();
    }

    public void gameInProgress() {
        createPlayer();

        do {
            changeActivePlayer();
            showActivePlayer();
            makeMove();
        }
        while (board.isGameBoardFull());
        // check for win

    }


    protected void createPlayer() {

        player1 = new Player(null, Mark.markX, Mark.ACTIVE);
        player2 = new Player(null, Mark.markO, Mark.unACTIVE);

        System.out.println("\nPODAJ IMIĘ GRACZA NR 1:");
        player1.setName(input.nextLine());
        System.out.println("Witaj " + player1.getName() + ", grasz znakiem " + player1.active.getMark() + "\n");

        System.out.println("PODAJ IMIĘ GRACZA NR 2:");
        player2.setName(input.nextLine());
        System.out.println("Cześć " + player2.getName() + ", grasz znakiem " + player2.active.getMark() + "\n");

        System.out.println("POWODZENIA!\n");


        board.createGameBoard();
        board.printGameBoard();
    }

    protected void changeActivePlayer() {

        if (player1.getActive() == Mark.ACTIVE) {
            player1.setActive(Mark.unACTIVE);
            player2.setActive(Mark.ACTIVE);
        } else {
            player1.setActive(Mark.ACTIVE);
            player2.setActive(Mark.unACTIVE);
        }
    }

    protected void showActivePlayer() {

        if (player1.getActive() == Mark.ACTIVE) {
            currentPlayer = player1;
            System.out.println(player1.getName() + " " + player1.active.getMark() +
                    " Podaj współrzędne pola, na którym chcesz postawić znacznik " + currentPlayer.active.getMark() + ":\n");
        } else {
            currentPlayer = player2;
            System.out.println(player2.getName() + " " + player2.active.getMark() +
                    " Podaj współrzędne pola, na którym chcesz postawić znacznik " + currentPlayer.active.getMark() + ":\n");
        }
    }

    protected void makeMove() {

        try {
            System.out.println("Podaj rząd: ");
            board.row = input.nextInt() - 1;
            if (board.row < 0 || board.row > 2) {
                System.out.println("Podaj wartość od 1 do 3!\n");
                makeMove();
            } else {
                System.out.println("Podaj kolumnę: ");
                board.col = input.nextInt() - 1;
                if (board.col < 0 || board.col > 2) {
                    System.out.println("Podaj wartość od 1 do 3!\n");
                    makeMove();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Podaj wartość od 1 do 3!\n");
            makeMove();
        }

        if (!board.gameBoard[board.row][board.col].equals(Mark.EMPTY)) {
            board.setMarkOnGameBoard(board.row, board.col, currentPlayer);
        } else {
            System.out.println("Pole jest już zajętę. Wybierz inne!");
            makeMove();
        }

    }
}

