package com.ITMO;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br1 = new BufferedReader(new FileReader("inText1.txt"));
             BufferedReader br2 = new BufferedReader(new FileReader("inText2.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("outText.txt"))) {

            String line;
            ArrayList<String> text = new ArrayList<String>();

            while ((line = br1.readLine()) != null) {
                text.add(line);
            }
            while ((line = br2.readLine()) != null) {
                text.add(line);
            }

            for (String s : text){
                bw.write(s);
                bw.write("\n");
            }

            System.out.println("Файлы успешно объединены.");

        } catch (FileNotFoundException e) {
            System.out.println("Не удается найти указанный файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
