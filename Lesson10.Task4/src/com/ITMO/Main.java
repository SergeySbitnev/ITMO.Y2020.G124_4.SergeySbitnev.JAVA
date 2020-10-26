package com.ITMO;

class Say{
    private int otv = 0;
    public synchronized void sayPetya(){
        while (otv == 0){
            try {
                wait();
            }
            catch (InterruptedException e) {
            }

        }
        otv--;
        System.out.println("Я Петя!");
        notify();
    }

    public synchronized void sayVasya(){
        while (otv == 1){
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        otv++;
        System.out.println("Я Вася!");
        notify();
    }
}

class ThreadPetya implements Runnable{

    Say say;
    ThreadPetya(Say say){
        this.say = say;
    }

    @Override
    public void run() {
        while (true){
            say.sayPetya();
        }
        /*
        for (int i = 1; i < 6; i++){
            say.sayPetya();
        }*/

    }
}

class ThreadVasya implements Runnable{

    Say say;
    ThreadVasya(Say say){
        this.say = say;
    }

    @Override
    public void run() {
        while (true){
            say.sayVasya();
        }
        /*
        for (int i = 1; i < 6; i++){
            say.sayVasya();
        }*/

    }
}


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Say say = new Say();

        ThreadPetya threadPetya = new ThreadPetya(say);
        ThreadVasya threadVasya = new ThreadVasya(say);


        new Thread(threadPetya).start();
        new Thread(threadVasya).start();





    }
}
