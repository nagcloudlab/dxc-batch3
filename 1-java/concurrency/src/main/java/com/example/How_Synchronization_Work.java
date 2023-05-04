package com.example;

import java.util.concurrent.TimeUnit;

class Office{
    private static Object lock=new Object();
    public  void room1() throws InterruptedException {
       synchronized (lock){
           String tName=Thread.currentThread().getName();
           System.out.println(tName+" entering room1");
           //Computation / IO
           TimeUnit.SECONDS.sleep(3);
           System.out.println(tName+" leaving room1");
       }
    }
    public   void room2() throws InterruptedException {
        synchronized (lock){
            String tName=Thread.currentThread().getName();
            System.out.println(tName+" entering room2");
            //Computation / IO
            TimeUnit.SECONDS.sleep(3);
            System.out.println(tName+" leaving room2");
        }
    }
}

public class How_Synchronization_Work {
    public static void main(String[] args) {
        Office office1=new Office();
        Office office2=new Office();
        Runnable roo1Work=()->{
            try {
                office1.room1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable roo2Work=()->{
            try {
                office2.room1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1=new Thread(roo1Work,"T1");
        Thread t2=new Thread(roo2Work,"T2");
        t1.start();
        t2.start();


    }
}
