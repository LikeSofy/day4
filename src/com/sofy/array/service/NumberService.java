package com.sofy.array.service;

public class NumberService {
    public boolean isSimple(int num) {
        boolean isSimple = true;
        if (num > 1) {
            int i = 2;
            while (i < num) {
                if (num % i == 0) {
                    isSimple = false;
                    break;
                }
                i++;
            }
        } else {
            isSimple = false;
        }

        return isSimple;
    }

    private final static int FIBONACCI_FIRST_CONST = 5;
    private final static int FIBONACCI_SECOND_CONST = 4;

    public boolean isFibonacci(int number) {
        double firstBuffer = FIBONACCI_FIRST_CONST * number * number - FIBONACCI_SECOND_CONST;
        double secondBuffer = FIBONACCI_FIRST_CONST * number * number + FIBONACCI_SECOND_CONST;
        double firstSqrt = (long) Math.sqrt(firstBuffer);
        double secondSqrt = (long) Math.sqrt(secondBuffer);

        return firstSqrt * firstSqrt == firstBuffer || secondSqrt * secondSqrt == secondBuffer;
    }

    private final static int START_THREE_DIGIT = 99;
    private final static int END_THREE_DIGIT = 1000;
    private final static int THIRD_DIGIT = 100;
    private final static int SECOND_DIGIT = 10;

    public boolean isNoDuplicateNumbers(int num) {
        boolean result = false;
        if (num > START_THREE_DIGIT && num < END_THREE_DIGIT) {
            int num1 = num / THIRD_DIGIT;
            int num2 = (num % THIRD_DIGIT) / SECOND_DIGIT;
            int num3 = num % 10;
            result = num1 != num2 && num1 != num3 && num2 != num3;
        }
        if (num < -START_THREE_DIGIT && num > -END_THREE_DIGIT) {
            num = -num;
            int num1 = num / THIRD_DIGIT;
            int num2 = (num % THIRD_DIGIT) / SECOND_DIGIT;
            int num3 = num % SECOND_DIGIT;
            result = num1 != num2 && num1 != num3 && num2 != num3;
        }

        return result;
    }
}
