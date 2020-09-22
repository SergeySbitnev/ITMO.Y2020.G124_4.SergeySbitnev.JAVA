package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Данная программа осуществляет поиск простых чисел от 2 до N. ");
        System.out.print("Введите N: ");
        int num = scanner.nextInt();

        int PrimeNum[] = new int [num / 2];
        PrimeNum[0] = 7;
        int score = 1;

        long timework = System.nanoTime();
        for (int i = 7; i <= num; i+=2){
            if (i % 3 != 0 && i % 5 != 0) {
                for (int j = 0; j < score; j++) {
                    if (i % PrimeNum[j] == 0) break;
                    if (PrimeNum[j]*PrimeNum[j] > i) {
                        PrimeNum[score] = i;
                        score++;
                        break;
                    }

                    /*
                    if (j+1 == score) {
                        PrimeNum[score] = i;
                        score++;
                        break;
                    }

                     */
                }
            }

        }
        timework = System.nanoTime() - timework;

        if (num < 7){
            System.out.println("Вы ввели значение меньше 7, результатом будет выведено первые 3 простых числа: 2 3 5");
        }
        else {
            System.out.print("Все простые числа до указанного значения: 2 3 5 ");
            for (int i = 0; i < score; i++) System.out.print(PrimeNum[i] + " ");
            score+=3;
            System.out.println("\nКоличество простых чисел в указанном диапазоне: " + score);
            System.out.println("Время потраченное на вычисление (наносекунд): " + timework);

        }
    }
}
