package com.ITMO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] word = new String[5];
        System.out.println("Введите 5 слов для их склейки через запятую: ");
        for(int i = 0; i < word.length; i++){
            word[i] = scanner.nextLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length; i++){
            sb.append(word[i]);
            if (i < word.length - 1) sb.append(", ");
        }

        System.out.println(sb);

    }
}
