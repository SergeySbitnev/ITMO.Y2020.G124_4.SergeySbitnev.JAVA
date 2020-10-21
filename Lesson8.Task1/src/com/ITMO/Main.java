package com.ITMO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //System.out.println(arrayInt.length);
        try{
            System.out.println("Создание двумерного массива.");
            System.out.print("Введите количество рядов массива: ");
            int row = scanner.nextInt();
            System.out.print("Введите количество линий массива: ");
            int line = scanner.nextInt();

            int[][] arrayInt = new int[row][line];


            int max = 0;
            for(int i = 0; i < row; i++ ){
                for(int j = 0; j < line; j++) {
                    System.out.print("Введите [" + i + "][" + j + "] элемент массива: ");
                    arrayInt[i][j] = scanner.nextInt();
                    if (max < arrayInt[i][j]) max = arrayInt[i][j];
                }
            }
            System.out.println("Наибольший элемент массива: " + max);
        }
        catch (NegativeArraySizeException | ArrayIndexOutOfBoundsException e){
            System.out.println("Введено не верное значение размера массива.");
        }
        catch (InputMismatchException e){
            System.out.println("Ошибка ввода значении.");
        }




    }
}
