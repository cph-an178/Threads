package day2.webscraper;

public class Tester {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());

        TagCounter tc1 = new TagCounter("http://www.fck.dk");
//        tc1.run();
        tc1.start();
        TagCounter tc2 = new TagCounter("http://www.google.com");
//        tc2.run();
        tc2.start();
        TagCounter tc3 = new TagCounter("http://politiken.dk/");
//        tc3.run();
        tc3.start();

        long start = System.nanoTime();
        tc1.join();
        tc2.join();
        tc3.join();

        System.out.println("Title: " + tc1.getTitle());
        System.out.println("Div's: " + tc1.getDivCount());
        System.out.println("Body's: " + tc1.getBodyCount());

        System.out.println("Title: " + tc2.getTitle());
        System.out.println("Div's: " + tc2.getDivCount());
        System.out.println("Body's: " + tc2.getBodyCount());

        System.out.println("Title: " + tc3.getTitle());
        System.out.println("Div's: " + tc3.getDivCount());
        System.out.println("Body's: " + tc3.getBodyCount());

        long end = System.nanoTime();
        System.out.println("Time Sequential: " + (end - start));
    }

    // A: Because they don't run simultaneously. So only one TagCounter runs at a
    // time
    
    // B: When a class extends Thread it can override run so you can use .start()
    
    // C: .run() runs in a sequence, .start() can run simultaneously.
    //    The main method is done before the threads are done.
    //    Added .join() so each thread must complete before main continues.
    
    // D: With .run() it takes 3432923005 nanoseconds = 3.432 seconds.
    //    With .start() it takes 1193673163 nanoseconds = 1.193 seconds.
    //    So as we can see, with the three threads running simultaneously
    //    it takes a third of the time
}
