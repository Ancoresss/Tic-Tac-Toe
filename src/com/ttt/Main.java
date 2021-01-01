package com.ttt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] mainTable = new int[3][3];
        int tries = 0, player = 0;
        Field field = new Field();

        field.table(mainTable);
        while(true) {
            step(mainTable, 1);
            tries++;
            field.table(mainTable);
            player = winner(mainTable, 1);
            if(player > 0) {
                System.out.println("Congratulations player " + player + "! You are win!");
                break;
            }
            if(tries == 9) {
                System.out.println("Congratulations to both players on the draw!");
                break;
            }
            step(mainTable, 2);
            tries++;
            field.table(mainTable);
            player = winner(mainTable, 2);
            if(player > 0) {
                System.out.println("Congratulations player " + player + "! You are win!");
                break;
            }
        }
    }

    public static void step(int[][] field, int numOfPlayer) {
        Scanner scan = new Scanner(System.in);
        int xNum, yNum;
        boolean validSec = false;
        do {
            System.out.print("Player " + numOfPlayer + ", please enter a cell: ");
            yNum = Integer.parseInt(scan.next()) - 1;
            xNum = Integer.parseInt(scan.next()) - 1;
            if(yNum > 2 || xNum > 2) {
                System.out.println("You have entered an invalid value. The number must be from 1 to 3! Enter another: ");
                validSec = false;
            } else if (field[yNum][xNum] == 1 || field[yNum][xNum] == 2) {
                System.out.println("You are using a busy cell! Enter another: ");
                validSec = false;
            } else {
                field[yNum][xNum] = numOfPlayer;
                validSec = true;
            }
        } while(!validSec);
    }

    public static int winner(int[][] field, int player) {
        if(field[0][0] == player && field[0][1] == player && field[0][2] == player) {
            return player;
        } else if(field[1][0] == player && field[1][1] == player && field[1][2] == player) {
            return player;
        } else if(field[2][0] == player && field[2][1] == player && field[2][2] == player) {
            return player;
        } else if(field[0][0] == player && field[1][0] == player && field[2][0] == player) {
            return player;
        } else if(field[0][1] == player && field[1][1] == player && field[2][1] == player) {
            return player;
        } else if(field[0][2] == player && field[1][2] == player && field[2][2] == player) {
            return player;
        } else if(field[0][0] == player && field[1][1] == player && field[2][2] == player) {
            return player;
        } else if(field[0][2] == player && field[1][1] == player && field[2][0] == player) {
            return player;
        } else {
            return 0;
        }
    }
}