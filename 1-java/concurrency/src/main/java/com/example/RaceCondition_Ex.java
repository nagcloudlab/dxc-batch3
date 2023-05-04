package com.example;


class Counter {
    private long count = 0;

    public synchronized void increment() {
        count++;
    }

    public long getCount() {
        return count;
    }
}

public class RaceCondition_Ex {
    public static void main(String[] args) {

        Counter counter = new Counter(); // shared resource

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(counter.getCount()); // 1000 * 1000 = 1000000


    }
}
