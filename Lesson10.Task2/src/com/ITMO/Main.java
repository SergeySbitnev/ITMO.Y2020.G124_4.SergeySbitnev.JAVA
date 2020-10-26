package com.ITMO;

import javax.swing.plaf.nimbus.State;

class MyThread extends Thread{

    public void State(){
        System.out.println("Поток: " + getName() + " состояние: " + getState());
    }

    MyThread(String name){
        super(name);
        State();
    }
    @Override
    public void run(){
        for(int i = 0; i <= 10; i++){
            System.out.println("Поток: " + getName() + " пишет: " + i);
            try {
                State();
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class Main {


    public static void main(String[] args) throws InterruptedException {
/*
        for (int i = 1; i <= 10; i++) {
            new MyThread("Thread" + i).start();
        }*/

        MyThread th = new MyThread("New Поток");
        System.out.println(th.getState());
        th.start();
        System.out.println(th.getState());
        th.sleep(300);
        System.out.println(th.getState());



    }
}
