package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Данное приложение вычисляет алгебраическую сумму вида: 1^k+2^k+3^k+...+N^k");
        System.out.print("Введите значение N: ");
        int N = scanner.nextInt();
        System.out.print("Введите значение k: ");
        int k = scanner.nextInt();

        int sum = 0;

        for(int i = 1; i <= N; i++){
            sum += Math.pow(i, k);
        }

        System.out.println("Ответ: " + sum);
	// write your code here
    }
}
