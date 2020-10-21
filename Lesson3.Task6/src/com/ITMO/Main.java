package com.ITMO;

public class Main {

    static int[] EventElements(int[] array){
        int[] newArray = new int[array.length];
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i]%2 == 0){
                newArray[index] = array[i];
                index++;
            }
        }
        int[] finishArray = new int[index];
        //System.out.println(index);
        System.arraycopy(newArray, 0, finishArray, 0, index);
        return finishArray;
    }

    public static void main(String[] args) {
        int[] MyArray = {8, 7, 5, 1, 21, 2, 3, 6, 10, 12, 74, 77, 55, 14, 33, 31, 20, 96, 6, 8, 7, 1, 1, 2, 3, 16};
        int[] newArray = EventElements(MyArray);
        System.out.print("Новый массив из четных чисел: ");
        for (int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }
    }
}
