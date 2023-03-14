package com.ultimateqa.academy.java.basics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentGradeCalculatorTest {
    @Test
    public void testCalculateFinalGradeAndLetterGrade() {
        // TODO put your code in here
        /*
            Hint, you will need to use an if/else block that looks something like this
            You haven't learned if blocks yet, I know. Welcome to the real world
            where we will be challenged to acquire new knowledge on the job.
        * */
        char letterGrade = 'X';
        int roundedFinalGrade = 0;
        if (roundedFinalGrade >= 90) {
            letterGrade = 'A';
        }

        // *** do not change these assertions, they must pass when you complete your code
        assertEquals(88, roundedFinalGrade);
        assertEquals('B', letterGrade);
    }
}
