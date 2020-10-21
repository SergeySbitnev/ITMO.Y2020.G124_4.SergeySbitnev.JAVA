package com.ITMO;

public class Pyramid extends Shape{
    private double height;
    private double s;

    public Pyramid(double height, double s) {
        super(height * s * 1/3);
        this.height = height;
        this.s = s;
    }
}
