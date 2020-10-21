package com.ITMO;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        TreeSet<Shape> shapes = new TreeSet<Shape>();

        Shape firstShape = new Pyramid(50, 50); //833.3 - 3
        Shape secondShape = new Ball(4.5); //381.7 - 2
        Shape thirdShape = new Box(1000); //1000 - 4
        Shape fourthShape = new Cylinder(2, 2); //25.1 - 1

        shapes.add(firstShape);
        shapes.add(secondShape);
        shapes.add(thirdShape);
        shapes.add(fourthShape);

        for(Shape h: shapes){
            System.out.println("Тип фигуры: " + h.getClass() + " объем: " + h.getVolume());
        }
    }
}
