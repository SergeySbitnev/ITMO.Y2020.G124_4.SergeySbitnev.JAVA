package com.ITMO;

public class Shape implements Comparable<Shape> {
    private double volume;

    public Shape(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public int compareTo(Shape shapes) {
        if(this.volume == shapes.volume) {
            return 0;
        } else if(this.volume < shapes.volume){
            return -1;
        } else {
            return 1;
        }
    }
}
