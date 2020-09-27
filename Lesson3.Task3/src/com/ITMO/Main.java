package com.ITMO;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int quantity = scanner.nextInt();

        int[] ArrayElements = ArrayWorks.CreateArray(quantity);
        System.out.println("Начальный массив: ");
        ArrayWorks.PrintArray(ArrayElements);

        int[] BubbleSort = new int[quantity];
        int[] SelectionSort = new int[quantity];
        int[] SortByInsert = new int[quantity];
        int[] QuickSortTrue = new int[quantity];
        int[] QuickSortFalse = new int[quantity];
        System.arraycopy(ArrayElements, 0, BubbleSort, 0, ArrayElements.length);
        System.arraycopy(ArrayElements, 0, SelectionSort, 0, ArrayElements.length);
        System.arraycopy(ArrayElements, 0, SortByInsert, 0, ArrayElements.length);
        System.arraycopy(ArrayElements, 0, QuickSortTrue, 0, ArrayElements.length);
        System.arraycopy(ArrayElements, 0, QuickSortFalse, 0, ArrayElements.length);

        long time = System.nanoTime();
        BubbleSort = ArrayWorks.BubbleSort(BubbleSort);
        time = System.nanoTime() - time;
        System.out.println("Сортировка пузырьком: ");
        ArrayWorks.PrintArray(BubbleSort);
        System.out.println("Время: " + time + "нс");

        time = System.nanoTime();
        SelectionSort = ArrayWorks.BubbleSort(SelectionSort);
        time = System.nanoTime() - time;
        System.out.println("Сортировка выбором: ");
        ArrayWorks.PrintArray(SelectionSort);
        System.out.println("Время: " + time + "нс");

        time = System.nanoTime();
        SortByInsert = ArrayWorks.BubbleSort(SortByInsert);
        time = System.nanoTime() - time;
        System.out.println("Сортировка вставками: ");
        ArrayWorks.PrintArray(SortByInsert);
        System.out.println("Время: " + time + "нс");

        int start = 0;
        int finish = QuickSortFalse.length - 1;
        time = System.nanoTime();
        ArrayWorks.QuickSort(QuickSortTrue, start, finish, true);
        time = System.nanoTime() - time;
        System.out.println("Быстрая сортировка (опорный средний): ");
        ArrayWorks.PrintArray(QuickSortTrue);
        System.out.println("Время: " + time + "нс");

        start = 0;
        finish = QuickSortTrue.length - 1;
        time = System.nanoTime();
        ArrayWorks.QuickSort(QuickSortFalse, start, finish, false);
        time = System.nanoTime() - time;
        System.out.println("Быстрая сортировка (опорный первый): ");
        ArrayWorks.PrintArray(QuickSortFalse);
        System.out.println("Время: " + time + "нс");
    }


}
