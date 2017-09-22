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
public class Even {

    private int n = 0;

    public synchronized int next() {    // Added synchronized so only one thread
        n++;                            // can run this method at a time
        n++;
        return n;
    }

}
