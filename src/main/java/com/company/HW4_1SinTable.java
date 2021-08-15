package com.company;

public class HW4_1SinTable {
    public static void main(String[] args) {
        // 1 Написать программу, которая печатает таблицу значений sin(x), где x это каждые 10 градусов от 0 до 360

        for (double x = 0.0; x <= 360.0; x += 10.0) {
            double radians = Math.toRadians(x);
            System.out.format("Sin %.0f° = %.4f%n", x, Math.sin(radians));
        }
    }
}
