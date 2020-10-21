package com.ITMO;

public class Main {

//Метод подготовки строки для кодирования
    static String PreparationForCoding (String text){
        //Конвертируем все символы в верхний регистр
        text = text.toUpperCase();
        char[] ch = text.toCharArray();
        text = "";
        //Убираем все символы, кроме букв
        for(int i = 0; i < ch.length; i++){
            if (ch[i] >= 'А' && ch[i] <= 'Я' || ch[i] == 'Ё'){
                text += ch[i];
            }
        }
        return text;
    }

//Медот для кодирования
    static String enCode(String text, String key){
        //Запускаем метод подготовки строки к кодированию
        text = PreparationForCoding(text);

        //Вычисляем количество строк и столбцов
        int column = key.length();
        int row = 0;
        char[] ch = text.toCharArray();
        if (ch.length%column > 0) {
            row = ch.length / column + 1;
        } else {
            row = ch.length / column;
        }
        //Кодируем строку - заполняем новую строку элементами в нужно порядке
        text = "";
        for (int i = 0; i < row; i++){
            int j = i;
            int counter = 0;
            String text2 = "";
            while (counter < column && j < ch.length){
                text += ch[j];
                j += row;
                counter++;
            }
        }
        return text;
    }

//Метод для декодирования
    static String deCode(String text, String key){
        //Вычисляем количество строк и столбцов
        int column = key.length();
        int row = 0;
        char[] ch = text.toCharArray();
        if (ch.length%column > 0) {
            row = ch.length / column + 1;
        } else {
            row = ch.length / column;
        }

        //Кодируем строку - заполняем новую строку элементами в нужно порядке
        text = "";
        for (int i = 0; i < column; i++){
            int j = i;
            int counter = 0;
            while (counter < row && j < ch.length){
                text += ch[j];
                j += column;
                counter++;
            }
        }
        return text;
    }

    public static void main(String[] args) {
	    String text = "Враг будет разбит";
	    String key = "памир";

        System.out.println(text);
        String text2 = enCode(text, key);
        System.out.println(text2);
        System.out.println(deCode(text2, key));


    }
}
