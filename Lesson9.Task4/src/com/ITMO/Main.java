package com.ITMO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("inText.txt");
             FileOutputStream outputStream = new FileOutputStream("outText.txt")) {

            byte[] data = new byte[inputStream.available()];

            inputStream.read(data, 0, data.length);
            outputStream.write(data);

            System.out.println("Копирование файла завершено.");


        }
        catch (FileNotFoundException e) {
            System.out.println("Не удается найти указанный файл.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
