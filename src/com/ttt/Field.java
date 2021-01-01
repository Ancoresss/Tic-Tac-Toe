package com.ttt;

public class Field {
    public void table(int[][] array) {
        final int[][] field = new int[5][19];
        int xCor, yCor;
        for(int k = 0; k < 3; k++) {
            for(int p = 0; p < 3; p++) {
                if(array[k][p] == 1) {
                    xCor = p * 6 + 3;
                    yCor = k * 2;
                    field[yCor][xCor] = 1;
                } else if(array[k][p] == 2) {
                    xCor = p * 6 + 3;
                    yCor = k * 2;
                    field[yCor][xCor] = 2;
                }
            }
        }
        //draw the field
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 19; j++) {
                if(i % 2 == 0) {
                    if(j == 6 || j == 12) {
                        System.out.print("|");
                    } else if(field[i][j] == 1) {
                        System.out.print("X");
                    } else if(field[i][j] == 2) {
                        System.out.print("O");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print('-');
                }
            }
            System.out.println();
        }
    }
}