package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите колличество элементов массива: ");
        int AmountElements = scanner.nextInt();

        double ArrayElements[] = new double[AmountElements];

        for(int i = 0; i < AmountElements; i++){
            ArrayElements[i] = Math.random();
        }

        double max, min, average;
        max =min = average= ArrayElements[0];

        for(int i = 1; i < AmountElements; i++){
            if (ArrayElements[i] > max) max = ArrayElements[i];
            if (ArrayElements[i] < min) min = ArrayElements[i];
            average += ArrayElements[i];
        }

        for(int i = 0; i < AmountElements; i++){
            System.out.println(ArrayElements[i]);
        }
        System.out.println("Максимальный элемент массива: " + max);
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Среднее значение элементов массива: " + average/AmountElements);
    }
}
