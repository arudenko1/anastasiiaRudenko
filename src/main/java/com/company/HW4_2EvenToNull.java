package com.company;

import java.util.Random;

public class HW4_2EvenToNull {

    public static void main(String[] args) {
    /*2 Написать программу, которая в массиве из случайных чисел заменяет все чётные числа на 0 и выводит полученный массив на экран.
    Для генерации случайных чисел можно использовать Random. */

        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            int x = random.nextInt(100);
            array[i] = x;
            if (x % 2 == 0) {
                array[i] = 0;
            }
            System.out.println(array[i]);
        }
    }
}
