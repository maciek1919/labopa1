package zadanie2v4;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

//stworzyc klase ksiazke z dwoma polami nienapisana, napisana + dwie kolejki ksiazki napisane i nienapisane
public class ProstyCzytelnik implements Czytelnik {

    private BlockingQueue<Integer> bq;
    private BlockingQueue<String> przeczytane;
    private int pojemnosc;

    public ProstyCzytelnik(BlockingQueue<Integer> bq,int pojemnosc, BlockingQueue<String> przeczytane) {
        this.bq = bq;
        this.przeczytane = przeczytane;
        this.pojemnosc = pojemnosc;
    }

    @Override
    public void run() {
            while(przeczytane.size() != pojemnosc){
                czytaj();
        }
    }

    @Override
    public void czytaj() {
        try {
            sleeep(1000);
//            Thread.yield();
            int a = bq.take();
            //System.out.println("sprawdzanie ksiazki nr: " + a + "przez czytelnika: "+ Thread.currentThread().getName());
            synchronized (bq){
                String abc = (Thread.currentThread().getName() + a);
                if(!przeczytane.contains(abc)) {
                    String s = "Przeczytano [" + a + "] przez czytelnika: " + Thread.currentThread().getName();
                    przeczytane.put(abc);
                    System.out.println(s);
                    System.out.println("Liczba przeczytanych ksiazek: " + przeczytane.size());
                }
                bq.put(a);
            }
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
