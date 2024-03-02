package org.example;

public class Cat implements Animal{
    @Override
    public void sound() {
        System.out.println("Cat Meows");
    }

    @Override
    public void eat() {
        System.out.println("Cat Eats");
    }
}
