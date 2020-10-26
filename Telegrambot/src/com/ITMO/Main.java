package com.ITMO;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import java.io.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class ScheduledTask  extends TimerTask {
    Date now;

    @Override
    public void run() {
        try {
            conn.Conn();
            conn.ReadDB();
            conn.CloseDB();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        Thread thread = new Thread(() -> {
            ApiContextInitializer.init();
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

            Timer timer = new Timer();
            Calendar date = Calendar.getInstance();
            date.set(Calendar.HOUR, 4);
            date.set(Calendar.MINUTE, 37);
            date.set(Calendar.SECOND, 0);
            date.set(Calendar.MILLISECOND, 0);
            timer.schedule(
                    new ScheduledTask(),
                    date.getTime(),
                    1000 * 60 * 60 * 24 * 7
            );


            try {
                telegramBotsApi.registerBot(new Bot());
            } catch (TelegramApiRequestException e) {
                e.printStackTrace();
            }
        });
        thread.start();

    }
}
