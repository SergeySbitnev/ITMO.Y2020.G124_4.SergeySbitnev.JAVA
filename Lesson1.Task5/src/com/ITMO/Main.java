package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Данная программа вычисляет N-ый элемент ряда Фибоначчи.");
        System.out.print("Введите N: ");
        int num = scanner.nextInt();

        long fNum1 = 0;
        long fNum2 = 1;


        if (num > 1) {
            System.out.print(fNum1 + " " + fNum2);
            for (int i = 2; i < num; i++) {
                fNum2 = fNum2 + fNum1;
                fNum1 = fNum2 - fNum1;
                System.out.print(" " + fNum2);
            }
            System.out.println("\n" + num + "-й элемент ряда Фибоначчи: " + fNum2);
        } else if (num == 1){
            System.out.println("1-й элемент ряда Фибоначчи: 0");
        } else {
            System.out.println("Ошибка ввода значения. Попробуйте еще раз.");
        }


    }
}
