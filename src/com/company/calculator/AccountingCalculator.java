package com.company.calculator;

public class AccountingCalculator extends BaseCalculator {

    public static void main(String[] args) {
        AccountingCalculator accountingCalculator = new AccountingCalculator();

        System.out.println("Operation for 2 variables:");
        double number1 = accountingCalculator.getNumber();
        double number2 = accountingCalculator.getNumber();
        char operation = accountingCalculator.getOperation();
        double result1 = accountingCalculator.calculation(number1, number2, operation);
        System.out.println(result1);

        System.out.println("Operation for a single variable:");
        double number3 = accountingCalculator.getNumber();
        operation = accountingCalculator.getOperation();
        double result2 = accountingCalculator.calculation(number3, operation);
        System.out.println(result2);
    }

    @Override
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
            case '^':
                result = Math.pow(number1, number2);
                break;
            default:
                System.out.println("Invalid input. Try again.");
                result = calculation(number1, number2, getOperation());
        }
        return result;
    }

    public double calculation(double number1, char operation) {
        double result;
        switch (operation) {
            case '%':
                result = number1 / 100;
                break;
            default:
                System.out.println("Invalid input. Try again.");
                result = calculation(number1, getOperation());
        }
        return result;
    }
}
