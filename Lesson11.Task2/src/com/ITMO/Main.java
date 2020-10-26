package com.ITMO;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 5, 6, 8, 9, 10, 1, 5, 9, 1, 1, 8, 10, 5, 9, 11, 12, 999, 11};
        int step = 0;

        Map<Integer, Integer> mapArray = new HashMap<Integer, Integer>();

        do {
            if (!mapArray.containsKey(array[step])){
                int sum = 1;
                for(int i = step+1; i < array.length; i++){
                    if (array[i] == array[step]){
                        sum++;
                    }
                }
                mapArray.put(array[step], sum);
            }
            step++;
        } while (step < array.length);

        for(Map.Entry<Integer, Integer> pair : mapArray.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
