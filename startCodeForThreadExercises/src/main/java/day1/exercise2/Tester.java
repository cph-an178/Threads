/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1.exercise2;

/**
 *
 * @author Alexander
 */
public class Tester {

    public static void main(String[] args) throws InterruptedException {

        Even e = new Even();
        
        EvenThread t1 = new EvenThread(e);
        EvenThread t2 = new EvenThread(e);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Final Result " + e.next());
    }
    
    // A: Yes, 
    // B: 100% of the time when each thread is run 10000 times
    // C & D: See Even.java class
}
