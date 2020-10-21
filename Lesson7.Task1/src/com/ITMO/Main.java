package com.ITMO;

import java.util.ArrayList;

interface Shape {
    double getVolume();
}

class SolidOfRevolution implements Shape{
    private double volume;
    private double radius;

    public SolidOfRevolution(double volume, double radius) {
        this.volume = volume;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getVolume() {
        return volume;
    }
}

class Ball extends SolidOfRevolution{
    public Ball(double radius) {
        super(Math.PI * Math.pow(radius, 3) * 4/3, radius);
    }
}

class Cylinder extends SolidOfRevolution {
    private double height;

    public Cylinder(double radius, double height) {
        super(Math.PI * Math.pow(radius, 2) * height, radius);
        this.height = height;
    }
}

class Pyramid implements Shape{
    private double height;
    private double s;

    public Pyramid(double height, double s) {
        this.height = height;
        this.s = s;
    }

    @Override
    public double getVolume() {
        return height * s * 1/3;
    }
}

class Box implements Shape {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private double available;

    public Box(double available) {
        this.available = available;
    }

    public boolean add(Shape shape) {
        if (available >= shape.getVolume()) {
            shapes.add(shape);
            available -= shape.getVolume();
            return true;
        } else {
            return false;
        }
    }
    @Override
    public double getVolume() {
        return available;
    }
}

public class Main {

    public static void main(String[] args) {
        Ball ball = new Ball(4.5);
        Cylinder cylinder = new Cylinder(2,2 );
        Pyramid pyramid = new Pyramid(50, 50);

        Box box = new Box(1000);

        System.out.println(box.add(ball));
        System.out.println("Объем шара: " + ball.getVolume());
        System.out.println(box.add(cylinder));
        System.out.println("Объем цилиндра: " + cylinder.getVolume());
        System.out.println(box.add(pyramid));
        System.out.println("Объем пирамиды: " + pyramid.getVolume());
    }
}
