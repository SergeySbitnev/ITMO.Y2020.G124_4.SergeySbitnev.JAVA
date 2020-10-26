package com.ITMO;

class Counter {
    int count = 0 ;
    public synchronized void increment() {
        count = count + 1 ;
    }
    public int getCount() {
        return count ;
    }
}

class MyThread extends Thread{
    private Counter c;

    MyThread(String name, Counter c){
        super(name);
        this.c = c;
    }
    @Override
    public void run(){

        for(int i = 0; i < 1000; i++){
            c.increment();
        }
        System.out.println("Поток: " + getName() + " дал ответ: " + c.getCount());
    }
}

public class Main {

    public static void main(String[] args) {
        Counter c = new Counter();
        for (int i = 1; i <= 100; i++){
            new MyThread("Thread" + i, c).start();
        }
    }


}
