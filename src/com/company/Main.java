package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static Game game = new Game();

    public static void main(String[] args) {



        try {
            BufferedReader bReader = new BufferedReader(new FileReader("logo.txt"));
            bReader.lines()
                    .forEach(logo -> System.out.println(logo));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        game.gameInProgress();


/*        //do {
        game.createPlayer();
        game.changeActivePlayer();
        game.showActivePlayer();
        game.makeMove();
        //} while()*/
    }
}
