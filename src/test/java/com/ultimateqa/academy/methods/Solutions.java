package com.ultimateqa.academy.methods;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solutions {
    // Solution to even exercise

    public boolean isEven(int number){
        if(number % 2 == 0){
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void testIsEven(){
        assertTrue("2 is even", isEven(2));
        assertFalse("3 is odd", isEven(3));
        assertTrue("0 is even", isEven(0));
    }
}
