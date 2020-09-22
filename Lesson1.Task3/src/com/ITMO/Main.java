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
        double BubbleSort[] = new double[AmountElements];
        double SelectionSort[] = new double[AmountElements];
        double SortByInsert[] = new double[AmountElements];

        //Заполняю массив случайными элементами
        for (int i = 0; i < ArrayElements.length; i++) ArrayElements[i] = Math.random();
        //Копирую полученный массив для дальнейшей сортировки
        System.arraycopy(ArrayElements, 0, BubbleSort, 0, ArrayElements.length);
        System.arraycopy(ArrayElements, 0, SelectionSort, 0, ArrayElements.length);
        System.arraycopy(ArrayElements, 0, SortByInsert, 0, ArrayElements.length);

        double RepVar; //Replacement variable

        //Сортировка пузырьком
        long timeBubbleSort = System.nanoTime();
        for (int i = BubbleSort.length-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (BubbleSort[j] > BubbleSort[j+1]){
                    RepVar = BubbleSort[j];
                    BubbleSort[j] = BubbleSort[j+1];
                    BubbleSort[j+1] = RepVar;
                }
            }
        }
        timeBubbleSort = System.nanoTime() - timeBubbleSort;

        //Сортировка выбором
        long timeSelectionSort = System.nanoTime();
         for (int i = 0; i < SelectionSort.length; i++){
             int ch = i;
             for (int j = i +1; j < SelectionSort.length; j++){
                 if (SelectionSort[j] < SelectionSort[ch]) {
                     ch = j;
                 }
             }
             RepVar = SelectionSort[i];
             SelectionSort[i] = SelectionSort[ch];
             SelectionSort[ch] = RepVar;
         }
         timeSelectionSort = System.nanoTime() - timeSelectionSort;

         //Сортировка вставками
        long timeSortByInsert = System.nanoTime();
        for (int i = 1; i < SortByInsert.length; i++){
            RepVar = SortByInsert[i];
            int j = i - 1;
            while (j >= 0 && SortByInsert[j] > RepVar){
                SortByInsert[j+1] = SortByInsert[j];
                j -= 1;
            }
            SortByInsert[j+1] = RepVar;
        }
        timeSortByInsert = System.nanoTime() - timeSortByInsert;

        /*
        System.out.println("Исходный массив: ");
        for (int i = 0; i < ArrayElements.length; i++) System.out.println(ArrayElements[i]);
        System.out.println("Сортировка пузырьком: ");
        for (int i = 0; i < BubbleSort.length; i++) System.out.println(BubbleSort[i]);
        System.out.println("Сортировка выбором: ");
        for (int i = 0; i < SelectionSort.length; i++) System.out.println(SelectionSort[i]);
        System.out.println("Сортировка вставками: ");
        for (int i = 0; i < SortByInsert.length; i++) System.out.println(SortByInsert[i]);
        */

        System.out.println("Время затраченное на сортировку пузырьком (наносекунд): " + timeBubbleSort);
        System.out.println("Время затраченное на сортировку выбором (наносекунд): " + timeSelectionSort);
        System.out.println("Время затраченное на сортировку вставками (наносекунд): " + timeSortByInsert);


    }
}
