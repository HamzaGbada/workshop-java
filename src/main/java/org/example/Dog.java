package org.example;

public class Dog implements Animal{
    @Override
    public void sound() {
        System.out.println("Dog braks");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats");
    }
}
