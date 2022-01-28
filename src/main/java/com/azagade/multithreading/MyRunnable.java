package com.azagade.multithreading;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Running MyRunnable thread");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        try {
            this.wait(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
    }
}