package com.company;

import java.util.Scanner;

public class HW2_1Temperature {
    public static void main(String[] args) {

        {
           /* 1. Написать программу, которая переводит градусы Цельсия в Фаренгейты и Кельвины
            Формулы
            Celsius = 5/9 (F - 32)
            Kelvin = C + 273.16
            Вывод должен быть примерно такой: X C: Y F; Z K,
             где X - исходное значение в градусах Цельсия,
             Y и Z - вычисленные значения в Фаренгейтах и Кельвинах соответственно. */

            System.out.println("Please enter the temperature in C:");
            Scanner console = new Scanner(System.in);
            int Celsius = console.nextInt();
            double Fahrenheit = (Celsius * 9 / 5) + 32;
            double Kelvin = Celsius + 273.16;
            System.out.println(Celsius + " C equals:");
            System.out.println(Fahrenheit + " F");
            System.out.println(Kelvin + " K");
        }
    }
}
