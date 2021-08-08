package com.company.collections;

import java.util.ArrayList;
import java.util.Random;

public class SortCollection {
    public static void main(String[] args) {

    /* Написать программу, которая вместо золушки сортирует числа из начальной коллекции на 3 кучки:
    в первую - числа которые нацело делятся на 2,
    во вторую - числа которые делятся на 3,
    в третью - все остальные, которые не подходят под первые 2.
    Если число делится и на 2 и на 3, то оно попадает в обе кучки.
    Начальную коллекцию из 100 элеметов заполнить случайными числами (граничное значение 500) */

        ArrayList<Integer> generalList = new ArrayList<Integer>();
        ArrayList<Integer> listWithNumbersDivided2 = new ArrayList<Integer>();
        ArrayList<Integer> listWithNumbersDivided3 = new ArrayList<Integer>();
        ArrayList<Integer> listWithNumbersNotDivided2And3 = new ArrayList<Integer>();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(500);
            generalList.add(x);
        }
        System.out.println(generalList);

        for (int x : generalList) {
            if (x % 2 == 0) {
                listWithNumbersDivided2.add(x);
            }
            if (x % 3 == 0) {
                listWithNumbersDivided3.add(x);
            }
            if (x % 2 != 0 && x % 3 != 0) {
                listWithNumbersNotDivided2And3.add(x);
            }
        }
        System.out.println("List with numbers divided 2:" + listWithNumbersDivided2);
        System.out.println("List with numbers divided 3:" + listWithNumbersDivided3);
        System.out.println("List with numbers not divided 2 and 3:" + listWithNumbersNotDivided2And3);
    }
}
