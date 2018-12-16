package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        try {
            BufferedReader bReader = new BufferedReader(new FileReader("logo.txt"));
            bReader.lines()
                    .forEach(logo -> System.out.println(logo));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        game.createPlayer();

        //do {
        game.changeActivePlayer();
        game.showActivePlayer();
        game.makeMove();




         //} while()
}
}
