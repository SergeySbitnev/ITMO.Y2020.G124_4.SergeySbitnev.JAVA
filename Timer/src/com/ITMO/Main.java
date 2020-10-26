package com.ITMO;


import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class ScheduledTask  extends TimerTask{
    Date now;

    @Override
    public void run() {
        now = new Date();
        System.out.println("Time is: " + now);
    }
}

public class Main {

    public static void main(String[] args) {

        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        date.set(
                Calendar.DAY_OF_WEEK,
                Calendar.MONDAY
        );
        date.set(Calendar.HOUR, 4);
        date.set(Calendar.MINUTE, 6);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        timer.schedule(
                new ScheduledTask(),
                date.getTime(),
                1000 * 60 * 60 * 24 * 7
        );
    }
}
