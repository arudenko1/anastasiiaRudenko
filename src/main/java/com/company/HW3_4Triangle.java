package com.company;

public class HW3_4Triangle {
    public static void main(String[] args) {

        // 4. Написать программу, которая определяет, является ли треугольник со сторонами a, b, c равнобедренным.

        int a = 5;
        int b = 4;
        int c = 5;

        if (a == b || a == c || c == b) {
            System.out.println("The triangle is isosceles.");
        } else {
            System.out.println("The triangle is not isosceles.");
        }
    }
}


