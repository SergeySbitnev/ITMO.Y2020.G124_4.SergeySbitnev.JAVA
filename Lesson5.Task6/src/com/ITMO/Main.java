package com.ITMO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("readme.txt")), "UTF-8");
        content = content.toLowerCase();
        int[] sum = new int[33];
        for(int i = 0; i < content.length(); i++){
            char s = content.charAt(i);
            if (s >= 'а' && s <= 'я'){
                sum[s - 'а']++;
            } else {
                if (s == 'ё') sum[s - 'а' - 1]++;
            }
        }

        for(int i = 0; i <sum.length-1; i++){
            System.out.println((char)(i + 'а') + " = " + sum[i]);
        }
        System.out.println((char)(1105) + " = " + sum[32]);
/*
        System.out.println((int)('я'-'а'));
        System.out.println((int)('я'));
        System.out.println((int)('ё'));*/
        System.out.println((char)(1104));



    }
}
