package com.ultimateqa.academy.automation;

import org.junit.Assert;
import org.junit.Test;

public class UnitTests {
    @Test
    public void unitTest() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(4, calculator.add(2,2));
    }
}
