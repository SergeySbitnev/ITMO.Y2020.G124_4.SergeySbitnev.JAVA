package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //System.out.println(arrayInt.length);
        try {
            System.out.println("Создание двумерного массива.");
            System.out.print("Введите количество рядов массива: ");
            String row = scanner.nextLine();
            System.out.print("Введите количество линий массива: ");
            String line = scanner.nextLine();

            int n = Integer.parseInt(row);
            int m = Integer.parseInt(line);

            int[][] arrayInt = new int[n][m];

            int max = 0;
            int maxI = 0;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    arrayInt[i][j] = (int) (Math.random() * 100);
                    sum += arrayInt[i][j];
                }
                if (sum > max) {
                    max = sum;
                    maxI = i;
                }
            }

            System.out.println("Строка с максимой суммой элементов двумерного масива: " + ++maxI + " сумма элементов: " + max);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(arrayInt[i][j] + " ");
                }
                System.out.println("\n");
            }

        }
        catch (NegativeArraySizeException | ArrayIndexOutOfBoundsException e){
            System.out.println("Введено не верное значение размера массива.");
        }
        catch (NumberFormatException e){
            System.out.println("Введеные значения должны содержать представления числа.");
        }
    }
}
