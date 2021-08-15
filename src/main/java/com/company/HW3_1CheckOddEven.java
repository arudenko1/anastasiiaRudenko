package com.company;

public class HW3_1CheckOddEven {
    public static void main(String[] args) {

        /*1.Написать программу с названием “CheckOddEven”, которая печатает “Odd Number”
        если переменная “number” типа int нечетная. Или “Even Number” если переменная
        четная. Программа всегда должна перед выходом печатать “BYE” */

        int number = 5;

        if (number % 2 > 0) {
            System.out.println("Odd Number");
        } else {
            System.out.println("Even number");
        }
        System.out.println("BYE");
    }
}
