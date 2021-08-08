package com.company.collections;

import java.util.HashMap;

public class ShoppingList {
    public static void main(String[] args) {
        /* Создать программу - список покупок.
        В список вносится название товара и количество.
        Список заполнить случайными товарами.
        В конце вывести общее количество товаров, добавленных в список. */

        HashMap<String, Integer> shoppingList = new HashMap<String, Integer>();
        shoppingList.put("Apple", 5);
        shoppingList.put("Tomato", 6);
        shoppingList.put("Onion", 1);
        shoppingList.put("Cucumber", 5);
        shoppingList.put("Carrot", 3);
        shoppingList.put("Chocolate", 2);
        shoppingList.put("Strawberries", 3);

        int sum = 0;
        for (int value : shoppingList.values()) {
            sum += value;
        }
        System.out.println("Total number of goods: " + sum);
    }
}
