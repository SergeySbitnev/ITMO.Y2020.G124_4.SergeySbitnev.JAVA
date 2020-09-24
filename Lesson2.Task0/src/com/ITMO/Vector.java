package com.ITMO;

public class Vector {
    double x;
    double y;
    double z;

    Vector(double corX, double corY, double corZ) {
        x = corX;
        y = corY;
        z = corZ;
    }

    //Длина вектора
    static double VectorLen(Vector V){
        return Math.sqrt(Math.pow(V.x, 2)+Math.pow(V.y, 2)+Math.pow(V.z, 2));
    }

    //Скалярное произведение
    static  double ScalarProduct(Vector a, Vector b){
        return a.x*b.x+a.y*b.y+a.z*b.z;
    }

    //Векторное произведение
    static Vector CrossProduct(Vector a, Vector b){
        Vector c = new Vector(a.y*b.z-a.z*b.y, a.z*b.x-a.x*b.z, a.x*b.y-a.y*b.x);
        return c;
    }

    //Угол между векторами (косинус угла)
    static double AngleBetweenVector(Vector a, Vector b){
        return ScalarProduct(a, b)/VectorLen(a) * VectorLen(b);
    }

    //Сумма векторов
    static Vector SumVectors (Vector a, Vector b){
        Vector c = new Vector(a.x+b.x, a.y+b.y, a.z+b.z);
        return c;
    }
    //Разность векторов
    static Vector SubtraVectors (Vector a, Vector b){
        Vector c = new Vector(a.x-b.x, a.y-b.y, a.z-b.z);
        return c;
    }

    //Массив случайных векторов
    static Vector[] RandomVector(int quantity){
        Vector[] vectors = new Vector[quantity];

        for (int i = 0; i < vectors.length; i++){
            vectors[i] = new Vector(Math.random(), Math.random(),Math.random());
        }

        return vectors;
    }




}
