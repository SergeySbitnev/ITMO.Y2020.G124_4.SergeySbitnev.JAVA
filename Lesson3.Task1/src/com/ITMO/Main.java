package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int quantity = scanner.nextInt();
        int[] MyArray;

        MyArray = ArrayWorks.CreateArray(quantity);
        ArrayWorks.PrintArray(MyArray);

        MyArray = ArrayWorks.SelectionSort(MyArray);
        ArrayWorks.PrintArray(MyArray);

        System.out.print("Какое число будем искать: ");
        int num = scanner.nextInt();

        //Поиск числа последовательным перебором
        if (Search.StepByStep(MyArray, num)) System.out.println("Есть совпаденние!"); else System.out.println("Нет совпадении!");
        //Бинарный поиск
        if (Search.Binary(MyArray, num)) System.out.println("Есть совпаденние!"); else System.out.println("Нет совпадении!");
    }
}
