package com.ITMO;

public class Main {

    static void ReverseArray(int[] array){
        int i = 0;
        int j = array.length-1;
        int RepVar = 0;
        while (i < j){
            RepVar = array[i];
            array[i] = array[j];
            array[j] = RepVar;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        int[] MyArray = {8, 7, 5, 1, 21, 2, 3, 6, 10, 12, 74, 77, 55, 14, 33, 31, 20, 96, 6, 8, 7, 1, 1, 2, 3, 16, 17};
        ReverseArray(MyArray);

        System.out.print("Данный массив в обратном порядке: ");
        for(int i = 0; i < MyArray.length; i++){
            System.out.print(MyArray[i] + " ");
        }

    }
}
