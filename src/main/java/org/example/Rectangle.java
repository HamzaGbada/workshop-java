package org.example;

public class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(String color, double l, double w) {
        super(color);
        this.length = l;
        this.width = w;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return this.width * this.length;
    }
}
