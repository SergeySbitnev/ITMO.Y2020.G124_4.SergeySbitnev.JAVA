package com.ITMO;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        File dir = new File("C:\\ITMO.Y2020.G124_4.SergeySbitnev.JAVA\\Lesson9.Task6");
        ArrayList<String> listName = new ArrayList<String>();

        String searchLine = "древесный уголь";
        String interLine;

        for(File item: Objects.requireNonNull(dir.listFiles())) {
            if (item.isFile()) {
                try (BufferedReader br = new BufferedReader(new FileReader(item.getName()))) {
                    String line;

                    while ((line = br.readLine()) != null) {
                        line = line.concat(" ");
                        for(int i = 0; i < line.length()-searchLine.length(); i++){
                            interLine = line.substring(i, i + searchLine.length());
                            if (interLine.equals(searchLine)) {
                                listName.add(item.getName());
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for(String s: listName){
            System.out.println(s);
        }

    }
}
