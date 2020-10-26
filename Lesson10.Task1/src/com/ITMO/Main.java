package com.ITMO;

class MyThread extends Thread{


    MyThread(String name) {
        super(name);
    }

    @Override
    public void run(){
        for(int i = 0; i <= 100; i++){
            System.out.println(getName() + " " + i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class Main {


    public static void main(String[] args) {

	    for (int i = 1; i <= 10; i++){
	        new MyThread("Поток " + i).start();
        }
    }
}
