package com.azagade.multithreading;

public class MyAlternateThread extends Thread{
    @Override
    public void run() {
        //super.run();
        System.out.println("This is alternate thread running.");
    }
}
