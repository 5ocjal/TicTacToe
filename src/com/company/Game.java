package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Game {

    Scanner input = new Scanner(System.in);
    Player player1;
    Player player2;
    Player currentPlayer = null;
    Board board;


    protected void createPlayer() {

        player1 = new Player(null, Mark.X, Mark.ACTIVE);
        player2 = new Player(null, Mark.O, Mark.unACTIVE);

        System.out.println("\nPODAJ IMIĘ GRACZA NR 1:");
        player1.setName(input.nextLine());
        System.out.println("Witaj " + player1.getName() + ", grasz znakiem " + player1.getPlayerMark() + "\n");

        System.out.println("PODAJ IMIĘ GRACZA NR 2:");
        player2.setName(input.nextLine());
        System.out.println("Cześć " + player2.getName() + ", grasz znakiem " + player2.getPlayerMark() + "\n");

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
                    " Podaj współrzędne pola, na którym chcesz postawić znacznik " + currentPlayer.playerMark + ":\n");
        } else {
            currentPlayer = player2;
            System.out.println(player2.getName() + " " + player2.active.getMark() +
                    " Podaj współrzędne pola, na którym chcesz postawić znacznik " + currentPlayer.playerMark + ":\n");
        }
    }

    protected void makeMove() {

        try {
            System.out.println("Podaj rząd: ");
            board.row = input.nextInt();
            if (board.row < 1 || board.row > 3) {
                System.out.println("Podaj wartość od 1 do 3!\n");
                makeMove();
            } else {
                System.out.println("Podaj kolumnę: ");
                board.col = input.nextInt();
                if (board.col < 1 || board.col > 3) {
                    System.out.println("Podaj wartość od 1 do 3!\n");
                    makeMove();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Podaj wartość od 1 do 3!\n");
            makeMove();
        }
    }
}

