package com.ITMO;

import java.util.Scanner;

public class Main {

    static boolean Polidrom(String str){
       str = str.toLowerCase();
       int len = str.length();
       int start = 0;
       int finish = len - 1;
       boolean otv = true;

       while (start < finish){
           if (str.charAt(start) != str.charAt(finish)) {
               otv = false;
               break;
           }
           start++;
           finish--;
       }
       return otv;
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
