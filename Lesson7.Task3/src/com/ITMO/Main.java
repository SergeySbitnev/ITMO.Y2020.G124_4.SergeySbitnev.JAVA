package com.ITMO;

import java.util.Arrays;
import java.util.Comparator;



public class Main {

    public static void main(String[] args) {
	    String[] str = new String[4];
	    str[0] = "Под лежачий камень и вода не течет. 1234";
	    str[1] = "Без труда не выловишь и рыбку из пруда. 12";
	    str[2] = "Дело не сдвинется с места, если ничего не предпринимать. 132";
	    str[3] = "Был бы лес, соловьи прилетят.11111";

		System.out.println("Начальный массив строк: ");
		for(String h: str){
			System.out.println(h);
		}

		System.out.println("\nСортировка по алфавиту: ");
        Arrays.sort(str);
        for(String h: str){
			System.out.println(h);
		}

		System.out.println("\nСортировка по длине строки: ");
		Comparator<String> stringLengthComparator = new SortByLength();
        Arrays.sort(str, stringLengthComparator);
		for(String h: str){
			System.out.println(h);
		}

		System.out.println("\nСортировка по количеству цифр: ");
		Comparator<String> stringNumComparator = new SortByNum();
		Arrays.sort(str, stringNumComparator);
		for(String h: str){
			System.out.println(h);
		}
    }
}
