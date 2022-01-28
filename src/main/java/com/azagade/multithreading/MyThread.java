package com.azagade.multithreading;

public class MyThread {

public static void main(String[] args){
    Thread t1 = new Thread(){
        @Override
        public void run() {
            System.out.println("Thread t1 is running" + " " + this.getName() + this.getId());
            System.out.println(this.getState());
        }
    };

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread t2 is running");
        }
    });

    t1.start();
    t2.start();

    Thread t3 = new MyAlternateThread();
    t3.start();

    Thread t4 = new Thread(new MyRunnable());
    t4.start();
    t4.interrupt();
    if(t4.isInterrupted()){
        System.out.println("t4 is interruppted");
    }
    
    System.out.println(t1.getState());
}

}
