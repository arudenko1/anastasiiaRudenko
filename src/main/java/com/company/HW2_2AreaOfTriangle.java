package com.company;

public class HW2_2AreaOfTriangle {
    public static void main(String[] args) {


 /*2. Написать программу, которая выводит площади прямоугольного треугольника.
 Значения 2 его катетов передавать при запуске программы.*/
        {
            int k1 = Integer.parseInt(args[0]);
            int k2 = Integer.parseInt(args[1]);
            int S = k1 * k2 * 1 / 2;
            System.out.println("The area of a right-angled triangle is: " + S);
        }
    }
}
