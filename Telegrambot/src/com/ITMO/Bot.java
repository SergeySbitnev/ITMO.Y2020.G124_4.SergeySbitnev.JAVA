package com.ITMO;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;


public class Bot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        System.out.println(message);
        //String subs = message.equalsIgnoreCase("/subscribe");
        if (message.contains("/subscribe")) {
            try {
                conn.Conn();
                conn.WriteDB(update.getMessage().getChatId().toString(), message.substring(11));
                conn.CloseDB();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                Subscribe(update.getMessage().getChatId().toString(), message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (message.equalsIgnoreCase("/unsubscribe")) {
            try {
                conn.Conn();
                conn.DeleteDB(update.getMessage().getChatId().toString());
                conn.CloseDB();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                Unsubscribe(update.getMessage().getChatId().toString(), message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                sendMsg(update.getMessage().getChatId().toString(), message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public synchronized void Subscribe(String chatId, String s) throws IOException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText("Вы подписаны.");

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            //log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

    public synchronized void Unsubscribe(String chatId, String s) throws IOException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText("Вы отписаны.");

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            //log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

    public synchronized void sendMsg(String chatId, String s) throws IOException {
        String str = "";
        SendMessage sendMessage = new SendMessage();

        try {
            String inquiry = "http://api.openweathermap.org/data/2.5/weather?q=" + s + "&APPID=884a15e85a8d86c573b9fd306da02e8a";
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
            //System.out.println(newLine);

            JsonObject obj = (JsonObject) new JsonParser().parse(newLine);
            JsonObject obj2 = (JsonObject) obj.get("main");
            String tempNow = String.valueOf(obj2.get("temp"));
            String tempMin = String.valueOf(obj2.get("temp_min"));
            String tempMax = String.valueOf(obj2.get("temp_max"));
            String pressure = String.valueOf(obj2.get("pressure"));
            String humidity = String.valueOf(obj2.get("humidity"));
            JsonObject obj3 = (JsonObject) obj.get("wind");
            String wind = String.valueOf(obj3.get("speed"));

            str = " Погода в городе: " + s +
                    "\nТемпература сейчас: " + KelvinConvert(tempNow) +
                    "\nMIN темп. сегодня: " + KelvinConvert(tempMin) +
                    "\nMAX темп. сегодня: " + KelvinConvert(tempMax) +
                    "\nДавление: " + pressure +
                    "\nВлажность: " + humidity +
                    "\nСкорость ветра: " + wind + "м/с";

        }
        catch (IOException e){
            str = "Город не найден.";

        } finally {
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(chatId);
            sendMessage.setText(str);
        }

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            //log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

    public String KelvinConvert(String temp){
        Double a = Double.valueOf(temp);
        a -=  273.15;
        return String.valueOf(a);
    }


    @Override
    public String getBotUsername() {
        return "SSVWeather_bot";
    }

    @Override
    public String getBotToken() {
        return "1239926202:AAGChjnfgXJQoO-wHh02EjP16AVWOyhknZo";
    }
}
