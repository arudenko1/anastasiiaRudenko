package com.company.collections;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class RemoveDuplicatesFromCollection {
    public static void main(String[] args) {

       /* Написать программу, которая удаляет из коллекции целых чисел все дубликаты, если они есть.
        Коллекцию из 100 элементов заполнить случайными числами (граница - 20).
        Вывести обе коллекции на экран и количество удалённых дубликатов
        (при желании - решить несколькими способами и сравнить какой из них быстрее)*/

        // 1. Remove duplicates using Array List

        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(20);
            randomNumbers.add(x);
        }
        System.out.println(randomNumbers);

        ArrayList<Integer> list1WithoutDuplicates = new ArrayList<Integer>();
        long startOfMethod1 = System.currentTimeMillis();
        for (int x : randomNumbers) {
            if (!list1WithoutDuplicates.contains(x))
                list1WithoutDuplicates.add(x);
        }

        System.out.println(System.currentTimeMillis() - startOfMethod1);
        System.out.println(list1WithoutDuplicates);
        System.out.println("Count of removed duplicates: " + (randomNumbers.size() - list1WithoutDuplicates.size()));

        // 2. Remove duplicates using LinkedHashSet

        long startOfMethod2 = System.currentTimeMillis();
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(randomNumbers);
        ArrayList<Integer> list2WithoutDuplicates = new ArrayList<>(hashSet);
        System.out.println(System.currentTimeMillis() - startOfMethod2);
        System.out.println(list2WithoutDuplicates);
        System.out.println("Count of removed duplicates: " + (randomNumbers.size() - list2WithoutDuplicates.size()));
    }
}
