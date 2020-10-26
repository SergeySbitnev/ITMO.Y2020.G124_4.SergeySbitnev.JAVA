package com.ITMO;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator implements Iterator {
    private int sizeArray;
    private int counter = 0;
    private int indexCol = 0;
    private int indexRow = -1;
    private int[] arrayOne;
    private int[][] arrayTwo;

    public MyIterator(int[] array){
        this.arrayOne = array;
        this.sizeArray = array.length;

    }

    public MyIterator(int[][] array){
        this.arrayTwo = array;
        this.indexRow = 0;
        //this.sizeArray = array[0].length * array.length;
        for (int i = 0; i < array.length; i++){
            this.sizeArray += array[i].length;
        }

    }

    @Override
    public boolean hasNext() {
        return counter < sizeArray;
    }

    @Override
    public Object next() {
        if (counter < sizeArray && indexRow == -1) {
            counter++;
            return arrayOne[indexCol++];
        }
        else if(counter < sizeArray && indexRow > -1){
            counter++;
            if (indexCol == arrayTwo[indexRow].length){
                indexCol = 0;
                indexRow++;
            }
            return arrayTwo[indexRow][indexCol++];
        }
        else {
            throw new NoSuchElementException("Больше не элементов.");
        }
    }
}
