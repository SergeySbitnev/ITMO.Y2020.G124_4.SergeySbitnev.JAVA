package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Массив какого размера вы хотите создать: ");

        int quantity = scanner.nextInt();
	    int[] array = ArrayWorks.CreateArray(quantity);

	    ArrayWorks.PrintArray(array);
	    ArrayWorks.SelectionSort(array);
        ArrayWorks.PrintArray(array);

        System.out.print("Какое значение требуется найти: ");
        int num = scanner.nextInt();


        int help = 0;

        for (int i = 0; i < array.length-1; i += array.length / 2){
            int[] newArray = new int[array.length/2 + help];
            System.arraycopy(array, i, newArray, 0,array.length /2 + help);

            Thread thread = new Thread(() -> {
                System.out.println(Search.Binary(newArray, num));
            });
            thread.start();

            if (array.length % 2 > 0) help++;

        }
    }
}
