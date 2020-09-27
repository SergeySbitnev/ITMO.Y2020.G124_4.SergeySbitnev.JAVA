package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Vector a = new Vector(1, 3, 4);
        Vector b = new Vector(5, 2, 8);
        System.out.println("Вектор a: (" + a.x + ", " + a.y + ", " + a.z + ")");
        System.out.println("Вектор b: (" + b.x + ", " + b.y + ", " + b.z + ")");

        System.out.println("Длина вектора a: " + Vector.VectorLen(a));
        System.out.println("Длина вектора b: " + Vector.VectorLen(b));

        System.out.println("Скалярное произведение векторов a и b: " + Vector.ScalarProduct(a, b));

        Vector c = Vector.CrossProduct(a, b);
        System.out.println("Векторное произведение a и b: (" + c.x + ", " + c.y + ", " + c.z + ")");

        System.out.println("Угол между вектора a и b: " + Vector.AngleBetweenVector(a, b));

        c = Vector.SumVectors(a, b);
        System.out.println("Сумма векторов a и b: (" + c.x + ", " + c.y + ", " + c.z + ")");
        c = Vector.SubtraVectors(a, b);
        System.out.println("Разность векторов a и b: (" + c.x + ", " + c.y + ", " + c.z + ")");

        int quantity = 10;
        Vector[] ManyVectors = Vector.RandomVector(quantity);

        System.out.println(quantity + " случайных векторов.");
        for(int i = 0; i < ManyVectors.length; i++){
            System.out.println("Вектор с индексом " + i + ": (" + ManyVectors[i].x + ", " + ManyVectors[i].y + ", " + ManyVectors[i].z + ")");
        }




    }
}
