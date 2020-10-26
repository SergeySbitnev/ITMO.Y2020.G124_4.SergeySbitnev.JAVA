package com.ITMO;


import com.google.gson.*;
import netscape.javascript.JSObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.sql.*;

class conn {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\TELEGRAM.s3db");

        System.out.println("База Подключена!");
    }

    // --------Создание таблицы--------
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public static void WriteDB() throws SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("DELETE FROM 'subscribe' WHERE ChatId = '322661632'; ");
        String ChatId = "1234";
        String city = "Moscow";
        //statmt.execute("INSERT INTO 'subscribe' ('ChatId', 'city') VALUES ('" + ChatId + "', '"+ city +"'); ");
        //statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
        //statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");

        System.out.println("Таблица заполнена");
    }

    // -------- Вывод таблицы--------
    public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM subscribe");

        while(resSet.next())
        {
            String id = resSet.getString("ChatId");
            String  city = resSet.getString("city");

            System.out.println( "ChatId = " + id );
            System.out.println( "city = " + city );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }

}


public class Main {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        conn.Conn();
        //conn.CreateDB();
        conn.WriteDB();
        conn.ReadDB();
        conn.CloseDB();





        /*Scanner scanner = new Scanner(System.in);
        //System.out.print("Введи город: ");
        //String country = scanner.nextLine();
        String country = "Moscow";
        String inquiry = "http://api.openweathermap.org/data/2.5/weather?q=" + country + "&APPID=884a15e85a8d86c573b9fd306da02e8a";
        System.out.println(inquiry);
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
        System.out.println(newLine);


        JsonObject obj = (JsonObject) new JsonParser().parse(newLine);
        JsonObject obj2 = (JsonObject) obj.get("main");
        System.out.println(obj2.get("temp"));


       /* //Распарсинг ответа
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        /*Weather a = gson.fromJson(newLine, Weather.class);

        //Вывод ответа
        for (Main b : a.getMain()) {
                System.out.println("Заголовок: " + b.getTitle());
                System.out.println("\tID страницы: " + b.getPageid());
                System.out.println("\tРазмер: " + b.getSize());
                System.out.println("\tКоличество символов: " + b.getWordcount() + "\n");*/
    }
}
