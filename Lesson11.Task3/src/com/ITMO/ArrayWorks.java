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


    //Сортировка выбором
    static int[] SelectionSort(int[] array){
        int RepVal;
        int ch;
        for (int i = 0; i < array.length; i++){
            ch = i;
            for (int j = i+1; j < array.length; j++){
                if (array[ch] > array[j]){
                    ch = j;
                }
            }
            RepVal = array[i];
            array[i] = array[ch];
            array[ch] = RepVal;
        }
        System.out.println("Сортировка выбором завершена.");
        return array;
    }
}
