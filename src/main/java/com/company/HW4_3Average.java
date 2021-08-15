package com.company;

import java.util.Random;

public class HW4_3Average {
    public static void main(String[] args) {
        // 3 Написать программу, которая считает среднее арифметическое всех элементов в массиве из 10 случайных чисел.

        Random random = new Random();
        int[] array = new int[10];
        double result = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            result += array[i];
            System.out.println(array[i]);
        }
        System.out.println("Average " + result / array.length);
    }
}
