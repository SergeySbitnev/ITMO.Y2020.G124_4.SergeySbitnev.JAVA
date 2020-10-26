package com.ITMO;

import java.sql.*;
import java.io.*;

public class conn {
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

    // --------Заполнение таблицы--------
    public static void WriteDB(String chatId, String city) throws SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("INSERT INTO 'subscribe' ('ChatId', 'city') VALUES ('" + chatId + "', '" + city + "'); ");
    }

    public static void DeleteDB(String chatId) throws SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("DELETE FROM 'subscribe' WHERE ChatId = '" + chatId + "'; ");
    }


    // -------- Вывод таблицы--------
    public static void ReadDB() throws ClassNotFoundException, SQLException, IOException {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM subscribe");

        Bot a = new Bot();

        while(resSet.next())
        {
            String id = resSet.getString("ChatId");
            String  city = resSet.getString("city");

            System.out.println( "ChatId = " + id );
            System.out.println( "city = " + city );
            System.out.println();

            try {
                a.sendMsg(id, city);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Bot.sendMsg(id, city);
        }

        resSet.close();
        //System.out.println("Таблица выведена");
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();

        System.out.println("Соединения закрыты");
    }

}

