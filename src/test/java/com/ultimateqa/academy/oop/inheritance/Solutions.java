package com.ultimateqa.academy.oop.inheritance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solutions {
    @Test
    public void testInterfaceImplementation() {
        Shape square = new Square(4);
        assertEquals(16, square.getArea());
    }

    interface Shape {
        int getArea();
    }

    class Square implements Shape {
        private final int side;

        public Square(int side) {
            this.side = side;
        }

        @Override
        public int getArea() {
            return side * side;
        }
    }

    @Test
    public void testAbstractClass() {
        Animal cat = new Cat("Mittens");
        assertEquals("Mittens", cat.getName());
    }

    abstract class Animal {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }
}
