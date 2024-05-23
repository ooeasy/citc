package com.citc;

public class thread {

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("线程1：我要等待");
                try {
                    Thread.sleep(1000);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1：我被唤醒了");
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("线程3：我要等待");
                try {
                    lock.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程3：我被唤醒了");
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("线程2：我要唤醒");
                lock.notifyAll();
                System.out.println("线程2：我已经唤醒了");
            }
        }).start();
    }
}


