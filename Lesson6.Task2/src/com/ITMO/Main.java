package com.ITMO;

import java.util.Scanner;

public class Main {

    static boolean Polidrom(String str){
        return str.equals((new StringBuilder(str)).reverse().toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для проверки на полидром: ");
        String str = scanner.nextLine();
        if (Polidrom(str))
            System.out.println("Это полидром");
        else
            System.out.println("Это не полидром");
    }
}
