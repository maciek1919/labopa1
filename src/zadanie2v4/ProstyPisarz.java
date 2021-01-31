package zadanie2v4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProstyPisarz implements Pisarz{

    private BlockingQueue<String> bq = null;
//    private int l = 1;
//    private AtomicInteger l = new AtomicInteger(1);
    private AtomicInteger i;
    private int rozmiar = 0;

    public ProstyPisarz(BlockingQueue<String> bq, int rozmiar, AtomicInteger i) {
        this.bq = bq;
        this.rozmiar = rozmiar;
        this.i = i;
    }


    @Override
    public void pisz() {
        try {
            sleeep(1000);
            String s = "Książke numer:  " + i.incrementAndGet();
            bq.put(s);
            System.out.println("Napisano: [" + s + "] autor: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < rozmiar; i++) {
                pisz();
        }
    }
    private void sleeep(long t) {
        try {
            Thread.sleep((long) (t * Math.random()));
        } catch (InterruptedException ie) {
        }
    }
}
