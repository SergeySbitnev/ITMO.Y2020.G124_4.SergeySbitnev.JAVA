package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Данная программа находит уникальное число в массиве случайных числе от 0 до 9.");
        System.out.print("Введите размер массива: ");
        int AmountArray = scanner.nextInt();
        int ArrayNum[] = new int [AmountArray];

        for (int i = 0; i < AmountArray; i++){
            ArrayNum[i] = ((int)(Math.random() * 10));
            System.out.print(ArrayNum[i] + " ");
        }

        int counter = 0; //счетчик
        System.out.println();
        //берем элемент массива по порядку через цикл
        for (int i = 0; i < ArrayNum.length; i++){
            //System.out.print(ArrayNum[i] + " ");
            //сравниваем со всеми элементами массива
            for (int j = 0; j < ArrayNum.length; j++){
                if (ArrayNum[i] == ArrayNum[j]) counter++;
            }
            //System.out.println(counter);
            //если счетчик равен 1 значит было совпадение только с собой и можно завершать поиск
            if (counter == 1) {
                System.out.println(ArrayNum[i] + " первое уникальное число в данном массиве.");
                break;
            }
            counter = 0;
        }

        if (counter == 0) {
            System.out.println("В данном массиве нет уникальных чисел.");
        }


    }
}
