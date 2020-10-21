package com.ITMO;

public class ArrayWorks {
    //Создание массива черых случайных чисел от 0 до 99
    static int[] CreateArray(int quantity){
        int[] array = new int[quantity];
        for (int i = 0; i < array.length; i++){
            array[i] = ((int)(Math.random()*100));
        }
        return array;
    }

    //Печать массива
    static void PrintArray(int[] array){
        System.out.print("Вывод запрошенного массива:");
        for(int i = 0; i < array.length; i++){
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    //Сортировка пузырьком
    static int[] BubbleSort(int[] array){
        int RepVar;
        for (int i = array.length-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (array[j] > array[j+1]){
                    RepVar = array[j];
                    array[j] = array[j+1];
                    array[j+1] = RepVar;
                }
            }
        }
        return array;
    }
    //Сортировка выбором
    static int[] SelectionSort(int[] array){
        int RepVar;
        int ch;
        for (int i = 0; i<array.length; i++){
            ch = i;
            for (int j = i+1; j < array.length; j++){
                if (array[ch] > array[j]){
                    ch = j;
                }
                RepVar = array[i];
                array[i] = array[ch];
                array[ch] = RepVar;
            }

        }
        return array;
    }

    //Сортировка вставками
    static  int[] SortByInsert(int[] array){
        int RepVar;
        for (int i = 1; i < array.length; i++){
            RepVar = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > RepVar){
                array[j+1] = array[j];
                j -= 1;
            }
            array[j+1] = RepVar;
        }
        return array;
    }


    //Быстрая сортировка
    public static void QuickSort(int[] array, int start, int finish, boolean choices) {
        //Проверка длины массива на 0
        if (array.length == 0)
            return;

        if (start >= finish)
            return;

        //Выбираем опорный элемент
        int middle = 0;
        //middle = start + (finish - start) / 2;
        //middle = start;

        if (choices){
            middle = start + (finish - start) / 2;
        }
             else{
            middle = start;
        }
        int pivot = array[middle];

        //Делим на подмассивы, больше и меньше опорного
        int i = start;
        int j = finish;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {//меняем местами
                int RepVar = array[i];
                array[i] = array[j];
                array[j] = RepVar;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (start < j)
            QuickSort(array, start, j, choices);

        if (finish > i)
            QuickSort(array, i, finish, choices);
    }
}

