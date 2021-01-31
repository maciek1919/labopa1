package zadanie2v4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProstyPisarz implements Pisarz{

    private BlockingQueue<Integer> bq = null;
//    private int l = 1;
//    private AtomicInteger l = new AtomicInteger(1);
    private int n;
    private AtomicInteger i;

    public ProstyPisarz(BlockingQueue<Integer> bq, int n, AtomicInteger i) {
        this.bq = bq;
        this.i = i;
        this.n = n;
    }


    @Override
    public void pisz(){
        try {
            int book = i.get();
            sleeep(1000);

            synchronized (bq) {
                bq.put(book);
                System.out.println("Napisano: [ książke numer: " + book + "] autor: " + Thread.currentThread().getName());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        int i = bq.remainingCapacity();
        while(i.getAndIncrement() < n) {
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
