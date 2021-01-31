package zadanie2v4;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

//stworzyc klase ksiazke z dwoma polami nienapisana, napisana + dwie kolejki ksiazki napisane i nienapisane
public class ProstyCzytelnik implements Czytelnik {

    private BlockingQueue<String> bq = null;
    private final int a;
    private final CopyOnWriteArrayList<String> przeczytane;
    public ProstyCzytelnik(BlockingQueue<String> bq, int a, CopyOnWriteArrayList<String> przeczytane) {
        this.bq = bq;
        this.a = a;
        this.przeczytane = przeczytane;
    }

    @Override
    public void run() {
        for(int i = przeczytane.size(); i < a; i ++){
            czytaj();
        }
    }

    @Override
    public void czytaj() {
        try {
            // Thread.yield();
            sleeep(2000);
            String s = bq.take();
            bq.add(s);
            przeczytane.add(s);
        System.out.println("Przeczytano [" + przeczytane.get(przeczytane.size()-1) + "] przez czytelnika: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleeep(long t) {
        try {
            Thread.sleep((long) (t * Math.random()));
        } catch (InterruptedException ie) {
        }
    }
}
