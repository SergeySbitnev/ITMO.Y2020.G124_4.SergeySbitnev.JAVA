package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Данное приложение выполняет сортировку массива разными методами.");
        System.out.print("Введите колличество элементов массива: ");
        int AmountElements = scanner.nextInt();

        double ArrayElements[] = new double[AmountElements];
        for (int i = 0; i < AmountElements; i++) ArrayElements[i] = Math.random();

        





        for (int i = 0; i < AmountElements; i++) System.out.println(ArrayElements[i]);

    }
}
