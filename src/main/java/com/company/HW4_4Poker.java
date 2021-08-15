package com.company;

import java.util.ArrayList;
import java.util.Random;

public class HW4_4Poker {
    public static void main(String[] args) {
       /* Написать программу, которая должна имитировать раздачу карт для игры в покер.
       За столом сидят 4 игрока, каждый из них получает на руки 5 карт.
       Карты должны быть случайными и не повторяться.
       Формат вывода на экран: “Игрок N получает карту <НАЗВАНИЕ КАРТЫ>” */

        int[][] game = new int[4][5];
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                while (true) {
                    int a = random.nextInt(52);
                    if (!arrayList.contains(a)) {
                        arrayList.add(a);
                        game[i][j] = a;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + game[i][j]);
            }
            System.out.println();
        }
    }
}
