package com.company.calculator;

public class EngineeringCalculator extends BaseCalculator {

    public static void main(String[] args) {
        EngineeringCalculator engineeringCalculator = new EngineeringCalculator();

        double number1 = engineeringCalculator.getNumber();
        double number2 = engineeringCalculator.getNumber();
        char operation = engineeringCalculator.getOperation();
        double result = engineeringCalculator.calculation(number1, number2, operation);
        System.out.println(result);
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
}
