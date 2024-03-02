package org.example;

public class Circle extends Shape{
    private double rayon;

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public Circle(String color, double rayon) {
        super(color);
        this.rayon = rayon;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(this.rayon, 2);
    }
}
