package com.ITMO;

public class Main {

    static boolean IncreasingSequence(int[] array){
        boolean answer = true;
        for (int i = 0; i < array.length-1; i++){
            if (array[i] > array[i+1]){
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] MyArray1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] MyArray2 = {4, 2, 6, 4, 11, 2, 7, 4, 4, 1};

        if (IncreasingSequence(MyArray1)){
            System.out.println("Данный массив является возрастающей последовательностью!");
        } else{
            System.out.println("Данный массив НЕ является возрастающей последовательностью!");
        }

        if (IncreasingSequence(MyArray2)){
            System.out.println("Данный массив является возрастающей последовательностью!");
        } else{
            System.out.println("Данный массив НЕ является возрастающей последовательностью!");
        }
    }
}
