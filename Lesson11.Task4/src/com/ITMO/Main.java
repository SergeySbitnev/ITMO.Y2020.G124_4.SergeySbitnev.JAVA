package com.ITMO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

interface DownloadListener{
    void onError();
    void onDownload();
    void threadOnRunnable(Thread.State a, long b);
}

class Listener implements DownloadListener{

    @Override
    public void onError() {
        System.out.println("Ошибка выполнения потока");
    }

    @Override
    public void onDownload() {
        System.out.println("Поток выполнил запрос и распарсил результат.");
    }

    @Override
    public void threadOnRunnable(Thread.State a, long b) {
        System.out.println("Поток запущен...");
        System.out.println("Состояние потока: " + a);
        System.out.println("ID потока: " + b);
    }
}


class MyThread extends Thread {
    private final String inquiry;
    private final Listener listeners;

    MyThread(String inquiry, Listener listeners) {
        this.inquiry = inquiry;
        this.listeners = listeners;
    }

    @Override
    public void run() {
        //Создаем и открываем запрос
        try {
            listeners.threadOnRunnable(getState(), getId());
            URL url = new URL(inquiry);
            URLConnection urlConnection = url.openConnection();

            String line = "";
            String newLine = "";

            //Получаем ответ и формируем строку
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((line = bufferedReader.readLine()) != null) {
                newLine += line;
            }

            //Распарсинг ответа
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Wiki a = gson.fromJson(newLine, Wiki.class);

            //Вывод ответа
            /*for (Search b : a.getQuery().getSearch()) {
                System.out.println("Заголовок: " + b.getTitle());
                System.out.println("\tID страницы: " + b.getPageid());
                System.out.println("\tРазмер: " + b.getSize());
                System.out.println("\tКоличество символов: " + b.getWordcount() + "\n");
            }*/
            listeners.onDownload();

        } catch (MalformedURLException e) {
            listeners.onError();
            e.printStackTrace();
        } catch (IOException e) {
            listeners.onError();
            e.printStackTrace();
        }
    }
}


public class Main {

    public static void main(String[] args) throws IOException {

        //Запрос для поиска
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите запрос для поиска по Wiki: ");
        String searchLine = scanner.nextLine();
        System.out.println();

        //Encoder запроса и образование ссылки
        searchLine = URLEncoder.encode(searchLine, "UTF-8");
        String inquiry = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=\"" + searchLine + "\"";

        Listener listeners = new Listener();
        MyThread thread = new MyThread(inquiry, listeners);
        thread.start();

    }
}