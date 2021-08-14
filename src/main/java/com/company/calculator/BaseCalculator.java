package com.company.calculator;

import java.util.Scanner;

public class BaseCalculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        BaseCalculator baseCalculator = new BaseCalculator();

        double number1 = baseCalculator.getNumber();
        double number2 = baseCalculator.getNumber();
        char operation = baseCalculator.getOperation();
        double result = baseCalculator.calculation(number1, number2, operation);
        System.out.println(result);
    }

    public double getNumber() {
        System.out.println("Enter number:");
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Invalid input. Try again.");
            scanner.next();
            number = getNumber();
        }
        return number;
    }

    public char getOperation() {
        System.out.println("Enter operation:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Invalid operation. Try again.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public double calculation(double number1, double number2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                System.out.println("Invalid input. Try again.");
                result = calculation(number1, number2, getOperation());
        }
        return result;
    }
}
