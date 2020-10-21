package com.ITMO;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
            String line;
            ArrayList<String> text = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                text.add(line);
            }

            for (String s : text){
                System.out.println(s);
            }
            System.out.println(text.size());

        } catch (FileNotFoundException e) {
            System.out.println("Не удается найти указанный файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
