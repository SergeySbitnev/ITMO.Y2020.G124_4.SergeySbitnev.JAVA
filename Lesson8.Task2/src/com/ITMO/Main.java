package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //System.out.println(arrayInt.length);
        try{
            System.out.println("Создание двумерного массива.");
            System.out.print("Введите количество рядов массива: ");
            String row = scanner.nextLine();
            System.out.print("Введите количество линий массива: ");
            String line = scanner.nextLine();

            int[][] arrayInt = new int[Integer.parseInt(row)][Integer.parseInt(line)];


            if (arrayInt.length == arrayInt[0].length) System.out.println("Данный двумерный массив является квадратным.");
            else System.out.println("Данный двумерный массив НЕ является квадратным.");
        }
        catch (NegativeArraySizeException | ArrayIndexOutOfBoundsException e){
            System.out.println("Введено не верное значение размера массива.");
        }
        catch (NumberFormatException e){
            System.out.println("Введеные значения должны содержать представления числа.");
        }




    }
}
