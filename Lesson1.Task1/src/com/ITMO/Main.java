package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите колличество элементов массива: ");
        int AmountElements = scanner.nextInt();

        double ArrayElements[] = new double[AmountElements];

        //Заполняю массив случайными значениями
        for(int i = 0; i < ArrayElements.length; i++){
            ArrayElements[i] = Math.random();
        }

        double max, min, average;
        max = min = average= ArrayElements[0];

        //Нахожу минимальное, максимальное и сумму
        for(int i = 0; i < ArrayElements.length; i++){
            if (ArrayElements[i] > max) max = ArrayElements[i];
            if (ArrayElements[i] < min) min = ArrayElements[i];
            average += ArrayElements[i];
        }

        for(int i = 0; i < ArrayElements.length; i++){
            System.out.println(ArrayElements[i]);
        }
        System.out.println("Максимальный элемент массива: " + max);
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Среднее значение элементов массива: " + average/AmountElements);
    }
}
