package com.ultimateqa.academy.expressions.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solutions {
    @Test
    public void testNumberCheck() {
        int number = -5;
        String result;

        if (number > 0) {
            result = "The number is positive.";
        } else if (number < 0) {
            result = "The number is negative.";
        } else {
            result = "The number is zero.";
        }

        assertEquals("The number is negative.", result);
    }

    @Test
    public void testSumOfEvenNumbers() {
        int sum = 0;

        for (int i = 2; i <= 20; i += 2) {
            sum += i;
        }

        assertEquals(110, sum);
    }
    @Test
    public void testGetDayOfWeek() {
        int dayNumber = 3;
        String day;

        switch (dayNumber) {
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            case 7:
                day = "Sunday";
                break;
            default:
                day = "Invalid day";
        }

        assertEquals("Wednesday", day);
    }
    @Test
    public void testFactorial() {
        int number = 5;
        int factorial = 1;
        int i = 1;

        while (i <= number) {
            factorial *= i;
            i++;
        }

        assertEquals(120, factorial);
    }
    @Test
    public void testSumOfDigits() {
        int number = 12345;
        int sum = 0;

        do {
            sum += number % 10;
            number /= 10;
        } while (number > 0);

        assertEquals(15, sum);
    }
    @Test
    public void testDivisionByZero() {
        int a = 10;
        int b = 0;
        int result;

        try {
            result = a / b;
            fail("Expected an ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    public void testInstanceOf() {
        String text = "Hello, world!";
        assertTrue(text instanceof String);
    }

    @Test
    public void testAbsoluteValue() {
        int number = -42;
        int absoluteValue = (number < 0) ? -number : number;
        assertEquals(42, absoluteValue);
    }
    @Test
    public void testFirstEvenNumber() {
        int[] numbers = {3, 7, 5, 8, 1, 4};
        int firstEven = -1;

        for (int number : numbers) {
            if (number % 2 == 0) {
                firstEven = number;
                break;
            }
        }

        assertEquals(8, firstEven);
    }
    @Test
    public void testSumOfOddNumbers() {
        int[] numbers = {1, 6, 8, 9, 3, 7};
        int sum = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                continue;
            }
            sum += number;
        }

        assertEquals(20, sum);
    }

    @Test
    public void testCustomException() {
        try {
            throw new CustomException("This is a custom exception.");
        } catch (CustomException e) {
            assertEquals("This is a custom exception.", e.getMessage());
        }
    }

    public static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    @Test
    public void testEnumSwitch() {
        Day day = Day.WEDNESDAY;
        String displayName = "";

        switch (day) {
            case MONDAY:
                displayName = "Monday";
                break;
            case TUESDAY:
                displayName = "Tuesday";
                break;
            case WEDNESDAY:
                displayName = "Wednesday";
                break;
            case THURSDAY:
                displayName = "Thursday";
                break;
            case FRIDAY:
                displayName = "Friday";
                break;
            case SATURDAY:
                displayName = "Saturday";
                break;
            case SUNDAY:
                displayName = "Sunday";
                break;
        }

        assertEquals("Wednesday", displayName);
    }

    public enum Day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    @Test
    public void testFinalVariable() {
        final int constantValue = 42;
        assertEquals(42, constantValue);
    }
    @Test
    public void testAssertKeyword() {
        int a = 5;
        int b = 10;
        int sum = a + b;
        assert sum == 15 : "Sum should be equal to 15";
    }
    @Test
    public void testStaticMethod() {
        int result = Calculator.add(5, 10);
        assertEquals(15, result);
    }

    public static class Calculator {
        public static int add(int a, int b) {
            return a + b;
        }
    }
}
