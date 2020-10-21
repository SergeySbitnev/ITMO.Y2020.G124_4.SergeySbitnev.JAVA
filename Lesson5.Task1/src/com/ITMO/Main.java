package com.ITMO;

public class Main {

    static int MaxLength(String[] str){
        int max = 0;
        int index = 0;
        for (int i = 0; i < str.length; i++){
            if (str[i].length() > max) {
                max = str[i].length();
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        String[] str = new String[5];
        str[0] = "В осеннем лесу, на развилке дорог,";
        str[1] = "Стоял я, задумавшись, у поворота;";
        str[2] = "Пути было два, и мир был широк,";
        str[3] = "Однако я раздвоиться не мог,";
        str[4] = "И надо было решаться на что-то.";

        int res = MaxLength(str);
        System.out.println("Самая длинная строка: " + str[res] + "\nЕё длина: " + str[res].length() + " символа");
    }
}
