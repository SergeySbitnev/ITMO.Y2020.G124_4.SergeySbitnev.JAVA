package com.ITMO;

public class Main {

    public static void main(String[] args) {

        int[] myArray1 = {1, 6, 8, 7, 9, 8, 7, 2, 10} ;
        int[][] myArray2 = {{1, 6, 8, 7, 9, 8, 7, 2, 10}, {5, 5, 8, 9, 7, 6, 4, 4, 8, 9, 10, 15, 18}};

        MyIterator myIterator1 = new MyIterator(myArray1);
        MyIterator myIterator2 = new MyIterator(myArray2);

        System.out.println("Итератор одномерного массива: ");
        while (myIterator1.hasNext()){
            System.out.print(myIterator1.next() + " ");
        }

        System.out.println("\nИтератор двумерного массива: ");
        while (myIterator2.hasNext()){
            System.out.print(myIterator2.next() + " ");
        }
    }
}
