package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Данная программа удаляет указанное число из массива случайных числе от 0 до 9.");
        System.out.print("Введите размер массива: ");
        int AmountArray = scanner.nextInt();
        System.out.print("Введите число которое необходимо удалить: ");
        int Num = scanner.nextInt();




        int ArrayNum[] = new int[AmountArray];
        for (int i = 0; i < ArrayNum.length; i++) {
            ArrayNum[i] = ((int)(Math.random() * 10));
            System.out.print(ArrayNum[i] + " ");
        }

        /*
        //тестовый массив
        int ArrayNum[] = {5,5,2,5,1,2,6,8,9,3,2,8,5,7,8,9,3,4,5,5};
        int Num = 5;
        */

        int len = 0; // данная переменная покажет сколько раз произошло удаление числа
        //запускаем цикл на проверку соответствия элементов массива указанному числу, а переменная len будет сокращать длину массива по мере удаления и во избежания зацикливания
        for (int i = 0; i < ArrayNum.length-len; i++){
            if (ArrayNum[i] == Num){
                //произошло совпадение, производим сдвиг элементов массива в лево
                for (int j = i; j < ArrayNum.length-1; j++){
                    ArrayNum[j] = ArrayNum[j+1];
                }
                //после сдвига надо проверить, вдруг следующий элемент тоже соответствует нашему числу, уменьшаем шаг на 1
                i--;
                //так как было совпадение длина нашего масива уменьшится
                len++;
            }
        }

        System.out.println();
        for (int i = 0; i < ArrayNum.length - len; i++) {
            System.out.print(ArrayNum[i] + " ");
        }

        System.out.println("\n\nКоличество вхождении числа " + Num + ": " + len);


    }
}
