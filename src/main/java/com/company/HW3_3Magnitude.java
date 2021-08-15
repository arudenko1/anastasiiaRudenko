package com.company;

public class HW3_3Magnitude {
    public static void main(String[] args) {

        /*3.Написать программу которая будет сравнивать величину (magnitude) двух чисел.
        Например, если одно число = 3, а второе число = -9, программа должна выдать, что
        число -9 имеет большую величину. */

        int number1 = 3;
        int number2 = -9;

        int number1Abs = Math.abs(number1);
        int number2Abs = Math.abs(number2);

        if (number1Abs > number2Abs) {
            System.out.println(number1 + " has larger magnitude than " + number2);
        } else System.out.println(number2 + " has larger magnitude than " + number1);
    }
}
