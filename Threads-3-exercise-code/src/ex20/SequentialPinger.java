package ex20;

/*
 * Code taken from 
 * http://crunchify.com/how-to-get-ping-status-of-any-http-end-point-in-java/
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import sun.security.util.Length;

public class SequentialPinger {

    public static void main(String args[]) throws Exception {

        long start = System.nanoTime();

        String[] hostList = {"http://crunchify.com", "http://yahoo.com",
            "http://www.ebay.com", "http://google.com",
            "http://www.example.co", "https://paypal.com",
            "http://bing.com/", "http://techcrunch.com/",
            "http://mashable.com/", "http://thenextweb.com/",
            "http://wordpress.com/", "http://cphbusiness.dk/",
            "http://example.com/", "http://sjsu.edu/",
            "http://ebay.co.uk/", "http://google.co.uk/",
            "http://www.wikipedia.org/",
            "http://dr.dk", "http://pol.dk", "https://www.google.dk",
            "http://phoronix.com", "http://www.webupd8.org/",
            "https://studypoint-plaul.rhcloud.com/", "http://stackoverflow.com",
            "http://docs.oracle.com", "https://fronter.com",
            "http://imgur.com/", "http://www.imagemagick.org"
        };

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<Future<String>>();

        for (int i = 0; i < hostList.length; i++) {
            MyCallable mc = new MyCallable(hostList[i]);
            Future<String> future = executor.submit(mc);
            list.add(future);
        }
        int i = 0;
        for (Future<String> future : list) {
            String url = hostList[i];
            int size = url.length();
            
            if (size <= 14) {
                System.out.println(url + "\t\t\t\tStatus:" + future.get());
            }
            else if (size >= 24 && size < 30){
                System.out.println(url + "\t\tStatus:" + future.get());
            }
            else if (size >= 30 ) {
                System.out.println(url + "\tStatus:" + future.get());
            }
            else {
                System.out.println(url + "\t\t\tStatus:" + future.get());
            }
                
            i++;
        }

        long end = System.nanoTime();
        System.out.println("Time Sequential: " + ((end - start) / 1000000)); // Get time in milliseconds

    }

    // Run as sequence:
    //  1 : 19,267 seconds | 2 : 13,002 seconds | 3 : 14,895 seconds
    //  Avg: 15.721 seconds
    
    // Run as Callable
    // 1 : 2,520 seconds | 2 : 2,487 seconds | 3 : 2,143 seconds
    // Avg: 2,383 seconds
}
