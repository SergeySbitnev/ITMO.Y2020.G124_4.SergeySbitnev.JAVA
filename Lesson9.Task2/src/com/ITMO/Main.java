package com.ITMO;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt"))) {

            ArrayList<String> text = new ArrayList<String>();
            text.add("У лукоморья дуб зелёный;");
            text.add("Златая цепь на дубе том:");
            text.add("И днём и ночью кот учёный");
            text.add("Всё ходит по цепи кругом;");
            text.add("Идёт направо — песнь заводит,");
            text.add("Налево — сказку говорит.");

            for (String s : text){
                bw.write(s);
                bw.write("\n");
            }

            System.out.println("Запись в файл выполнена.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
