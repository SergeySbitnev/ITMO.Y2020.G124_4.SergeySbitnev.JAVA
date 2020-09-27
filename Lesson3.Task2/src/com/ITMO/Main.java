package com.ITMO;

public class Main {

    public static void main(String[] args) {

        double Xn = 0;
        double Xk = 10;
        double EPSy = 0.001;
        double Xi = 0;
        double dx = 0;

        if (FunctionRoot(Xn) == 0) System.out.println("Корень уравнения: " + Xn);
        if (FunctionRoot(Xk) == 0) System.out.println("Корень уравнения: " + Xk);
        while(Xk-Xn > EPSy){
            dx = (Xk - Xn)/2;
            Xi = Xn + dx;
            if(FunctionRoot(Xn) != FunctionRoot(Xi)) Xk = Xi; else Xn = Xi;

        }

        System.out.println("Найден корень уравнения: " + Xi + " с точностью по y " + EPSy);


    }

    static double FunctionRoot (double x){
        return Math.cos(Math.pow(x, 5))+Math.pow(x, 4)-345.3*x-23;
    }
}
