package com.ultimateqa.academy.java.basics;

import org.junit.Test;

public class JavaBasics {
    @Test
    public void primitiveDataTypes() {
        // int is for storing integers
        int currentAge = 33;
        // The boolean data type has only two possible values: true and false.
        boolean isVisible = true;
        // The char data type is a single 16-bit Unicode character
        char singleCharacter = 'a';
        // Double precision (has width of 64), double has a larger range than float
        // Great for decimal values and default
        // 0.0d
        double moneyInBank = 12.528758975d;
        // others
        // The float data type is a single-precision (has a width of 32)
        // This data type should never be used for precise values, such as currency
        float moneyInBankFloat = 12.52f;
        short goodForSavingMemory;
        // It has a minimum value of -128 and a maximum value of 127
        byte hasVeryTinyRange = 127;
    }

    @Test
    public void checkValues() {
        int currentAge = 10 / 3;
        double moneyInBank = 10d / 3d;
        float moneyInBankFloat = 10f / 3f;

        System.out.println("currentAge value = " + currentAge);
        System.out.println("moneyInBank value = " + moneyInBank);
        System.out.println("moneyInBankFloat value = " + moneyInBankFloat);
    }

    @Test
    public void variablesChallenge() {
        double weightInPounds = 100;
        double weightInKg = 0;
        final double CONVERSION_RATIO = .45359237;

        weightInKg = weightInPounds * CONVERSION_RATIO;
        System.out.println("weightInKg = " + weightInKg);
    }

    @Test
    public void strings() {
        String myName = "Nikolay";
        System.out.println("myName = " + myName);
        System.out.println("myName = " + myName +
                " and I love test " +
                "automation");
        String number1 = "100";
        String number2 = "200";
        System.out.println("number1 + number2 = " + number1 + number2);

        String ten = "10";
        int myInt = 50;
        ten = ten + myInt;
        System.out.println("ten = " + ten);
    }

    @Test
    public void operators() {
        // Assignment operator
        int result = 10 - 5;
        // Plus operator
        result = 10 + 0;
        // Minus operator
        result = 50 - 40;
        // Multiplication
        result = 2 * 5;
        // Division
        result = 20 / 2;
        // Remainder or modulus operator
        result = 4 % 3;
    }

    @Test
    public void casting() {
        // declaring 2 variables in a single line
        long myLong = 50000; int myInt = (int) myLong;
        // casting long to Object and then getting the class name
        System.out.println(((Object) myLong).getClass().getName());
        // casting int to Object and then getting the class name
        System.out.println(((Object) myInt).getClass().getName());
        // printing the valuen of myLong and myInt
        System.out.println("myLong = " + myLong);
        System.out.println("myInt = " + myInt);

        byte minByteValue = Byte.MIN_VALUE;
        // how would we divide minByteValue by 2?
        byte halfByteValue = (byte)(minByteValue / 2);
    }

    @Test
    public void castingExercise() {
        // declaring 2 variables in a single line
        byte byteMax = Byte.MAX_VALUE, byteMin = Byte.MIN_VALUE;
        // print out the type of each variable
        System.out.println(((Object) byteMax).getClass().getName());
        System.out.println(((Object) byteMin).getClass().getName());

        // print out the value of each variable
        System.out.println("byteMax = " + byteMax);
        System.out.println("byteMin = " + byteMin);
        //2. Divide a short variable by 2 without an error
        short shortMax = Short.MAX_VALUE;
        short answer = (short)(shortMax / 2);
        System.out.println("answer = " + answer);
    }
}
