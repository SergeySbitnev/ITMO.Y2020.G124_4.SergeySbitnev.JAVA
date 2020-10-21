package com.ITMO;

import java.util.Scanner;

class BaseConverter {
    private double t;

    public BaseConverter(double t){
        this.t = t;
    }
    public double getConverted(){
        return t;
    }
}

class CelsiusConvert extends BaseConverter{
    public CelsiusConvert(double t) {
        super(t);
    }
    @Override
    public double getConverted() {
        return super.getConverted();
    }
}

class KelvinConvert extends BaseConverter{
    public KelvinConvert(double t) {
        super(t);
    }
    @Override
    public double getConverted() {
        return super.getConverted() + 273.15;
    }
}

class FahrenheitConvert extends BaseConverter{
    public FahrenheitConvert(double t) {
        super(t);
    }
    @Override
    public double getConverted() {
        return 1.8 * super.getConverted() + 32;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите температуру: ");
        double temper = scanner.nextDouble();
        CelsiusConvert cels = new CelsiusConvert(temper);
        KelvinConvert kelv = new KelvinConvert(temper);
        FahrenheitConvert fahr = new FahrenheitConvert(temper);



        System.out.println("Температура цельсию: " + cels.getConverted());
        System.out.println("Температура кельвины: " + kelv.getConverted());
        System.out.println("Температура фаренгейты: " + fahr.getConverted());


    }
}
