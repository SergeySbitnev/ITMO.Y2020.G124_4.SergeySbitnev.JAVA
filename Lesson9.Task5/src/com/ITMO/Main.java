package com.ITMO;

import java.io.File;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        File dir = new File("C:\\ITMO.Y2020.G124_4.SergeySbitnev.JAVA\\Lesson9.Task5");
        ArrayList<String> listName = new ArrayList<String>();

        String searchLine = "древесный уголь";
        String interLine;

        for(File item: dir.listFiles()){
            String itemName = item.getName().concat(" ");
            for(int i = 0; i < itemName.length()-searchLine.length(); i++){
                interLine = itemName.substring(i, i + searchLine.length());
                if (interLine.equals(searchLine)) {
                    listName.add(item.getName());
                }
            }
        }
        for(String s: listName){
            System.out.println(s);
        }
    }
}
