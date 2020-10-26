package com.ITMO;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        File dir = new File("C:\\ITMO.Y2020.G124_4.SergeySbitnev.JAVA\\Lesson9.Task7");
        ArrayList<String> listName = new ArrayList<String>();
        ArrayList<String> listName2 = new ArrayList<String>();
        String searchLine = "древесный уголь";

        Predicate<String> isPositive = x -> {

            if (x.equals(searchLine)){
                return true;
            } else {
                return false;
            }
        };

        for(File item: dir.listFiles()){
            String itemName = item.getName().concat(" ");
            for(int i = 0; i < itemName.length()-searchLine.length(); i++){
                String interLine = itemName.substring(i, i + searchLine.length());
                if (isPositive.test(interLine)) {
                    listName.add(item.getName());
                }
            }
        }

        for(File item: Objects.requireNonNull(dir.listFiles())) {
            if (item.isFile()) {
                try (BufferedReader br = new BufferedReader(new FileReader(item.getName()))) {
                    String line;

                    while ((line = br.readLine()) != null) {
                        line = line.concat(" ");
                        for(int i = 0; i < line.length()-searchLine.length(); i++){
                            String interLine = line.substring(i, i + searchLine.length());
                            if (isPositive.test(interLine)) {
                                listName2.add(item.getName());
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Файлы/папки чье имя содержит искомую строку: ");
        for(String s: listName){
            System.out.println(s);
        }

        System.out.println("\nФайлы чье содержимое имеет ускомую строку: ");

        for(String s: listName2){
            System.out.println(s);
        }









    }
}







