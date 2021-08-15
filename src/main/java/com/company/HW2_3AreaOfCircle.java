package com.company;

import java.util.Scanner;

public class HW2_3AreaOfCircle {
    public static void main(String[] args) {

        /*3 Написать программу, которая вычисляет площадь круга.
        Радиус круга задать в программе самим, для вычислений можно использовать библиотеку Math
        */

        System.out.println("Please enter the radius:");
        Scanner console = new Scanner(System.in);
        double radius = console.nextInt();
        double area = Math.PI * radius * radius;
        System.out.println("Area of the circle = " + area);
    }
}
