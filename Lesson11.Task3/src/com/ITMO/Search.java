package com.ITMO;

public class Search {

    //Пошаговый поиск (перебор по порядку)
    static boolean StepByStep(int[] array, int num){
        System.out.println("Запуск пошагового поиска...");
        boolean answer = false;
        long time = System.nanoTime();
        for (int i = 0; i < array.length; i++){
            if (array[i] == num){
                answer = true;
                break;
            }
        }
        time = System.nanoTime() - time;
        System.out.println("Время пошагового поиска (перебора) составило: " + time + "нс");
        return answer;
    }

    //Бинарный поиск
    static boolean Binary (int[] array, int num){
        System.out.println("Запуск бинарного поиска...");
        boolean answer = false;
        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        long time = System.nanoTime();
        while (low <= high){
            mid = (low + high) / 2;
            if (array[mid] == num){
                answer = true;
                break;
            }
            if (array[mid] > num) high = mid - 1; else low = mid + 1;
        }
        time = System.nanoTime() - time;
        System.out.println("Время бинарного поиска составило: " + time + "нс");
        return answer;
    }
}
