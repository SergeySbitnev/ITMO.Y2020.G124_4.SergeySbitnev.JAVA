package com.ITMO;

public class Main {

    static int IndexOf (int[] array, int num){
        int index = -1;
        for (int i = 0; i < array.length; i++){
            if (array[i] == num){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int[] MyArray = {2, 6, 7, 4, 1, 3, 5, 14, 27, 33, 4, 1, 10, 8, 24, 11, 15};
        int num = 14;
        int index = IndexOf(MyArray, num);
        if (index == -1){
            System.out.println("Данный элемент не входит в массив!" + index);
        } else{
            System.out.println("Индекс данного элемента: " + index);
        }

        num = 15;
        index = IndexOf(MyArray, num);
        if (index == -1){
            System.out.println("Данный элемент не входит в массив!" + index);
        } else{
            System.out.println("Индекс данного элемента: " + index);
        }

    }
}
