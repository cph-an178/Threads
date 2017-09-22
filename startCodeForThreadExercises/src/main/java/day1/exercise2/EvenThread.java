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
public class EvenThread extends Thread {
    
    Even e;
    
    int MAX = 10000;

    public EvenThread(Even e) {
        this.e = e;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < MAX; i++){
            if ( (e.next() % 2) != 0 ) {
                System.out.println("Ups!");
            }
        }
    }
}
