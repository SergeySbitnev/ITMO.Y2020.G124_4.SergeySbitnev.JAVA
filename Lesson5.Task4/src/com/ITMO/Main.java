package com.ITMO;

public class Main {

    public static void main(String[] args) {
        String str1 = "Говорил попугай попугаю: «Я тебя, попугай, попугаю!» Попугаю в ответ попугай: «Попугай, попугай, попугай!»";
        String str2 = "попугай";
        String str3;
        int sum = 0;

        str1 = str1.concat(" ");
        for (int i = 0; i < str1.length()-str2.length()-1; i++){
            str3 = str1.substring(i, i+7);
            if (str3.equals(str2)) sum++;

        }
        System.out.println("В указанной строке слово " + str2 + " встречается " + sum + " раз(а).");
    }
}
