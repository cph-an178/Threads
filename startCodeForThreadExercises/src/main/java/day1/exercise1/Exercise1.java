/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1.exercise1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander
 */
public class Exercise1 {

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = () -> {
            long i = 1;
            long j = Long.MAX_VALUE;
            while (i <= j) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                i++;
            }
        };

        Runnable r2 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Runnable r3 = () -> {
            int i = 10;
            long start = System.currentTimeMillis();
            long end = start + 10000; // 10000 milisec = 10 sec
            while (System.currentTimeMillis() < end) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
        };

        Thread thread1 = new Thread(r1, "Thread1");
        Thread thread2 = new Thread(r2, "Thread2");
        Thread thread3 = new Thread(r3, "Thread3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
